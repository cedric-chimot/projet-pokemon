package com.cch.pokemon.controller;

import com.cch.pokemon.dto.PokedexDTO;
import com.cch.pokemon.dto.PokedexRequeteDTO;
import com.cch.pokemon.entity.PokedexNational;
import com.cch.pokemon.service.PokedexNationalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller de PokemonShiny
 */
@RestController
@RequestMapping("/api/pokedexNational")
@CrossOrigin(origins = "http://localhost:4200")
public class PokedexNationalController {

    /**
     * Variable pour appeler le service
     */
    private final PokedexNationalService pokedexNationalService;

    /**
     * Le constructeur du controller
     * @param pokedexNationalService Injection du service
     */
    public PokedexNationalController(PokedexNationalService pokedexNationalService) {
        this.pokedexNationalService = pokedexNationalService;
    }

    /**
     * Crée un nouveau pokemon du Pokedex National avec les relations associées.
     * @return le pokemon ajouté au Pokedex National
     */
    @PostMapping("/save")
    public ResponseEntity<PokedexNational> savePokedex(@RequestBody PokedexRequeteDTO pokedexRequeteDTO) {
        // Appeler le service en utilisant les données envoyées dans le corps de la requête
        PokedexNational pokedexSaved = pokedexNationalService.pokedexSave(
                pokedexRequeteDTO.getNumDex(),
                pokedexRequeteDTO.getNomPokemon(),
                pokedexRequeteDTO.getIdNature(),
                pokedexRequeteDTO.getIdDresseur(),
                pokedexRequeteDTO.getIdPokeball(),
                pokedexRequeteDTO.getIdBoite(),
                pokedexRequeteDTO.getIdRegion()
        );

        return ResponseEntity.ok(pokedexSaved);
    }

    @GetMapping("/find/all")
    public List<PokedexNational> getAllPokemons() {
        return pokedexNationalService.findAllPokemons();
    }

    /**
     * Afficher tous les pokemon du pokedex national (réduit)
     * @return la liste des pokemons du pokedex national (uniquement les infos pour l'affichage)
     */
    @GetMapping("/all")
    public List<PokedexDTO> getAllPokemonsFromPokedex() {
        return pokedexNationalService.findAllPokemonsFromPokedex();
    }

    /**
     * Rechercher un pokemon du pokedex national par son id
     * @param id l'id du pokemon recherché
     * @return le pokemon trouvé
     */
    @GetMapping("/{id}")
    public PokedexDTO findPokemonFromPokedexById(@PathVariable Long id) {
        return pokedexNationalService.findPokemonById(id);
    }

    /**
     * Afficher la liste des pokemons pour une région donnée
     * @param regionId l'identifiant de la région
     * @return la liste des pokemons
     */
    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<PokedexDTO>> getPokemonsByRegion(@PathVariable Long regionId) {
        List<PokedexDTO> pokemons = pokedexNationalService.findPokemonsByRegion(regionId);
        return ResponseEntity.ok(pokemons);
    }

    /**
     * Compter le nombre de pokemons du pokedex
     * @return le nombre de pokemons
     */
    @GetMapping("/count")
    public Long getCountPokemonsInPokedex() {
        return pokedexNationalService.findPokemonsCount();
    }

    /**
     * Compter le nombre de pokémons par régions
     * @return le nombre de pokémons par régions
     */
    @GetMapping("/count-by-region")
    public List<Object[]> getPokemonsByRegions() {
        return pokedexNationalService.findNbPokemonsByRegion();
    }

    /**
     * Mettre à jour un pokemon du pokedex national
     * @param pokemonInPokedex le pokemon à mettre à jour
     * @return le pokemon mis à jour
     */
    @PatchMapping("/update")
    public PokedexNational updatePokedexNational(@RequestBody PokedexNational pokemonInPokedex) {
        return pokedexNationalService.updatePokemonInPokedex(pokemonInPokedex);
    }

    /**
     * Supprimer un pokemon du pokedex national par son id
     * @param id l'id du pokemon à supprimer
     * @return le pokemon supprimée
     */
    @DeleteMapping("/delete/{id}")
    public PokedexNational deletePokemonInPokedexById(@PathVariable Long id) {
        return pokedexNationalService.deleteById(id);
    }

    /**
     * Supprimer tous les pokemon du pokedex national
     */
    @DeleteMapping("/delete/all")
    public void deleteAllPokemonsInPokedex() {
        pokedexNationalService.deleteAll();
    }

}
