package com.cch.pokemon.controller;

import com.cch.pokemon.dto.PokeballDTO;
import com.cch.pokemon.dto.PokeballReduitDTO;
import com.cch.pokemon.entity.Pokeballs;
import com.cch.pokemon.service.PokeballService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokeballs")
@CrossOrigin
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
     * Afficher la liste de toutes les pokeballs pour l'affichage admin (retourne toutes les données)
     * @return la liste des pokeballs
     */
    @GetMapping("/all/admin")
    public List<PokeballDTO> findAllPokeballsAdmin() {
        return pokeballService.findAllPokeballsForAdmin();
    }

    /**
     * Afficher la liste de toutes les pokeballs pour les stats Pokedex (retourne toutes les données)
     * @return la liste des pokeballs
     */
    @GetMapping("/all/pokedex")
    public List<PokeballDTO> findAllPokeballsPokedex() {
        return pokeballService.findAllPokeballsForPokedex();
    }

    /**
     * Afficher la liste des pokeballs (retourne le nom de la pokeball)
     * @return la liste des pokeballs
     */
    @GetMapping("/all")
    public List<PokeballReduitDTO> findAllByNom() {
        return pokeballService.findAllPokeballsByNom();
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
     * Trouver une pokeball par son id et retourner son nom
     * @param id l'id de la pokeball
     * @return le nom de la pokeball recherchée
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
