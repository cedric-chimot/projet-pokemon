package com.pokemon.controller;

import com.pokemon.dto.PokemonShinyDTO;
import com.pokemon.entity.PokemonShiny;
import com.pokemon.service.PokemonShinyService;
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

}
