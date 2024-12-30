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
     * Afficher toutes les pokedexNationals
     *
     * @return la liste des pokedexNationals
     */
    @GetMapping("/all")
    public List<PokedexDTO> getAllPokemonsFromPokedex() {
        return pokedexNationalService.findAllPokemonsFromPokedex();
    }

    /**
     * Rechercher une pokedexNational par son id
     *
     * @param id l'id de la pokedexNational
     * @return la pokedexNational trouvée
     */
    @GetMapping("/{id}")
    public PokedexDTO findPokemonFromPokedexById(@PathVariable Long id) {
        return pokedexNationalService.findById(id);
    }

    /**
     * Crée un nouvel objet PokedexNational avec les relations associées.
     * @return l'objet PokedexNational créé
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
     * Mettre à jour une pokedexNational
     * @param pokedexNational la pokedexNational à mettre à jour
     * @return la pokedexNational mise à jour
     */
    @PatchMapping("/update")
    public PokedexNational updatepokedexNational(@RequestBody PokedexNational pokedexNational) {
        return pokedexNationalService.update(pokedexNational);
    }

    /**
     * Supprimer une pokedexNational par son id
     * @param id l'id d'une pokedexNational à supprimer
     * @return la pokedexNational supprimée
     */
    @DeleteMapping("/delete/{id}")
    public PokedexNational deletePokedexNationalById(@PathVariable Long id) {
        return pokedexNationalService.deleteById(id);
    }

    /**
     * Supprimer toutes les pokedexNationals
     */
    @DeleteMapping("/delete/all")
    public void deleteAllShinies() {
        pokedexNationalService.deleteAll();
    }

}
