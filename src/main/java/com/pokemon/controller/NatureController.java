package com.pokemon.controller;

import com.pokemon.dto.NatureDTO;
import com.pokemon.entity.Natures;
import com.pokemon.service.NatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/natures")
public class NatureController {
    /**
     * Le service des natures
     */
    private final NatureService natureService;

    /**
     * Le constructeur
     * @param natureService Injection du service
     */
    public NatureController(NatureService natureService) {
        this.natureService = natureService;
    }

    /**
     * Ajouter une nouvelle nature
     * @param nature le nature à ajouter
     * @return la nature nouvellement ajoutée
     */
    @PostMapping("/create")
    public Natures addNature(@RequestBody Natures nature) {
        return natureService.save(nature);
    }

    /**
     * Afficher la liste de toutes les natures
     * @return la liste
     */
    @GetMapping
    public List<NatureDTO> findAll() {
        return natureService.findAllNatures();
    }

    /**
     * Trouver une nature par son id
     * @param id l'id de la nature
     * @return la nature recherchée
     */
    @GetMapping("/{id}")
    public Optional<NatureDTO> getById(@PathVariable Integer id) {
        return natureService.findNatureById(id);
    }

    /**
     * Mettre à jour une nature
     * @param nature la nature à mettre à jour
     * @return le nature mis à jour
     */
    @PatchMapping("/update")
    public Natures updateNature(@RequestBody Natures nature) {
        return natureService.update(nature);
    }

    /**
     * Supprimer un nature par son id
     * @param id l'id de la nature à supprimer
     * @return la nature supprimé
     */
    @DeleteMapping("/delete/{id}")
    public Natures deleteNatureById(@PathVariable Integer id) {
        return natureService.deleteById(id);
    }

    /**
     * Supprimer toutes les natures
     */
    @DeleteMapping("/delete/all")
    public void deleteAllNatures() {
        natureService.deleteAll();
    }

}
