package com.pokemon.service;

import com.pokemon.dto.PokedexDTO;
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
                                       Integer idPokeball, Long idBoite) {
        // Récupérer les entités associées à partir des ID
        Natures nature = natureService.findById(idNature);
        Dresseurs dresseur = dresseurService.findById(idDresseur);
        Pokeballs pokeball = pokeballService.findById(idPokeball);
        BoitePokedexNational boitePokedex = boitePokedexService.findById(idBoite);

        // Créer l'entité PokedexNational à partir des données
        PokedexNational pokedexNational = new PokedexNational(numDex, nomPokemon, nature, dresseur, pokeball, boitePokedex);

        // Sauvegarder l'entité PokedexNational
        return pokedexRepository.save(pokedexNational);
    }

    /**
     * Méthode pour afficher la liste de tous les pokemon du pokedex
     * @return La liste des pokemon
     */
    public List<PokedexDTO> findAllPokemonsFromPokedex() {
        return pokedexRepository.findAll().stream()
                .map(pokedexNational -> new PokedexDTO(
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        pokedexNational.getNaturePokedex().getNomNature(),
                        pokedexNational.getPokeballPokedex().getNomPokeball(),
                        pokedexNational.getBoitePokedex().getNomBoite(),
                        pokedexNational.getDresseurPokedex().getNumDresseur(),
                        pokedexNational.getDresseurPokedex().getNomDresseur()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un pokemon du pokedex par son id
     * @param id L'id du pokemon recherché
     * @return le pokemon trouvé et toutes ses informations
     */
    public PokedexDTO findById(Long id) {
        return pokedexRepository.findById(id)
                .map(pokedexNational -> new PokedexDTO(
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        pokedexNational.getNaturePokedex().getNomNature(),
                        pokedexNational.getPokeballPokedex().getNomPokeball(),
                        pokedexNational.getBoitePokedex().getNomBoite(),
                        pokedexNational.getDresseurPokedex().getNumDresseur(),
                        pokedexNational.getDresseurPokedex().getNomDresseur()
                ))
                .orElseThrow(() -> new CustomException("Aucun pokemon dans le pokedex", "id", id));
    }

    /**
     * Mettre à jour un pokedex
     * @param pokedex L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public PokedexNational update(PokedexNational pokedex) {
        return pokedexRepository.save(pokedex);
    }

    /**
     * Méthode pour supprimer un pokedex par son Id
     * @param id L'identifiant du pokedex à supprimer
     * @return L'objet supprimé
     */
    public PokedexNational deleteById(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<PokedexNational> optionalShiny = pokedexRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalShiny.isPresent()) {
            PokedexNational pokedex = optionalShiny.get();
            pokedexRepository.delete(pokedex); // Supprimer l'objet
            return pokedex; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Pokedex", "id", id);
        }
    }

    /**
     * Supprimer tous les pokedex
     */
    public void deleteAll() {
        pokedexRepository.deleteAll();
    }

}
