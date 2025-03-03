package com.cch.pokemon.service;

import com.cch.pokemon.dto.PokemonDTO;
import com.cch.pokemon.dto.PokemonReduitDTO;
import com.cch.pokemon.dto.StatIvManquantDTO;
import com.cch.pokemon.entity.*;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.PokemonShinyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service PokemonShiny
 */
@Service
@Transactional
public class PokemonShinyService {

  /**
   * Le repository PokemonShiny
   */
  private final PokemonShinyRepository shinyRepository;

  /**
   * Appel des services des classes associées
   */
  private final NatureService natureService;
  private final DresseurService dresseurService;
  private final PokeballService pokeballService;
  private final TypeService typeService;
  private final SexeService sexeService;
  private final AttaquesService attaquesService;
  private final BoiteService boiteService;
  private final RegionsService regionsService;
  private final BoiteDresseurService boiteDresseurService;
  private final BoiteNatureService boiteNatureService;
  private final BoitePokeballService boitePokeballService;
  private final BoiteTypeService boiteTypeService;
  private final BoiteSexeService boiteSexeService;


  /**
   * Sérialisation d'objet Java au format Json
   */
  private final ObjectMapper objectMapper;

  /**
   * Le constructeur du service
   * @param shinyRepository Injection du repository Shiny
   * @param dresseurService et autres : pour injecter les services nécessaires
   * @param objectMapper Injection de l'ObjectMapper
   */
  public PokemonShinyService(PokemonShinyRepository shinyRepository, NatureService natureService, DresseurService dresseurService,
                             PokeballService pokeballService, TypeService typeService, SexeService sexeService, AttaquesService attaquesService,
                             BoiteService boiteService, RegionsService regionsService, BoiteDresseurService boiteDresseurService,
                             BoiteNatureService boiteNatureService, BoitePokeballService boitePokeballService, BoiteTypeService boiteTypeService,
                             BoiteSexeService boiteSexeService, ObjectMapper objectMapper) {
    this.shinyRepository = shinyRepository;
    this.natureService = natureService;
    this.dresseurService = dresseurService;
    this.pokeballService = pokeballService;
    this.typeService = typeService;
    this.sexeService = sexeService;
    this.attaquesService = attaquesService;
    this.boiteService = boiteService;
    this.regionsService = regionsService;
    this.boiteDresseurService = boiteDresseurService;
    this.boiteNatureService = boiteNatureService;
    this.boitePokeballService = boitePokeballService;
    this.boiteTypeService = boiteTypeService;
    this.boiteSexeService = boiteSexeService;
    this.objectMapper = objectMapper;
  }

  /**
   * Ajouter un shiny avec toutes les relations associées
   * @param numDex le numéro de pokédex
   * @param nomPokemon le nom du shiny
   * @param ivManquant ses Ivs
   * @param idNature sa nature
   * @param idDresseur son dresseur d'origine
   * @param idPokeball sa pokéball de capture
   * @param type1 son type
   * @param type2 le second type s'il en possède un
   * @param idSexe son genre
   * @param attaque1, attaque2, attaque3, attaque4 : la liste de ses attaques
   * @param idBoite sa boite
   * @param position sa position dans la boite
   * @param idRegion sa région d'origine
   * @return Le shiny nouvellement ajouté
   */
  public PokemonShiny save(String numDex, String nomPokemon, Integer idNature,
                           Integer idDresseur, Integer idPokeball, String ivManquant,
                           Integer type1, Integer type2, Integer idSexe,
                           Long attaque1, Long attaque2, Long attaque3, Long attaque4,
                           Integer idBoite, Integer position, Long idRegion) {

    // Récupérer les objets associés à partir des IDs
    Natures nature = natureService.findById(idNature);
    Dresseurs dresseur = dresseurService.findById(idDresseur);
    Pokeballs pokeball = pokeballService.findById(idPokeball);
    Sexe sexe = sexeService.findById(idSexe);
    Types type1Obj = typeService.findById(type1);

    // On n'essaie pas de récupérer un type2 si celui-ci est null
    Types type2Obj = (type2 != null) ? typeService.findById(type2) : null;

    // Pas d'exception ici si type2Obj est null, on laisse juste null si type2 est absente
    Attaques attaque1Obj = attaquesService.findById(attaque1);
    Attaques attaque2Obj = attaquesService.findById(attaque2);
    Attaques attaque3Obj = attaquesService.findById(attaque3);
    Attaques attaque4Obj = attaquesService.findById(attaque4);
    Boites boite = boiteService.findBoiteById(idBoite);
    Regions regionShiny = (idRegion != null) ? regionsService.findById(idRegion) : null;

    // Créer l'objet PokémonShiny
    PokemonShiny pokemonShiny = (type2Obj != null)
      ? new PokemonShiny(numDex, nomPokemon, nature, dresseur, pokeball, ivManquant,
      type1Obj, type2Obj, sexe, attaque1Obj, attaque2Obj, attaque3Obj, attaque4Obj,
      boite, position, regionShiny)
      : new PokemonShiny(numDex, nomPokemon, nature, dresseur, pokeball, ivManquant,
      type1Obj, sexe, attaque1Obj, attaque2Obj, attaque3Obj, attaque4Obj,
      boite, position, regionShiny);

    // Appel de la méthode d'incrémentation des compteurs
    incrementerCompteurs(nature, dresseur, pokeball, type1Obj, type2Obj, idBoite);

    // Appel des services pour gérer les insertions dans les tables de liaison
    boiteDresseurService.updateBoiteDresseur(dresseur, boite);
    boiteNatureService.updateBoiteNature(nature, boite);
    boitePokeballService.updateBoitePokeball(pokeball, boite);
    boiteTypeService.updateBoiteType(type1Obj, boite);
    if (type2Obj != null) {
      boiteTypeService.updateBoiteType(type2Obj, boite);
    }
    boiteSexeService.updateBoiteSexe(sexe, boite);

    // Sauvegarder le PokémonShiny
    return shinyRepository.save(pokemonShiny);
  }

