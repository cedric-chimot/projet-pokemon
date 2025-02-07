package com.cch.pokemon.controller;

import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.service.BoiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Le controller des boites
 */
@RestController
@RequestMapping("/api/boites")
@CrossOrigin
public class BoitesController {

    /**
     * Variable pour appeler le service
     */
    private final BoiteService boiteService;

    /**
     * Le constructeur du controller
     * @param boiteService Injection du service
     */
    public BoitesController(BoiteService boiteService) {
        this.boiteService = boiteService;
    }

    /**
     * Créer une nouvelle boite
     * @param boite la boite à créer
     * @return la nouvelle boite
     */
    @PostMapping("/create")
    public ResponseEntity<Boites> createBoite(@RequestBody Boites boite) {
        Boites savedBoite = boiteService.save(boite);
        return ResponseEntity.ok(savedBoite);
    }

    /**
     * Afficher toutes les boites
     * @return la liste des boites
     */
    @GetMapping
    public List<Boites> getAllBoites() {
        return boiteService.getAllBoites();
    }

    /**
     * Rechercher une boite par son id
     * @param id l'id de la boite
     * @return la boite trouvée
     */
    @GetMapping("/{id}")
    public ResponseEntity<Boites> getBoiteById(@PathVariable Integer id) {
        Optional<Boites> boite = boiteService.getBoiteById(id);
        return boite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Récupérer les stats par boite et par type
     * @param boiteId l'id de la boite
     * @param type le type pour lequel on récupère les données (par exemple 'pokeballs', 'dresseurs', etc.)
     * @return les stats par boite pour chaque type
     */
    @GetMapping("/{boiteId}/{type}")
    public ResponseEntity<List<Map<String, Object>>> getStatsByBoite(
            @PathVariable Integer boiteId,
            @PathVariable String type) {
        try {
            List<Map<String, Object>> stats = boiteService.getStatsByBoite(type, boiteId);
            return ResponseEntity.ok(stats);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Récupère les statistiques globales pour un type donné.
     * @param type Le type de statistique (par exemple 'pokeballs', 'dresseurs', etc.)
     * @return La liste globale des données d'un type
     */
    @GetMapping("/global/{type}")
    public ResponseEntity<List<Map<String, Object>>> getStatsGlobales(@PathVariable String type) {
        try {
            List<Map<String, Object>> stats = boiteService.getStatsGlobales(type);
            return ResponseEntity.ok(stats);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Compter le nombre de boites shiny
     * @return le nombre de boites
     */
    @GetMapping("/count")
    public Long getCountBoitesShiny() {
        return boiteService.findBoitesCount();
    }

    /**
     * Mettre à jour une boite
     * @param boite la boite à mettre à jour
     * @return la boite mise à jour
     */
    @PatchMapping("/update")
    public Boites updateboite(@RequestBody Boites boite) {
        return boiteService.updateBoite(boite);
    }

    /**
     * Supprimer une boite par son id
     * @param id l'id d'une boite à supprimer
     * @return la boite supprimée
     */
    @DeleteMapping("/delete/{id}")
    public Boites deleteBoiteById(@PathVariable Integer id) {
        return boiteService.deleteById(id);
    }

    /**
     * Supprimer toutes les boites
     */
    @DeleteMapping("/delete/all")
    public void deleteAllShinies() {
        boiteService.deleteAll();
    }

}
