package com.cch.pokemon.controller;

import com.cch.pokemon.entity.Attaques;
import com.cch.pokemon.service.AttaquesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controller d'une attaque
 */
@RestController
@RequestMapping("/api/attaques")
@CrossOrigin
public class AttaquesController {

    /**
     * Le service des attaques
     */
    private final AttaquesService attaqueService;

    /**
     * Le constructeur
     * @param attaqueService Injection du service
     */
    public AttaquesController(AttaquesService attaqueService) {
        this.attaqueService = attaqueService;
    }

    /**
     * Ajouter une nouvelle attaque
     * @param attaque l'attaque à ajouter
     * @return l'attaque nouvellement ajoutée
     */
    @PostMapping("/create")
    public ResponseEntity<Attaques> saveAttaque(@RequestBody Attaques attaque) {
        Attaques attaqueSave = attaqueService.save(
                attaque.getNomAttaque(),
                attaque.getTypeAttaque().getId()
        );
        return ResponseEntity.ok(attaqueSave);
    }

    /**
     * Afficher la liste de toutes les attaques
     * @return la liste des attaques
     */
    @GetMapping("/all")
    public List<Attaques> findAllAttaques() {
        return attaqueService.findAll();
    }

    /**
     * Trouver une attaque par son id
     * @param id l'id d'une attaque
     * @return l'attaque recherchée
     */
    @GetMapping("/{id}")
    public Attaques findById(@PathVariable Long id) {
        return attaqueService.findById(id);
    }

    /**
     * Afficher la liste des attaques pour un type donné
     * @param typeId l'identifiant du type
     * @return la liste des attaques
     */
    @GetMapping("/type/{typeId}")
    public ResponseEntity<List<Attaques>> getAttaquesByType(@PathVariable Integer typeId) {
        List<Attaques> attaquesList = attaqueService.findAttaquesByType(typeId);
        return ResponseEntity.ok(attaquesList);
    }

    /**
     * Compter le nombre d'attaques
     * @return le nombre d'attaques
     */
    @GetMapping("/count")
    public Long getCountAttaques() {
        return attaqueService.findAttaquesCount();
    }

    /**
     * Mettre à jour une attaque
     * @param attaque l'attaque à mettre à jour
     * @return l'attaque mise à jour
     */
    @PatchMapping("/update")
    public Attaques updateDresseur(@RequestBody Attaques attaque) {
        return attaqueService.updateAttaque(attaque);
    }

    /**
     * Supprimer un attaque par son id
     * @param id l'id d'une attaque à supprimer
     * @return l'attaque supprimée
     */
    @DeleteMapping("/delete/{id}")
    public Attaques deleteDresseurById(@PathVariable Long id) {
        return attaqueService.deleteById(id);
    }

    /**
     * Supprimer toutes les attaques
     */
    @DeleteMapping("/delete/all")
    public void deleteAllAttaques() {
        attaqueService.deleteAll();
    }

}
