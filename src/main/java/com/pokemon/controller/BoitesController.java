package com.pokemon.controller;

import com.pokemon.entity.Boites;
import com.pokemon.service.BoiteService;
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

    // Récupérer les statistiques par boîte
    @GetMapping("/{boiteId}/{type}")
    public ResponseEntity<List<Map<String, Object>>> getStatsParBoite(
            @PathVariable Integer boiteId,
            @PathVariable String type) {
        try {
            List<Map<String, Object>> stats = boiteService.getStatsParBoite(type, boiteId);
            return ResponseEntity.ok(stats);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Récupérer les statistiques globales
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
     * Mettre à jour une boite
     * @param boite la boite à mettre à jour
     * @return la boite mise à jour
     */
    @PatchMapping("/update")
    public Boites updateboite(@RequestBody Boites boite) {
        return boiteService.update(boite);
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
