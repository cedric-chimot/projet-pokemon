package com.cch.pokemon.service;

import com.cch.pokemon.dto.*;
import com.cch.pokemon.entity.*;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.PokedexNationalRepository;
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
    private final RegionsService regionsService;

    /**
     * Le constructeur du service
     * @param pokedexRepository Injection du repository Shiny
     * @param boitePokedexService etc... Injection des services
     */
    public PokedexNationalService(PokedexNationalRepository pokedexRepository, NatureService natureService, DresseurService dresseurService,
                                  PokeballService pokeballService, BoitePokedexNationalService boitePokedexService, RegionsService regionsService) {
        this.pokedexRepository = pokedexRepository;
        this.natureService = natureService;
        this.dresseurService = dresseurService;
        this.pokeballService = pokeballService;
        this.boitePokedexService = boitePokedexService;
        this.regionsService = regionsService;
    }

    /**
     * Méthode pour ajouter un pokemon au pokedex
     * @param numDex le numéro de pokedex
     * @param nomPokemon le nom du pokemon
     * @param idNature sa nature
     * @param idDresseur le dresseur d'origine
     * @param idPokeball la pokeball de capture
     * @param idBoite la boite de pokedex à laquelle il appartient
     * @param idRegion la région à laquelle il appartient
     * @return le pokemon ajouté
     */
    public PokedexNational pokedexSave(String numDex, String nomPokemon, Integer idNature, Integer idDresseur,
                                       Integer idPokeball, Long idBoite, Long idRegion) {
        // Récupérer les entités associées à partir des ID
        Natures nature = natureService.findById(idNature);
        Dresseurs dresseur = dresseurService.findById(idDresseur);
        Pokeballs pokeball = pokeballService.findById(idPokeball);
        BoitePokedexNational boitePokedex = boitePokedexService.findById(idBoite);
        Regions region = regionsService.findById(idRegion);

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
                        pokedexNational.getId(),
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        new NatureReduitDTO(pokedexNational.getNaturePokedex().getNomNature()),  // Projection de la nature
                        new PokeballReduitDTO(pokedexNational.getPokeballPokedex().getNomPokeball()),  // Projection de la pokeball
                        new BoitePokedexReduitDTO(pokedexNational.getBoitePokedex().getNomBoite()),  // Projection de la boite
                        new DresseurReduitDTO(pokedexNational.getDresseurPokedex().getNumDresseur(), pokedexNational.getDresseurPokedex().getNomDresseur()), // Projection du dresseur
                        pokedexNational.getRegion()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver la liste des pokemons du pokedex d'une région (pokedex)
     * @param regionId l'id de la région
     * @return la liste des pokemons
     */
    public List<PokedexDTO> findPokemonsByRegion(Long regionId) {
        // Récupérer les pokémons pour la région spécifiée par ID
        List<PokedexNational> pokemons = pokedexRepository.findByRegion(regionId);
        // Transformer les résultats en DTO et les retourner
        return mapToDTO(pokemons);
    }

    /**
     * Méthode pour trouver la liste des pokemons du pokedex d'une région (admin)
     * @param regionId l'id de la région
     * @return la liste des pokemons
     */
    public List<PokedexNational> findPokemonsByRegionForAdmin(Long regionId) {
        return pokedexRepository.findPokemonsByRegionForAdmin(regionId);
    }

    /**
     * Mapping des données pour afficher une liste de pokemons avec certaines de leurs informations
     * @param pokemons La liste des pokemon à mapper
     * @return la liste des pokemons mappés et leurs informations
     */
    private List<PokedexDTO> mapToDTO(List<PokedexNational> pokemons) {
        return pokemons.stream()
            .map(pokemon -> new PokedexDTO(
                    pokemon.getId(),
                    pokemon.getNumDex(),
                    pokemon.getNomPokemon(),
                    new NatureReduitDTO(pokemon.getNaturePokedex().getNomNature()),
                    new PokeballReduitDTO(pokemon.getPokeballPokedex().getNomPokeball()),
                    new BoitePokedexReduitDTO(pokemon.getBoitePokedex().getNomBoite()),
                    new DresseurReduitDTO(pokemon.getDresseurPokedex().getNumDresseur(), pokemon.getDresseurPokedex().getNomDresseur()),
                    pokemon.getRegion()
            ))
            .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un pokemon du pokedex par son id
     * @param id L'id du pokemon recherché
     * @return le pokemon trouvé et toutes ses informations
     */
    public PokedexDTO findPokemonById(Long id) {
        return pokedexRepository.findById(id)
                .map(pokedexNational -> new PokedexDTO(
                        pokedexNational.getId(),
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        new NatureReduitDTO(pokedexNational.getNaturePokedex().getId(), pokedexNational.getNaturePokedex().getNomNature()),  // Projection de l'ID et du nom de la nature
                        new PokeballReduitDTO(pokedexNational.getPokeballPokedex().getId(), pokedexNational.getPokeballPokedex().getNomPokeball()),  // Projection de l'ID et du nom de la pokeball
                        new BoitePokedexReduitDTO(pokedexNational.getBoitePokedex().getId(), pokedexNational.getBoitePokedex().getNomBoite()),  // Projection de l'ID et du nom de la boite
                        new DresseurReduitDTO(pokedexNational.getDresseurPokedex().getId(), pokedexNational.getDresseurPokedex().getNumDresseur(), pokedexNational.getDresseurPokedex().getNomDresseur()), // Projection de l'ID et du nom du dresseur
                        pokedexNational.getRegion()
                ))
                .orElseThrow(() -> new CustomException("Aucun pokemon dans le pokedex", "id", id));
    }

    public PokedexNational findPokemonByIdForAdmin(Long id) {
        return pokedexRepository.findById(id)
                .map(pokedexNational -> new PokedexNational(
                        pokedexNational.getId(),
                        pokedexNational.getNumDex(),
                        pokedexNational.getNomPokemon(),
                        pokedexNational.getNaturePokedex(),
                        pokedexNational.getPokeballPokedex(),
                        pokedexNational.getDresseurPokedex(),
                        pokedexNational.getRegion()
                ))
                .orElseThrow(() -> new CustomException("Aucun pokemon trouvé avec cet ID", "id", id));
    }

    /**
     * Méthode pour retrouver le nombre total de pokemons dans le pokedex
     * @return le nombre de pokemons
     */
    public Long findPokemonsCount() {
        return pokedexRepository.countPokemonsInPokedex();
    }

    /**
     * Méthode pour afficher le nombre de pokemons par régions
     * @return la liste des pokemons par région
     */
    public List<Object[]> findNbPokemonsByRegion() {
        return pokedexRepository.countPokemonsByRegion();
    }

    /**
     * Mettre à jour un pokemon du pokedex
     * @param pokemon L'objet pokemon à mettre à jour
     * @return L'objet pokemon mis à jour
     */
    public PokedexNational updatePokemonInPokedex(PokedexNational pokemon) {
        // Utiliser la méthode findPokemonById pour récupérer le Pokémon existant sous forme d'entité
        PokedexNational existingPokemon = pokedexRepository.findById(pokemon.getId())
                .orElseThrow(() -> new RuntimeException("Pokemon non trouvé"));

        System.out.println(existingPokemon);

        // Mettre à jour les informations de l'entité existante avec les données fournies
        existingPokemon.setNomPokemon(pokemon.getNomPokemon() != null ? pokemon.getNomPokemon() : existingPokemon.getNomPokemon());
        existingPokemon.setNumDex(pokemon.getNumDex() != null ? pokemon.getNumDex() : existingPokemon.getNumDex());
        existingPokemon.setRegion(pokemon.getRegion() != null ? pokemon.getRegion() : existingPokemon.getRegion());

        System.out.println("Avant récupération de la nature, Nature: " + pokemon.getNaturePokedex());
        if (pokemon.getNaturePokedex() != null) {
            Natures nature = natureService.findById(pokemon.getNaturePokedex().getId());
            if (nature != null) {
                System.out.println("Nature récupérée: " + nature.getNomNature());
                existingPokemon.setNaturePokedex(nature);
            } else {
                throw new RuntimeException("Nature non trouvée avec l'ID: " + pokemon.getNaturePokedex().getId());
            }
        } else {
            System.out.println("La nature du Pokémon est null.");
        }

        System.out.println("Après mise à jour, Nature du Pokémon: " + existingPokemon.getNaturePokedex());

        // Mettre à jour les entités liées à partir des données du DTO ou de l'entrée
        if (pokemon.getDresseurPokedex() != null) {
            Dresseurs dresseur = dresseurService.findById(pokemon.getDresseurPokedex().getId());
            existingPokemon.setDresseurPokedex(dresseur);
        }


        if (pokemon.getPokeballPokedex() != null) {
            Pokeballs pokeball = pokeballService.findById(pokemon.getPokeballPokedex().getId());
            existingPokemon.setPokeballPokedex(pokeball);
        }

        if (pokemon.getBoitePokedex() != null) {
            BoitePokedexNational boite = boitePokedexService.findById(pokemon.getBoitePokedex().getId());
            existingPokemon.setBoitePokedex(boite);
        }

        // Sauvegarder et retourner le Pokémon mis à jour
        return pokedexRepository.save(existingPokemon);
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