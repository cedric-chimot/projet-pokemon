package com.cch.pokemon.controller;

import com.cch.pokemon.entity.Regions;
import com.cch.pokemon.service.RegionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller de Region
 */
@RestController
@RequestMapping("/api/regions")
@CrossOrigin
public class RegionController {

    /**
     * Le service des regions
     */
    private final RegionsService regionService;

    /**
     * Le constructeur
     * @param regionService Injection du service
     */
    public RegionController(RegionsService regionService) {
        this.regionService = regionService;
    }

    /**
     * Ajouter un nouveau region
     * @param region la region à ajouter
     * @return la region nouvellement ajoutée
     */
    @PostMapping("/create")
    public Regions addRegions(@RequestBody Regions region) {
        return regionService.save(region);
    }

    /**
     * Afficher la liste de tous les regions
     * @return la liste
     */
    @GetMapping
    public List<Regions> findAll() {
        return regionService.findAllRegions();
    }

    /**
     * Trouver une region par son id
     * @param id l'id d'une region
     * @return la region recherchée
     */
    @GetMapping("/{id}")
    public Regions getById(@PathVariable Long id) {
        return regionService.findById(id);
    }

    /**
     * Mettre à jour une region
     * @param region la region à mettre à jour
     * @return la region mis à jour
     */
    @PatchMapping("/update")
    public Regions updateRegions(@RequestBody Regions region) {
        return regionService.update(region);
    }

    /**
     * Supprimer une region par son id
     * @param id l'id d'une region à supprimer
     * @return la region supprimée
     */
    @DeleteMapping("/delete/{id}")
    public Regions deleteRegionsById(@PathVariable Long id) {
        return regionService.deleteById(id);
    }

    /**
     * Supprimer toutes les regions
     */
    @DeleteMapping("/delete/all")
    public void deleteAllRegions() {
        regionService.deleteAll();
    }

}
