package com.pokemon.controller;

import com.pokemon.dto.*;
import com.pokemon.entity.PokedexNational;
import com.pokemon.service.PokedexNationalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller de PokemonShiny
 */
@RestController
@RequestMapping("/api/pokedexNational")
@CrossOrigin
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
     * Afficher tous les pokemon du pokedex national
     * @return la liste des pokedexNationals
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
                pokedexRequeteDTO.getIdBoite()
        );

        return ResponseEntity.ok(pokedexSaved);
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
