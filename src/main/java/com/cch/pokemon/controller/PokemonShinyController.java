package com.cch.pokemon.controller;

import com.cch.pokemon.dto.PokemonDTO;
import com.cch.pokemon.dto.PokemonReduitDTO;
import com.cch.pokemon.dto.StatIvManquantDTO;
import com.cch.pokemon.entity.PokemonShiny;
import com.cch.pokemon.service.PokemonShinyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Le controller de PokemonShiny
 */
@RestController
@RequestMapping("/api/pokemonShiny")
@CrossOrigin
public class PokemonShinyController {

    /**
     * Variable ShinyService
     */
    private final PokemonShinyService shinyService;

    /**
     * Le constructeur
     * @param shinyService Injection du service pour les shiny
     */
    public PokemonShinyController(PokemonShinyService shinyService) {
        this.shinyService = shinyService;
    }

    /**
     * Ajouter un shiny
     * @return Le shiny nouvellement ajouté
     */
    @PostMapping("/create")
    public ResponseEntity<PokemonShiny> saveShinyPokemon(@RequestBody PokemonShiny pokemonShiny) {
        PokemonShiny shinySave = shinyService.save(
                pokemonShiny.getNumDex(),
                pokemonShiny.getNomPokemon(),
                pokemonShiny.getNature().getId(),
                pokemonShiny.getDresseur().getId(),
                pokemonShiny.getPokeball().getId(),
                pokemonShiny.getIvManquant(),
                pokemonShiny.getType1().getId(),
                pokemonShiny.getType2().getId(),
                pokemonShiny.getSexe().getId(),
                pokemonShiny.getAttaque1().getId(),
                pokemonShiny.getAttaque2().getId(),
                pokemonShiny.getAttaque3().getId(),
                pokemonShiny.getAttaque4().getId(),
                pokemonShiny.getBoite(),
                pokemonShiny.getPosition(),
                pokemonShiny.getRegionShiny().getId()
        );

        return ResponseEntity.ok(shinySave);
    }

    /**
     * Afficher la liste de tous les shinies
     * @return la liste de tous les shinies
     */
    @GetMapping("/all")
    public List<PokemonDTO> findAll() {
        return shinyService.findAllShinies();
    }

    /**
     * Afficher les données d'un shiny avec un id donné (entité complète)
     * @param id l'identifiant recherché
     * @return le shiny et toutes ses données
     */
    @GetMapping("/find/{id}")
    public PokemonShiny getShinyById(@PathVariable Integer id) {
        return shinyService.findShinyById(id);
    }

    /**
     * Afficher les données d'un shiny avec un id donné (DTO)
     * @param id l'identifiant recherché
     * @return le shiny et toutes ses données
     */
    @GetMapping("/{id}")
    public Optional<PokemonDTO> getById(@PathVariable Integer id) {
        return shinyService.findById(id);
    }

    /**
     * Trouver un pokemon selon son numéro de pokedex
     * @param numDex Le numéro de pokédex recherché
     * @return Le pokemon recherché
     */
    @GetMapping("/findByNumDex/{numDex}")
    public ResponseEntity<?> findAllByNumDex(@PathVariable String numDex) {
        List<PokemonReduitDTO> shinies = shinyService.findByNumDex(numDex);

        if (shinies.isEmpty()) {
            return ResponseEntity.status(404).body("Aucun shiny ne correspond à ce numéro de pokedex");
        }

        return ResponseEntity.ok(shinies);
    }

    /**
     * Afficher la liste des shinies d'une boite
     * @param boite la boite concernée
     * @return la liste des shinies de la boite
     */
    @GetMapping("/boites")
    public ResponseEntity<List<PokemonDTO>> getPokemonsByBoite(@RequestParam("boite") String boite) {
        if (boite == null || boite.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        System.out.println("Boite reçue: " + boite); // Pour le débogage
        List<PokemonDTO> pokemons = shinyService.findByBoite(boite);
        return ResponseEntity.ok(pokemons);
    }

    /**
     * Récupérer le nombre de shiny par Ivs manquants
     * @return la liste du nombre de pokémon par Ivs manquants
     */
    @GetMapping("/iv-manquants")
    public List<StatIvManquantDTO> getStatsByIvManquants() {
        return shinyService.getStatsIvManquant();
    }

    /**
     * Trouver tous les pokemons d'une région
     * @param regionId l'id de la région
     * @return la liste des pokemons d'une région
     */
    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<PokemonShiny>> getPokemonByRegion(@PathVariable Long regionId) {
        List<PokemonShiny> shinyList = shinyService.getPokemonByRegion(regionId);
        return ResponseEntity.ok(shinyList);
    }

    /**
     * Compter le nombre de pokemons shiny
     * @return le nombre de shiny
     */
    @GetMapping("/count")
    public Long getCountShiny() {
        return shinyService.findShiniesCount();
    }

    /**
     * Mettre à jour un shiny
     * @param shiny le shiny à mettre à jour
     * @return le shiny mis à jour
     */
    @PatchMapping("/update")
    public PokemonShiny updateShiny(@RequestBody PokemonShiny shiny) {
        return shinyService.updatePokemonShiny(shiny);
    }

    /**
     * Supprimer un shiny par son id
     * @param id l'id du shiny à supprimer
     * @return le shiny supprimé
     */
    @DeleteMapping("/delete/{id}")
    public PokemonShiny deleteShinyById(@PathVariable Integer id) {
        return shinyService.deleteById(id);
    }

    /**
     * Supprimer tous les shinies
     */
    @DeleteMapping("/delete/all")
    public void deleteAllShinies() {
        shinyService.deleteAll();
    }

}