  /**
   * Centraliser l'incrémentation des compteurs
   * @param nature la nature à incrémenter (selon la boite)
   * @param dresseur le dresseur à incrémenter
   * @param pokeball la pokeball à incrémenter
   * @param type1 le type1 à incrémenter (selon la boite)
   * @param type2 le type2 à incrémenter (selon la boite et s'il existe)
   * @param idBoite la boite à vérifier selon les données à incrémenter
   */
  private void incrementerCompteurs(Natures nature, Dresseurs dresseur, Pokeballs pokeball,
                                    Types type1, Types type2, Integer idBoite) {
    // Incrémentation des compteurs pour dresseur, pokeball, et sexe
    dresseurService.incrementerNbShiny(dresseur.getId());
    pokeballService.incrementerNbShiny(pokeball.getId());

    // Si l'ID de la boîte n'est pas 7, 8 ou 9, incrémenter les compteurs pour nature et type
    if (!(idBoite == 7 || idBoite == 8 || idBoite == 9)) {
      natureService.incrementerNbShiny(nature.getId());
      typeService.incrementerNbShiny(type1.getId());
      if (type2 != null) {
        typeService.incrementerNbShiny(type2.getId());
      }
    }
  }

  /**
   * Méthode pour trouver tous les shiny, ordonnés par Id puis par numDex
   * @return la liste ordonnée de tous les shiny
   */
  public List<PokemonDTO> findAllShinies() {
    List<PokemonShiny> shinyList = shinyRepository.findAll();
    return shinyList.stream()
      .map(shiny -> objectMapper.convertValue(shiny, PokemonDTO.class))
      .collect(Collectors.toList());
  }

  /**
   * Méthode pour trouver un shiny par son id (retourne l'entité complète)
   * @param id l'id du shiny recherché
   * @return le shiny trouvé
   */
  public PokemonShiny findShinyById(Integer id) {
    return shinyRepository.findById(id)
      .orElseThrow(() -> new CustomException("Shiny", "id", id)); // Renvoie l'entité
  }

  /**
   * Méthode pour trouver un pokemon par son id
   * @param id L'id du pokemon recherché
   * @return le pokemon trouvé et toutes ses informations
   */
  public Optional<PokemonDTO> findById(Integer id) {
    return shinyRepository.findById(id)
      .map(shiny -> objectMapper.convertValue(shiny, PokemonDTO.class));
  }

  /**
   * Méthode pour trouver un shiny selon son numéro de pokédex
   * @param numDex Le numéro de pokédex recherché
   * @return Les données du pokémon trouvé
   */
  public List<PokemonReduitDTO> findByNumDex(String numDex) {
    List<PokemonReduitDTO> shinies = shinyRepository.findByNumDex(numDex);
    return shinies.stream()
      .map(shiny -> new PokemonReduitDTO(shiny.getId(), shiny.getNumDex(), shiny.getNomPokemon()))
      .collect(Collectors.toList());
  }

