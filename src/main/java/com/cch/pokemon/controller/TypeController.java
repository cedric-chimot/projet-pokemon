package com.cch.pokemon.controller;

import com.cch.pokemon.dto.TypeDTO;
import com.cch.pokemon.entity.Types;
import com.cch.pokemon.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/types")
@CrossOrigin
public class TypeController {
    /**
     * Le service des types
     */
    private final TypeService typeService;

    /**
     * Le constructeur
     * @param typeService Injection du service
     */
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    /**
     * Ajouter un nouveau type
     * @param type le type à ajouter
     * @return le type nouvellement ajouté
     */
    @PostMapping("/create")
    public Types addType(@RequestBody Types type) {
        return typeService.save(type);
    }

    /**
     * Afficher la liste de tous les types
     * @return la liste
     */
    @GetMapping("/all")
    public List<TypeDTO> findAll() {
        return typeService.findAllTypes();
    }

    /**
     * Trouver un type par son id
     * @param id l'id du type
     * @return le type recherché
     */
    @GetMapping("/{id}")
    public Optional<TypeDTO> getById(@PathVariable Integer id) {
        return typeService.findTypeById(id);
    }

    /**
     * Mettre à jour un type
     * @param type le type à mettre à jour
     * @return le type mis à jour
     */
    @PatchMapping("/update")
    public Types updateType(@RequestBody Types type) {
        return typeService.update(type);
    }

    /**
     * Supprimer un type par son id
     * @param id l'id du type à supprimer
     * @return le type supprimé
     */
    @DeleteMapping("/delete/{id}")
    public Types deleteTypeById(@PathVariable Integer id) {
        return typeService.deleteById(id);
    }

    /**
     * Supprimer tous les types
     */
    @DeleteMapping("/delete/all")
    public void deleteAllTypes() {
        typeService.deleteAll();
    }

}
