package com.pokemon.controller;

import com.pokemon.dto.PokemonDTO;
import com.pokemon.dto.PokemonShinyDTO;
import com.pokemon.dto.StatIvManquantDTO;
import com.pokemon.entity.PokemonShiny;
import com.pokemon.service.PokemonShinyService;
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
     * @param shiny Le shiny à ajouter
     * @return Le shiny nouvellement ajouté
     */
    @PostMapping("/create")
    public PokemonShiny addShiny(@RequestBody PokemonShiny shiny) {
        return shinyService.shinySave(shiny);
    }

    /**
     * Afficher la liste de tous les shinies
     * @return la liste de tous les shinies
     */
    @GetMapping("/all")
    public List<PokemonShinyDTO> findAll() {
        return shinyService.findAllShiny();
    }

    /**
     * Afficher les données d'un shiny avec un id donné
     * @param id l'identifiant recherché
     * @return le shiny et toutes ses données
     */
    @GetMapping("/{id}")
    public Optional<PokemonShinyDTO> getById(@PathVariable Integer id) {
        return shinyService.findById(id);
    }

    /**
     * Trouver un pokemon selon son numéro de pokedex
     * @param numDex Le numéro de pokédex recherché
     * @return Le pokemon recherché
     */
    @GetMapping("/findByNumDex/{numDex}")
    public ResponseEntity<?> findAllByNumDex(@PathVariable String numDex) {
        List<PokemonDTO> shinies = shinyService.findByNumDex(numDex);

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
    public ResponseEntity<List<PokemonShinyDTO>> getPokemonsByBoite(@RequestParam("boite") String boite) {
        if (boite == null || boite.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        System.out.println("Boite reçue: " + boite); // Pour le débogage
        List<PokemonShinyDTO> pokemons = shinyService.findByBoite(boite);
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
     * Mettre à jour un shiny
     * @param shiny le shiny à mettre à jour
     * @return le shiny mis à jour
     */
    @PatchMapping("/update")
    public PokemonShiny updateShiny(@RequestBody PokemonShiny shiny) {
        return shinyService.update(shiny);
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
