package com.cch.pokemon.controller;

import com.cch.pokemon.dto.BoitePokedexDTO;
import com.cch.pokemon.dto.BoitePokedexReduitDTO;
import com.cch.pokemon.entity.BoitePokedexNational;
import com.cch.pokemon.service.BoitePokedexNationalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller d'un boitePokedex
 */
@RestController
@RequestMapping("/api/boitePokedex")
@CrossOrigin
public class BoitePokedexNationalController {

    /**
     * Le service des boites pokedex
     */
    private final BoitePokedexNationalService boitePokedexService;

    /**
     * Le constructeur
     * @param boitePokedexService Injection du service
     */
    public BoitePokedexNationalController(BoitePokedexNationalService boitePokedexService) {
        this.boitePokedexService = boitePokedexService;
    }

    /**
     * Ajouter une nouvelle boite pokedex
     * @param boitePokedex la boite pokedex à ajouter
     * @return le boitePokedex nouvellement ajouté
     */
    @PostMapping("/create")
    public BoitePokedexNational addBoitePokedex(@RequestBody BoitePokedexNational boitePokedex) {
        return boitePokedexService.save(boitePokedex);
    }

    /**
     * Afficher la liste de toutes les boites pokedex
     * @return la liste
     */
    @GetMapping("/all")
    public List<BoitePokedexDTO> findAll() {
        return boitePokedexService.findAllBoitePokedex();
    }

    /**
     * Trouver une boite pokedex par son id (boitePokedex complet)
     * @param id l'id de la boite pokedex
     * @return le boitePokedex recherché
     */
    @GetMapping("/find/{id}")
    public BoitePokedexNational findById(@PathVariable Long id) {
        return boitePokedexService.findById(id);
    }

    /**
     * Trouver un boitePokedex par son id (avec le DTO)
     * @param id l'id du boitePokedex
     * @return la boite pokedex recherché
     */
    @GetMapping("/{id}")
    public BoitePokedexReduitDTO getById(@PathVariable Long id) {
        return boitePokedexService.findBoitePokedexById(id);
    }

    /**
     * Mettre à jour une boite pokedex
     * @param boitePokedex la boite pokedex à mettre à jour
     * @return la boite pokedex mis à jour
     */
    @PutMapping("/update")
    public BoitePokedexNational updateBoitePokedex(@RequestBody BoitePokedexNational boitePokedex) {
        return boitePokedexService.update(boitePokedex);
    }

    /**
     * Supprimer une boite pokedex par son id
     * @param id l'id de la boite pokedex à supprimer
     * @return la boite pokedex supprimée
     */
    @DeleteMapping("/delete/{id}")
    public BoitePokedexNational deleteBoitePokedexById(@PathVariable Long id) {
        return boitePokedexService.deleteById(id);
    }

    /**
     * Supprimer tous les boites pokedex
     */
    @DeleteMapping("/delete/all")
    public void deleteAllBoitePokedex() {
        boitePokedexService.deleteAll();
    }

}