package com.pokemon.controller;

import com.pokemon.entity.Boites;
import com.pokemon.service.BoiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/boites")
@CrossOrigin
public class BoitesController {

    private final BoiteService boiteService;

    public BoitesController(BoiteService boiteService) {
        this.boiteService = boiteService;
    }

    @GetMapping
    public List<Boites> getAllBoites() {
        return boiteService.getAllBoites();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boites> getBoiteById(@PathVariable Integer id) {
        Optional<Boites> boite = boiteService.getBoiteById(id);
        return boite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{boiteId}/stats")
    @ResponseBody
    public Map<String, List<Map<String, Object>>> getStats(@PathVariable Integer boiteId) {
        return boiteService.getStatsByBoite(boiteId);
    }

    @PostMapping("/create")
    public ResponseEntity<Boites> createBoite(@RequestBody Boites boite) {
        Boites savedBoite = boiteService.save(boite);
        return ResponseEntity.ok(savedBoite);
    }

    /**
     * Mettre à jour un boite
     * @param boite le boite à mettre à jour
     * @return le boite mis à jour
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
     * Supprimer tous les boites
     */
    @DeleteMapping("/delete/all")
    public void deleteAllShinies() {
        boiteService.deleteAll();
    }

}
