package com.pokemon.controller;

import com.pokemon.dto.DresseurReduitDTO;
import com.pokemon.entity.Dresseurs;
import com.pokemon.service.DresseurService;
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
    public Dresseurs addDresseur(@RequestBody Dresseurs dresseur) {
        return dresseurService.save(dresseur);
    }

    /**
     * Afficher la liste de tous les dresseurs (complets)
     * en excluant ceux dont l'id est compris entre 119 et 141
     * @return la liste des dresseurs
     */
    @GetMapping("/find/all")
    public List<Dresseurs> findAllDresseursFiltered() {
        return dresseurService.findAllDresseursExceptSpecificRange();
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
     * Mettre à jour un dresseur
     * @param dresseur le dresseur à mettre à jour
     * @return le dresseur mis à jour
     */
    @PatchMapping("/update")
    public Dresseurs updateDresseur(@RequestBody Dresseurs dresseur) {
        return dresseurService.update(dresseur);
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
