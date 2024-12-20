package com.pokemon.controller;

import com.pokemon.dto.DresseurDTO;
import com.pokemon.entity.Dresseurs;
import com.pokemon.service.DresseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dresseurs")
@CrossOrigin
public class DresseurController {

    private final DresseurService dresseurService;

    public DresseurController(DresseurService dresseurService) {
        this.dresseurService = dresseurService;
    }

    @PostMapping("/create")
    public Dresseurs addDresseur(@RequestBody Dresseurs dresseurs) {
        return dresseurService.save(dresseurs);
    }

    @GetMapping
    public List<DresseurDTO> findAll() {
        return dresseurService.findAllDresseurs();
    }

    @GetMapping("/{id}")
    public Optional<DresseurDTO> getById(@PathVariable Integer id) {
        return dresseurService.findDresseurById(id);
    }

}
