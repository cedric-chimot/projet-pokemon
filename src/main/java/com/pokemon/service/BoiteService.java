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

/**
 * Service pour gérer les méthodes des boites
 */
@Service
@Transactional
public class BoiteService {

    /**
     * Le repository des boites
     */
    private final BoitesRepository boitesRepository;

    /**
     * Constructeur du service
     * @param boitesRepository Injection du repository des boites
     */
    public BoiteService(BoitesRepository boitesRepository) {
        this.boitesRepository = boitesRepository;
    }

    /**
     * Méthode pour créer une nouvelle boite
     * @param boite la boite à créer
     * @return la boite nouvellement créée
     */
    public Boites save(Boites boite) {
        return boitesRepository.save(boite);
    }

    /**
     * Afficher toutes les boites
     * @return la liste des boites
     */
    public List<Boites> getAllBoites() {
        return boitesRepository.findAll();
    }

    /**
     * Trouver une boite avec son id
     * @param id l'id de la boite recherchée
     * @return la boite trouvée et toutes ses données
     */
    public Optional<Boites> getBoiteById(Integer id) {
        return boitesRepository.findById(id);
    }

    /**
     * Récupère les statistiques d'une boîte spécifiée en fonction de l'ID de la boîte.
     * Les statistiques incluent les données sur les Pokéballs, Dresseurs, Sexes, Natures et Types.
     *
     * @param boiteId L'ID de la boîte dont on veut récupérer les statistiques.
     * @return Un map contenant des statistiques sous forme de liste pour chaque catégorie :
     *         Pokéballs, Dresseurs, Sexes, Natures, Types.
     */
    public Map<String, Object> getAllStats(Integer boiteId) {
        Map<String, Object> stats = new HashMap<>();

        stats.put("Pokeballs", mapStats(boitesRepository.findStatsByPokeball(boiteId)));
        stats.put("Dresseurs", mapStats(boitesRepository.findStatsByDresseur(boiteId)));
        stats.put("Sexes", mapStats(boitesRepository.findStatsBySexe(boiteId)));
        stats.put("Natures", mapStats(boitesRepository.findStatsByNature(boiteId)));
        stats.put("Types", mapStats(boitesRepository.findStatsByType(boiteId)));

        return stats;
    }

    public List<Map<String, Object>> getDresseursStats(Integer boiteId) {
        List<Object[]> results = boitesRepository.findStatsByDresseur(boiteId);
        return mapStats(results);
    }

    public List<Map<String, Object>> getPokeballsStats(Integer boiteId) {
        List<Object[]> results = boitesRepository.findStatsByPokeball(boiteId);
        return mapStats(results);
    }

    public List<Map<String, Object>> getNaturesStats(Integer boiteId) {
        List<Object[]> results = boitesRepository.findStatsByNature(boiteId);
        return mapStats(results);
    }

    public List<Map<String, Object>> getSexesStats(Integer boiteId) {
        List<Object[]> results = boitesRepository.findStatsBySexe(boiteId);
        return mapStats(results);
    }

    public List<Map<String, Object>> getTypesStats(Integer boiteId) {
        List<Object[]> results = boitesRepository.findStatsByType(boiteId);
        return mapStats(results);
    }

    /**
     * Transforme une liste de résultats sous forme d'objets en une liste de maps contenant les données correspondantes.
     * Cette méthode traite différemment les cas où les résultats contiennent 2 ou 3 éléments :
     * Si le résultat contient trois éléments, c'est un dresseur et les données sont mappées avec "idDresseur", "dresseur" et "nbPokemon".
     * Si le résultat contient deux éléments, ce sont d'autres statistiques et les données sont mappées avec "name" et "nbPokemon".
     *
     * @param results Une liste d'objets représentant les résultats récupérés (par exemple depuis une requête SQL).
     * @return Une liste de maps, chaque map contenant les informations mappées selon la structure des résultats.
     */
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
     * Supprimer toutes les boites
     */
    public void deleteAll() {
        boitesRepository.deleteAll();
    }

}