  /**
   * Méthode pour trouver et afficher tous les shinies d'une boite selon son id
   * @param idBoite La boite recherchée
   * @return La liste des shinies de la boite
   */
  public List<PokemonDTO> findByIdBoite(Integer idBoite) {
    List<PokemonShiny> shinyList = shinyRepository.findByBoitePosition(idBoite);
    return shinyList.stream()
      .map(shiny -> objectMapper.convertValue(shiny, PokemonDTO.class))
      .collect(Collectors.toList());
  }

  /**
   * Trouver le nombre de pokémon par Ivs Manquants
   * @return la liste des Ivs manquants et le nombre pour chaque
   */
  public List<StatIvManquantDTO> getStatsIvManquant() {
    List<Object[]> results = shinyRepository.getStatsIvManquant();

    return results.stream()
      .map(row -> new StatIvManquantDTO((String) row[0], (Long) row[1]))
      .collect(Collectors.toList());
  }

  /**
   * Trouver la liste des pokemon shiny selon une région donnée
   * @param regionId l'id de la région demandée
   * @return le pokemon recherché
   */
  public List<PokemonShiny> getPokemonByRegion(Long regionId) {
    List<PokemonShiny> shinyList = shinyRepository.findByRegion(regionId);

    // Parcours la liste et vérifie si le Pokémon récemment ajouté doit être réordonné
    for (int i = 1; i < shinyList.size(); i++) {
      PokemonShiny current = shinyList.get(i);
      PokemonShiny previous = shinyList.get(i - 1);

      // Si le numDex du Pokémon actuel est inférieur à celui du Pokémon précédent
      // et que l'id du Pokémon actuel est plus grand, alors on réorganise la position
      if (Integer.parseInt(current.getNumDex()) < Integer.parseInt(previous.getNumDex())
        && current.getId() > previous.getId()) {

        // Place le Pokémon actuel à la bonne position par rapport au numDex
        shinyList.add(i - 1, shinyList.remove(i));
        i = 0; // Recommence à vérifier du début
      }
    }

    return shinyList;
  }

  /**
   * Méthode pour retrouver le nombre total de pokemons shiny
   * @return le nombre de shiny
   */
  public Long findShiniesCount() {
    return shinyRepository.countPokemonsShiny();
  }

  /**
   * Mettre à jour un shiny
   * @param shiny L'objet à mettre à jour
   * @return L'objet mis à jour
   */
  public PokemonShiny updatePokemonShiny(PokemonShiny shiny) {
    Optional<PokemonShiny> existingShiny = shinyRepository.findById(shiny.getId());

    if (existingShiny.isPresent()) {
      PokemonShiny existingPokemon = existingShiny.get();

      // Gestion des relations
      updatePokemonShinyRelations(existingPokemon, shiny);

      // Mettre à jour les autres informations
      existingPokemon.setNumDex(shiny.getNumDex() != null ? shiny.getNumDex() : existingPokemon.getNumDex());
      existingPokemon.setNomPokemon(shiny.getNomPokemon() != null ? shiny.getNomPokemon() : existingPokemon.getNomPokemon());
      existingPokemon.setNature(shiny.getNature() != null ? shiny.getNature() : existingPokemon.getNature());
      existingPokemon.setDresseur(shiny.getDresseur() != null ? shiny.getDresseur() : existingPokemon.getDresseur());
      existingPokemon.setPokeball(shiny.getPokeball() != null ? shiny.getPokeball() : existingPokemon.getPokeball());
      existingPokemon.setIvManquant(shiny.getIvManquant() != null ? shiny.getIvManquant() : existingPokemon.getIvManquant());
      existingPokemon.setType1(shiny.getType1() != null ? shiny.getType1() : existingPokemon.getType1());
      existingPokemon.setType2(shiny.getType2() != null ? shiny.getType2() : existingPokemon.getType2());
      existingPokemon.setSexe(shiny.getSexe() != null ? shiny.getSexe() : existingPokemon.getSexe());
      existingPokemon.setAttaque1(shiny.getAttaque1() != null ? shiny.getAttaque1() : existingPokemon.getAttaque1());
      existingPokemon.setAttaque2(shiny.getAttaque2() != null ? shiny.getAttaque2() : existingPokemon.getAttaque2());
      existingPokemon.setAttaque3(shiny.getAttaque3() != null ? shiny.getAttaque3() : existingPokemon.getAttaque3());
      existingPokemon.setAttaque4(shiny.getAttaque4() != null ? shiny.getAttaque4() : existingPokemon.getAttaque4());
      existingPokemon.setBoite(shiny.getBoite() != null ? shiny.getBoite() : existingPokemon.getBoite());
      existingPokemon.setPosition(shiny.getPosition() != null ? shiny.getPosition() : existingPokemon.getPosition());
      existingPokemon.setRegionShiny(shiny.getRegionShiny() != null ? shiny.getRegionShiny() : existingPokemon.getRegionShiny());

      // Sauvegarder et retourner le Pokémon mis à jour
      return shinyRepository.save(existingPokemon);
    } else {
      throw new CustomException("Le pokemon n'est pas présent dans le pokedex", "id", shiny.getId());
    }
  }

