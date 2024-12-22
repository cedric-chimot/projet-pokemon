package com.pokemon.service;

import com.pokemon.entity.Boites;
import com.pokemon.repository.BoitesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoiteService {
    private final BoitesRepository boitesRepository;

    public BoiteService(BoitesRepository boitesRepository) {
        this.boitesRepository = boitesRepository;
    }

    public Boites save(Boites boite) {
        return boitesRepository.save(boite);
    }
    
    public List<Boites> getAllBoites() {
        return boitesRepository.findAll();
    }
    
    public Optional<Boites> getBoiteById(Integer id) {
        return boitesRepository.findById(id);
    }

    public Map<String, List<Map<String, Object>>> getStatsByBoite(Integer boiteId) {
        Map<String, List<Map<String, Object>>> stats = new HashMap<>();

        stats.put("Pokeballs", mapStats(boitesRepository.findStatsByPokeball(boiteId)));
        stats.put("Dresseurs", mapStats(boitesRepository.findStatsByDresseur(boiteId)));
        stats.put("Sexes", mapStats(boitesRepository.findStatsBySexe(boiteId)));
        stats.put("Natures", mapStats(boitesRepository.findStatsByNature(boiteId)));
        stats.put("Types", mapStats(boitesRepository.findStatsByType(boiteId)));

        return stats;
    }

    public List<Map<String, Object>> mapStats(List<Object[]> results) {
        return results.stream()
                .map(result -> {
                    // Vérifie si la donnée concerne un dresseur
                    if (result.length == 3) { // Cas où il y a 3 éléments (idDresseur, nomDresseur, nbPokemon)
                        return Map.of(
                                "idDresseur", result[0],
                                "dresseur", result[1],
                                "nbPokemon", result[2]
                        );
                    } else { // Cas des autres éléments où il n'y a que 2 éléments (nomType, nbPokemon)
                        return Map.of(
                                "name", result[0],
                                "nbPokemon", result[1]
                        );
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * Mettre à jour une boite
     * @param boite L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Boites update(Boites boite) {
        return boitesRepository.save(boite);
    }

    /**
     * Méthode pour supprimer une boite par son Id
     * @param id L'identifiant d'une boite à supprimer
     * @return L'objet supprimé
     */
    public Boites deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Boites> optionalboite = boitesRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalboite.isPresent()) {
            Boites boite = optionalboite.get();
            boitesRepository.delete(boite); // Supprimer l'objet
            return boite; // Retourner l'objet supprimé
        } else {
            throw new EntityNotFoundException("Boites with id " + id + " not found");
        }
    }

    /**
     * Supprimer tous les boites
     */
    public void deleteAll() {
        boitesRepository.deleteAll();
    }


}
