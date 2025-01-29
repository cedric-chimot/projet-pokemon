package com.cch.pokemon.controller;

import com.cch.pokemon.entity.Attaques;
import com.cch.pokemon.entity.PokemonShiny;
import com.cch.pokemon.entity.ShinyAttaques;
import com.cch.pokemon.service.ShinyAttaquesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shinyAttaques")
@CrossOrigin
public class ShinyAttaquesController {

    private ShinyAttaquesService shinyAttaquesService;

    public ShinyAttaquesController(ShinyAttaquesService shinyAttaquesService) {
        this.shinyAttaquesService = shinyAttaquesService;
    }

    /**
     * Ajouter une association
     * @param shinyAttaque l'association à ajouter
     * @return la nouvelle association
     */
    @PostMapping("/create")
    public ResponseEntity<ShinyAttaques> addShinyAttaque(@RequestBody ShinyAttaques shinyAttaque) {
        ShinyAttaques shinyAttaqueSave = shinyAttaquesService.addShinyAttaque(
                shinyAttaque.getPokemonShiny().getId(),
                shinyAttaque.getAttaques().getId(),
                shinyAttaque.getPosition()
        );
        return ResponseEntity.ok(shinyAttaqueSave);
    }

    /**
     * Récupérer toutes les associations
     * @return la liste des associations
     */
    @GetMapping("/all")
    public List<ShinyAttaques> getAllShinyAttaques() {
        return shinyAttaquesService.getAllShinyAttaques();
    }

    /**
     * Récupérer une association par son id
     * @param id l'id de l'association recherchée
     * @return l'association trouvée
     */
    @GetMapping("/{id}")
    public ResponseEntity<ShinyAttaques> getShinyAttaqueById(@PathVariable Long id) {
        Optional<ShinyAttaques> shinyAttaque = shinyAttaquesService.getShinyAttaqueById(id);
        return shinyAttaque.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Récupérer toutes les attaques associées à un Pokémon shiny par son ID
     * @param shinyId l'id du Pokémon shiny
     * @return la liste des attaques associées
     */
    @GetMapping("/shiny/{shinyId}")
    public ResponseEntity<List<ShinyAttaques>> getAttaquesByShinyId(@PathVariable Integer shinyId) {
        List<ShinyAttaques> shinyAttaques = shinyAttaquesService.findAttaquesByShinyId(shinyId);

        if (shinyAttaques.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(shinyAttaques);
    }

    /**
     * Mettre à jour un shiny
     * @param shiny le shiny à mettre à jour
     * @return le shiny mis à jour
     */
    @PutMapping("/update")
    public ShinyAttaques updateShinyAttaque(@RequestBody ShinyAttaques shinyAttaques) {
        return shinyAttaquesService.updateShinyAttaque(shinyAttaques);
    }

    /**
     * Supprimer une association par son id
     * @param id l'id de l'association recherchée
     * @return l"association trouvée
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShinyAttaque(@PathVariable Long id) {
        shinyAttaquesService.deleteShinyAttaque(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Supprimer toutes les associations
     */
    @DeleteMapping("/delete/all")
    public void deleteAllTypes() {
        shinyAttaquesService.deleteAllShinyAttaques();
    }

}