  /**
   * Méthode pour mettre à jour les relations en cas de modification d'un shiny
   * @param existingPokemon le shiny existant
   * @param updatedPokemon le shiny mis à jour
   */
  public void updatePokemonShinyRelations(PokemonShiny existingPokemon, PokemonShiny updatedPokemon) {
    // Gestion de la relation avec le dresseur
    if (!existingPokemon.getDresseur().equals(updatedPokemon.getDresseur())) {
      boiteDresseurService.decrementBoiteDresseur(existingPokemon.getDresseur(), existingPokemon.getBoite());
      boiteDresseurService.updateBoiteDresseur(updatedPokemon.getDresseur(), updatedPokemon.getBoite());
    }

    // Gestion de la relation avec la nature
    if (!existingPokemon.getNature().equals(updatedPokemon.getNature())) {
      boiteNatureService.decrementBoiteNature(existingPokemon.getNature(), existingPokemon.getBoite());
      boiteNatureService.updateBoiteNature(updatedPokemon.getNature(), updatedPokemon.getBoite());
    }

    // Gestion de la relation avec la Pokeball
    if (!existingPokemon.getPokeball().equals(updatedPokemon.getPokeball())) {
      boitePokeballService.decrementBoitePokeball(existingPokemon.getPokeball(), existingPokemon.getBoite());
      boitePokeballService.updateBoitePokeball(updatedPokemon.getPokeball(), updatedPokemon.getBoite());
    }

    // Gestion de la relation avec le Type 1
    if (!existingPokemon.getType1().equals(updatedPokemon.getType1())) {
      boiteTypeService.decrementBoiteType(existingPokemon.getType1(), existingPokemon.getBoite());
      boiteTypeService.updateBoiteType(updatedPokemon.getType1(), updatedPokemon.getBoite());
    }

    // Gestion de la relation avec le Type 2 (si existant)
    if (existingPokemon.getType2() != null || updatedPokemon.getType2() != null) {
      if (existingPokemon.getType2() == null || !existingPokemon.getType2().equals(updatedPokemon.getType2())) {
        if (existingPokemon.getType2() != null) {
          boiteTypeService.decrementBoiteType(existingPokemon.getType2(), existingPokemon.getBoite());
        }
        if (updatedPokemon.getType2() != null) {
          boiteTypeService.updateBoiteType(updatedPokemon.getType2(), updatedPokemon.getBoite());
        }
      }
    }

    // Gestion de la relation avec le Sexe
    if (!existingPokemon.getSexe().equals(updatedPokemon.getSexe())) {
      boiteSexeService.decrementBoiteSexe(existingPokemon.getSexe(), existingPokemon.getBoite());
      boiteSexeService.updateBoiteSexe(updatedPokemon.getSexe(), updatedPokemon.getBoite());
    }
  }

  /**
   * Méthode pour supprimer un shiny par son Id
   * @param id L'identifiant du shiny à supprimer
   * @return L'objet supprimé
   */
  public PokemonShiny deleteById(Integer id) {
    // Récupérer l'objet dans un Optional
    Optional<PokemonShiny> optionalShiny = shinyRepository.findById(id);

    // Vérifier si l'objet existe
    if (optionalShiny.isPresent()) {
      PokemonShiny shiny = optionalShiny.get();
      shinyRepository.delete(shiny); // Supprimer l'objet
      return shiny; // Retourner l'objet supprimé
    } else {
      throw new CustomException("Shiny", "id", id);
    }
  }

  /**
   * Supprimer tous les shiny
   */
  public void deleteAll() {
    shinyRepository.deleteAll();
  }

}
