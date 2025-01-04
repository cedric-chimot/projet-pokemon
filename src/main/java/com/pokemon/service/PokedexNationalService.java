package com.pokemon.service;

import com.pokemon.dto.*;
import com.pokemon.entity.*;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.PokedexNationalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service PokedexNational
 */
@Service
@Transactional
public class PokedexNationalService {

    /**
     * Le repository PokedexNational
     */
    private final PokedexNationalRepository pokedexRepository;

    /**
     * Appel des services des classes associées
     */
    private final NatureService natureService;
    private final DresseurService dresseurService;
    private final PokeballService pokeballService;
    private final BoitePokedexNationalService boitePokedexService;

    /**
     * Le constructeur du service
     * @param pokedexRepository Injection du repository Shiny
     * @param boitePokedexService etc... Injection des services
     */
    public PokedexNationalService(PokedexNationalRepository pokedexRepository, NatureService natureService, DresseurService dresseurService,
                                  PokeballService pokeballService, BoitePokedexNationalService boitePokedexService) {
        this.pokedexRepository = pokedexRepository;
        this.natureService = natureService;
        this.dresseurService = dresseurService;
        this.pokeballService = pokeballService;
        this.boitePokedexService = boitePokedexService;
    }

    /**
     * Méthode pour ajouter un pokemon au pokedex
     * @param numDex le numéro de pokedex
     * @param nomPokemon le nom du pokemon
     * @param idNature sa nature
     * @param idDresseur le dresseur d'origine
     * @param idPokeball la pokeball de capture
     * @param idBoite la boite de pokedex à laquelle il appartient
     * @return le pokemon ajouté
     */
    public PokedexNational pokedexSave(String numDex, String nomPokemon, Integer idNature, Integer idDresseur,
                                       Integer idPokeball, Long idBoite, String region) {
        // Récupérer les entités associées à partir des ID
        Natures nature = natureService.findById(idNature);
        Dresseurs dresseur = dresseurService.findById(idDresseur);
        Pokeballs pokeball = pokeballService.findById(idPokeball);
        BoitePokedexNational boitePokedex = boitePokedexService.findById(idBoite);

        // Créer l'entité PokedexNational à partir des données
        PokedexNational pokedexNational = new PokedexNational(numDex, nomPokemon, nature, dresseur, pokeball, boitePokedex, region);

        // Sauvegarder l'entité PokedexNational
        return pokedexRepository.save(pokedexNational);
    }

    /**
     * Trouver tous les pokemons sans restrictions
     * @return La liste de tous les pokemons du pokedex
     */
    public List<PokedexNational> findAllPokemons() {
        return pokedexRepository.findAll();
    }

    /**
     * Méthode pour afficher la liste de tous les pokemon du pokedex
     * @return La liste des pokemon
     */
    public List<PokedexDTO> findAllPokemonsFromPokedex() {
        // Utiliser une projection ou une requête personnalisée pour récupérer uniquement les champs nécessaires.
        List<PokedexNational> pokemons = pokedexRepository.findAllPokemonsWithRelations();

        return pokemons.stream()
                .map(pokedexNational -> new PokedexDTO(
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        new NatureReduitDTO(pokedexNational.getNaturePokedex().getNomNature()),  // Projection de la nature
                        new PokeballReduitDTO(pokedexNational.getPokeballPokedex().getNomPokeball()),  // Projection de la pokeball
                        new BoitePokedexReduitDTO(pokedexNational.getBoitePokedex().getNomBoite()),  // Projection de la boite
                        new DresseurReduitDTO(pokedexNational.getDresseurPokedex().getNumDresseur(), pokedexNational.getDresseurPokedex().getNomDresseur()) // Projection du dresseur
                ))
                .collect(Collectors.toList());
    }

