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

    /**
     * Afficher la liste des stats d'une boite
     * @param boiteId l'id de la boite recherchée
     * @return la boite trouvée et ses statistiques
     */
    @GetMapping("/{boiteId}/all-stats")
    public ResponseEntity<Map<String, Object>> getAllStats(@PathVariable Integer boiteId) {
        return ResponseEntity.ok(boiteService.getAllStats(boiteId));
    }

    @GetMapping("/{boiteId}/dresseurs")
    public ResponseEntity<List<Map<String, Object>>> getDresseursStats(@PathVariable Integer boiteId) {
        List<Map<String, Object>> stats = boiteService.getDresseursStats(boiteId);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/{boiteId}/pokeballs")
    public ResponseEntity<List<Map<String, Object>>> getPokeballsStats(@PathVariable Integer boiteId) {
        List<Map<String, Object>> stats = boiteService.getPokeballsStats(boiteId);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/{boiteId}/natures")
    public ResponseEntity<List<Map<String, Object>>> getNaturesStats(@PathVariable Integer boiteId) {
        List<Map<String, Object>> stats = boiteService.getNaturesStats(boiteId);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/{boiteId}/sexes")
    public ResponseEntity<List<Map<String, Object>>> getSexesStats(@PathVariable Integer boiteId) {
        List<Map<String, Object>> stats = boiteService.getSexesStats(boiteId);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/{boiteId}/types")
    public ResponseEntity<List<Map<String, Object>>> getTypesStats(@PathVariable Integer boiteId) {
        List<Map<String, Object>> stats = boiteService.getTypesStats(boiteId);
        return ResponseEntity.ok(stats);
    }

    // Récupérer les statistiques générales par catégorie (Pokeballs, Dresseurs, etc.)
    @GetMapping("/general/{boiteId}/{type}")
    public ResponseEntity<List<Map<String, Object>>> getGeneralStats(
            @PathVariable Integer boiteId,
            @PathVariable String type) {

        // Appel au service pour récupérer les statistiques
        List<Map<String, Object>> stats = boiteService.getGeneralStats(boiteId, type);

        // Retourner les résultats avec un statut HTTP 200 OK
        return ResponseEntity.ok(stats);
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
