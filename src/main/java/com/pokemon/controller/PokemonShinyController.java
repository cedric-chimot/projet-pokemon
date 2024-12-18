package com.pokemon.controller;

import com.pokemon.dto.PokemonDTO;
import com.pokemon.dto.PokemonShinyDTO;
import com.pokemon.entity.PokemonShiny;
import com.pokemon.service.PokemonShinyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemonShiny")
public class PokemonShinyController {

    private final PokemonShinyService shinyService;

    public PokemonShinyController(PokemonShinyService shinyService) {
        this.shinyService = shinyService;
    }

    @PostMapping("/create")
    public PokemonShiny addShiny(@RequestBody PokemonShiny shiny) {
        return shinyService.shinySave(shiny);
    }

    @GetMapping
    public List<PokemonShinyDTO> findAll() {
        return shinyService.findAllShiny();
    }

    @GetMapping("/{id}")
    public Optional<PokemonShinyDTO> getById(@PathVariable Integer id) {
        return shinyService.findById(id);
    }

    /**
     * Méthode pour trouver un pokemon selon son numéro de pokedex
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

    @GetMapping("/boite")
    public List<PokemonShinyDTO> getShinyByBoite(@RequestParam("boite") String boite) {
        return shinyService.findByBoite(boite);
    }

}