    public List<PokedexDTO> findPokemonsByRegion(String region) {
        List<PokedexNational> pokemons = switch (region.toLowerCase()) {
            case "kanto" -> pokedexRepository.findByKanto();
            case "johto" -> pokedexRepository.findByJohto();
            case "hoenn" -> pokedexRepository.findByHoenn();
            case "sinnoh" -> pokedexRepository.findBySinnoh();
            case "unys" -> pokedexRepository.findByUnys();
            case "kalos" -> pokedexRepository.findByKalos();
            case "alola" -> pokedexRepository.findByAlola();
            case "galar" -> pokedexRepository.findByGalar();
            case "hisui" -> pokedexRepository.findByHisui();
            case "paldea" -> pokedexRepository.findByPaldea();
            default -> throw new IllegalArgumentException("Région non valide");
        };

        return pokemons.stream()
                .map(pokedexNational -> new PokedexDTO(
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        new NatureReduitDTO(pokedexNational.getNaturePokedex().getNomNature()),
                        new PokeballReduitDTO(pokedexNational.getPokeballPokedex().getNomPokeball()),
                        new BoitePokedexReduitDTO(pokedexNational.getBoitePokedex().getNomBoite()),
                        new DresseurReduitDTO(pokedexNational.getDresseurPokedex().getNumDresseur(), pokedexNational.getDresseurPokedex().getNomDresseur())
                ))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un pokemon du pokedex par son id
     * @param id L'id du pokemon recherché
     * @return le pokemon trouvé et toutes ses informations
     */
    public PokedexDTO findPokemonById(Long id) {
        // Utiliser une requête personnalisée pour récupérer uniquement les champs nécessaires.
        return pokedexRepository.findById(id)
                .map(pokedexNational -> new PokedexDTO(
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        new NatureReduitDTO(pokedexNational.getNaturePokedex().getNomNature()),  // Projection de la nature
                        new PokeballReduitDTO(pokedexNational.getPokeballPokedex().getNomPokeball()),  // Projection de la pokeball
                        new BoitePokedexReduitDTO(pokedexNational.getBoitePokedex().getNomBoite()),  // Projection de la boite
                        new DresseurReduitDTO(pokedexNational.getDresseurPokedex().getNumDresseur(), pokedexNational.getDresseurPokedex().getNomDresseur()) // Projection du dresseur
                ))
                .orElseThrow(() -> new CustomException("Aucun pokemon dans le pokedex", "id", id));
    }

    /**
     * Mettre à jour un pokemon du pokedex
     * @param pokemon L'objet pokemon à mettre à jour
     * @return L'objet pokemon mis à jour
     */
    public PokedexNational updatePokemonInPokedex(PokedexNational pokemon) {
        Optional<PokedexNational> existingInPokedex= pokedexRepository.findById(pokemon.getId());

        if (existingInPokedex.isPresent()) {
            PokedexNational existingPokemon = existingInPokedex.get();

            existingPokemon.setNomPokemon(pokemon.getNomPokemon());
            existingPokemon.setNaturePokedex(pokemon.getNaturePokedex());
            existingPokemon.setDresseurPokedex(pokemon.getDresseurPokedex());
            existingPokemon.setPokeballPokedex(pokemon.getPokeballPokedex());
            existingPokemon.setBoitePokedex(pokemon.getBoitePokedex());
            return pokedexRepository.save(existingPokemon);
        } else {
            throw new CustomException("Le pokemon n'est pas présent dans le pokedex", "id", pokemon.getId());
        }
    }

    /**
     * Méthode pour supprimer un pokemon du pokedex par son Id
     * @param id L'identifiant du pokemon à supprimer
     * @return L'objet supprimé
     */
    public PokedexNational deleteById(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<PokedexNational> optionalPokemon = pokedexRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalPokemon.isPresent()) {
            PokedexNational pokedex = optionalPokemon.get();
            pokedexRepository.delete(pokedex); // Supprimer l'objet
            return pokedex; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Pokedex", "id", id);
        }
    }

    /**
     * Supprimer tous les pokemon du pokedex
     */
    public void deleteAll() {
        pokedexRepository.deleteAll();
    }
}
