package com.cch.pokemon.controller;

import com.cch.pokemon.entity.RegionDresseur;
import com.cch.pokemon.service.RegionDresseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller d'un dresseur
 */
@RestController
@RequestMapping("/api/regionDresseur")
@CrossOrigin
public class RegionDresseurController {

    /**
     * Le service des regionDresseur
     */
    private final RegionDresseurService regionDresseurService;

    /**
     * Le constructeur
     * @param regionDresseurService Injection du service
     */
    public RegionDresseurController(RegionDresseurService regionDresseurService) {
        this.regionDresseurService = regionDresseurService;
    }

    /**
     * Ajouter un nouveau dresseur
     * @param dresseur le dresseur à ajouter
     * @return le dresseur nouvellement ajouté
     */
    @PostMapping("/create")
    public RegionDresseur addRegionDresseur(@RequestBody RegionDresseur dresseur) {
        return regionDresseurService.save(dresseur);
    }

    /**
     * Afficher la liste de toutes les regionDresseur
     * @return la liste des regionDresseur
     */
    @GetMapping("/all")
    public List<RegionDresseur> findAllRegionRegionDresseur() {
        return regionDresseurService.findAllRegionDresseurs();
    }

    /**
     * Trouver un dresseur par son id (dresseur complet)
     * @param id l'id du dresseur
     * @return le dresseur recherché
     */
    @GetMapping("/find/{id}")
    public RegionDresseur findById(@PathVariable Long id) {
        return regionDresseurService.findById(id);
    }

    /**
     * Mettre à jour un dresseur
     * @param regionDresseur le dresseur à mettre à jour
     * @return le dresseur mis à jour
     */
    @PatchMapping("/update")
    public RegionDresseur updateRegionDresseur(@RequestBody RegionDresseur regionDresseur) {
        return regionDresseurService.update(regionDresseur);
    }

    /**
     * Supprimer un dresseur par son id
     * @param id l'id du dresseur à supprimer
     * @return le dresseur supprimé
     */
    @DeleteMapping("/delete/{id}")
    public RegionDresseur deleteRegionDresseurById(@PathVariable Long id) {
        return regionDresseurService.deleteById(id);
    }

    /**
     * Supprimer tous les regionDresseur
     */
    @DeleteMapping("/delete/all")
    public void deleteAllRegionRegionDresseur() {
        regionDresseurService.deleteAll();
    }

}
