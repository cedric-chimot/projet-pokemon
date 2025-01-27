package com.cch.pokemon.controller;

import com.cch.pokemon.dto.DresseurReduitDTO;
import com.cch.pokemon.entity.Dresseurs;
import com.cch.pokemon.service.DresseurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller d'un dresseur
 */
@RestController
@RequestMapping("/api/dresseurs")
@CrossOrigin
public class DresseurController {

    /**
     * Le service des dresseurs
     */
    private final DresseurService dresseurService;

    /**
     * Le constructeur
     * @param dresseurService Injection du service
     */
    public DresseurController(DresseurService dresseurService) {
        this.dresseurService = dresseurService;
    }

    /**
     * Ajouter un nouveau dresseur
     * @param dresseur le dresseur à ajouter
     * @return le dresseur nouvellement ajouté
     */
    @PostMapping("/create")
    public ResponseEntity<Dresseurs> saveDresseur(@RequestBody Dresseurs dresseur) {
        // Appeler le service en utilisant les données envoyées dans le corps de la requête
        Dresseurs dresseurSave = dresseurService.save(
                dresseur.getNumDresseur(),
                dresseur.getNomDresseur(),
                dresseur.getNbPokemon(),
                dresseur.getNbShiny(),
                dresseur.getRegionDresseur().getIdRegionDresseur()
        );

        return ResponseEntity.ok(dresseurSave);
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * @return la liste des dresseurs
     */
    @GetMapping("/find/all")
    public List<Dresseurs> findAllDresseurs() {
        return dresseurService.findAll();
    }

    /**
     * Afficher la liste de tous les dresseurs, numDresseur et nomDresseur
     * @return la liste des dresseurs
     */
    @GetMapping("/all")
    public List<DresseurReduitDTO> findAllDresseursReduits() {
        return dresseurService.findAllDresseurs();
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * dont l'id de la région est 1 et l'id dresseur est compris entre 1 et 40
     * @return la liste des dresseurs
     */
    @GetMapping("/all/region1")
    public List<Dresseurs> findAllDresseursRegion1() {
        return dresseurService.findAllDresseursRegion1();
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * dont l'id de la région est 1 et l'id dresseur est compris entre 1 et 40
     * @return la liste des dresseurs
     */
    @GetMapping("/all/region1Part1")
    public List<Dresseurs> findAllDresseursFiltered1() {
        return dresseurService.findAllDresseursRegion1Part1();
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * dont l'id de la région est 1 et l'id dresseur est compris entre 41 et 81
     * @return la liste des dresseurs
     */
    @GetMapping("/all/region1Part2")
    public List<Dresseurs> findAllDresseursFiltered2() {
        return dresseurService.findAllDresseursRegion1Part2();
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * dont l'id de la région est 2
     * @return la liste des dresseurs
     */
    @GetMapping("/all/region2")
    public List<Dresseurs> findAllDresseursRegion2() {
        return dresseurService.findAllDresseursRegions2();
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * dont l'id de la région est 3
     * @return la liste des dresseurs
     */
    @GetMapping("/all/region3")
    public List<Dresseurs> findAllDresseursRegion3() {
        return dresseurService.findAllDresseursRegions3();
    }

    /**
     * Trouver un dresseur par son id (dresseur complet)
     * @param id l'id du dresseur
     * @return le dresseur recherché
     */
    @GetMapping("/find/{id}")
    public Dresseurs findById(@PathVariable Integer id) {
        return dresseurService.findById(id);
    }

    /**
     * Trouver un dresseur par son id (avec le DTO)
     * @param id l'id du dresseur
     * @return le dresseur recherché
     */
    @GetMapping("/{id}")
    public DresseurReduitDTO getById(@PathVariable Integer id) {
        return dresseurService.findDresseurById(id);
    }

    /**
     * Compter le nombre de dresseurs
     * @return le nombre de dresseurs
     */
    @GetMapping("/count")
    public Long getCountDresseurs() {
        return dresseurService.findDresseursCount();
    }

    /**
     * Mettre à jour un dresseur
     * @param dresseur le dresseur à mettre à jour
     * @return le dresseur mis à jour
     */
    @PatchMapping("/update")
    public Dresseurs updateDresseur(@RequestBody Dresseurs dresseur) {
        return dresseurService.updateDresseur(dresseur);
    }

    /**
     * Supprimer un dresseur par son id
     * @param id l'id du dresseur à supprimer
     * @return le dresseur supprimé
     */
    @DeleteMapping("/delete/{id}")
    public Dresseurs deleteDresseurById(@PathVariable Integer id) {
        return dresseurService.deleteById(id);
    }

    /**
     * Supprimer tous les dresseurs
     */
    @DeleteMapping("/delete/all")
    public void deleteAllDresseurs() {
        dresseurService.deleteAll();
    }

}
