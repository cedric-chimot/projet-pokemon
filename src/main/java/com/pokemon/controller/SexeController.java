package com.pokemon.controller;

import com.pokemon.dto.SexeDTO;
import com.pokemon.entity.Sexe;
import com.pokemon.service.SexeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sexes")
public class SexeController {
    /**
     * Le service des sexes
     */
    private final SexeService sexeService;

    /**
     * Le constructeur
     * @param sexeService Injection du service
     */
    public SexeController(SexeService sexeService) {
        this.sexeService = sexeService;
    }

    /**
     * Ajouter un nouveau sexe
     * @param sexe le sexe à ajouter
     * @return le sexe nouvellement ajouté
     */
    @PostMapping("/create")
    public Sexe addSexe(@RequestBody Sexe sexe) {
        return sexeService.save(sexe);
    }

    /**
     * Afficher la liste de tous les sexes
     * @return la liste
     */
    @GetMapping
    public List<SexeDTO> findAll() {
        return sexeService.findAllSexes();
    }

    /**
     * Trouver un sexe par son id
     * @param id l'id du sexe
     * @return le sexe recherché
     */
    @GetMapping("/{id}")
    public Optional<SexeDTO> getById(@PathVariable Integer id) {
        return sexeService.findSexeById(id);
    }

    /**
     * Mettre à jour un sexe
     * @param sexe le sexe à mettre à jour
     * @return le sexe mis à jour
     */
    @PatchMapping("/update")
    public Sexe updateSexe(@RequestBody Sexe sexe) {
        return sexeService.update(sexe);
    }

    /**
     * Supprimer un sexe par son id
     * @param id l'id du sexe à supprimer
     * @return le sexe supprimé
     */
    @DeleteMapping("/delete/{id}")
    public Sexe deleteSexeById(@PathVariable Integer id) {
        return sexeService.deleteById(id);
    }

    /**
     * Supprimer tous les sexes
     */
    @DeleteMapping("/delete/all")
    public void deleteAllSexes() {
        sexeService.deleteAll();
    }

}
