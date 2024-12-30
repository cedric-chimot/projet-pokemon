package com.pokemon.controller;

import com.pokemon.dto.PokeballDTO;
import com.pokemon.dto.PokeballReduitDTO;
import com.pokemon.entity.Pokeballs;
import com.pokemon.service.PokeballService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokeballs")
public class PokeballController {
    /**
     * Le service des pokeballs
     */
    private final PokeballService pokeballService;

    /**
     * Le constructeur
     * @param pokeballService Injection du service
     */
    public PokeballController(PokeballService pokeballService) {
        this.pokeballService = pokeballService;
    }

    /**
     * Ajouter une nouvelle pokeball
     * @param pokeball la pokeball à ajouter
     * @return la pokeball nouvellement ajoutée
     */
    @PostMapping("/create")
    public Pokeballs addPokeball(@RequestBody Pokeballs pokeball) {
        return pokeballService.save(pokeball);
    }

    /**
     * Afficher la liste de toutes les pokeballs
     * @return la liste
     */
    @GetMapping
    public List<PokeballDTO> findAll() {
        return pokeballService.findAllPokeballs();
    }

    /**
     * Trouver une pokeball par son id (pokeballs complet)
     * @param id l'id de la pokeball
     * @return la pokeball recherchée
     */
    @GetMapping("/find/{id}")
    public Pokeballs findById(@PathVariable Integer id) {
        return pokeballService.findById(id);
    }

    /**
     * Trouver une pokeball par son id
     * @param id l'id de la pokeball
     * @return la pokeball recherchée
     */
    @GetMapping("/{id}")
    public PokeballReduitDTO getById(@PathVariable Integer id) {
        return pokeballService.findPokeballById(id);
    }

    /**
     * Mettre à jour une pokeball
     * @param pokeball la pokeball à mettre à jour
     * @return la pokeball mis à jour
     */
    @PatchMapping("/update")
    public Pokeballs updatePokeball(@RequestBody Pokeballs pokeball) {
        return pokeballService.update(pokeball);
    }

    /**
     * Supprimer un pokeball par son id
     * @param id l'id de la pokeball à supprimer
     * @return la pokeball supprimée
     */
    @DeleteMapping("/delete/{id}")
    public Pokeballs deletePokeballById(@PathVariable Integer id) {
        return pokeballService.deleteById(id);
    }

    /**
     * Supprimer toutes les pokeballs
     */
    @DeleteMapping("/delete/all")
    public void deleteAllPokeballs() {
        pokeballService.deleteAll();
    }

}
