package com.pokemon.service;

import com.pokemon.entity.Boites;
import com.pokemon.repository.BoitesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

    // Récupérer les statistiques globales
    public List<Map<String, Object>> getStatsGlobales(String type) {
        type = type.toLowerCase();
        List<Object[]> results = switch (type) {
            case "pokeballs" -> boitesRepository.allStatsByPokeball();
            case "dresseurs" -> boitesRepository.allStatsByDresseur();
            case "natures" -> boitesRepository.allStatsByNature();
            case "sexes" -> boitesRepository.allStatsBySexe();
            case "types" -> boitesRepository.allStatsByType();
            default -> throw new IllegalArgumentException("Type inconnu : " + type);
        };
        return mapShinyStats(results, type);
    }

    // Récupérer les statistiques par boîte
    public List<Map<String, Object>> getStatsParBoite(String type, Integer boiteId) {
        type = type.toLowerCase();
        List<Object[]> results = switch (type) {
            case "pokeballs" -> boitesRepository.findStatsByPokeball(boiteId);
            case "dresseurs" -> boitesRepository.findStatsByDresseur(boiteId);
            case "natures" -> boitesRepository.findStatsByNature(boiteId);
            case "sexes" -> boitesRepository.findStatsBySexe(boiteId);
            case "types" -> boitesRepository.findStatsByType(boiteId);
            default -> throw new IllegalArgumentException("Type inconnu : " + type);
        };
        return mapBoiteStats(results, type);
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
    private List<Map<String, Object>> mapShinyStats(List<Object[]> results, String type) {
        return results.stream()
                .map(result -> {
                    if ("dresseurs".equals(type) && result.length == 3) {
                        return Map.of(
                                "idDresseur", result[0],
                                "dresseur", result[1],
                                "nbShiny", result[2]
                        );
                    } else if (result.length == 2) {
                        return Map.of(
                                "name", result[0],
                                "nbShiny", result[1]
                        );
                    } else {
                        throw new IllegalArgumentException("Unexpected result length: " + result.length);
                    }
                })
                .collect(Collectors.toList());
    }

    private List<Map<String, Object>> mapBoiteStats(List<Object[]> results, String type) {
        return results.stream()
                .map(result -> {
                    if ("dresseurs".equals(type) && result.length == 3) {
                        return Map.of(
                                "idDresseur", result[0],
                                "dresseur", result[1],
                                "nbPokemon", result[2]
                        );
                    } else if ("pokeballs".equals(type) && result.length == 2) {
                        return Map.of(
                                "pokeball", result[0], // Utilisation de la clé dynamique pour le type de pokeball
                                "nbPokemon", result[1]
                        );
                    } else if ("natures".equals(type) && result.length == 2) {
                        return Map.of(
                                "nature", result[0], // Clé dynamique pour nature
                                "nbPokemon", result[1]
                        );
                    } else if ("sexes".equals(type) && result.length == 2) {
                        return Map.of(
                                "sexe", result[0], // Clé dynamique pour sexe
                                "nbPokemon", result[1]
                        );
                    } else if ("types".equals(type) && result.length == 2) {
                        return Map.of(
                                "type", result[0], // Clé dynamique pour type
                                "nbPokemon", result[1]
                        );
                    } else {
                        throw new IllegalArgumentException("Unexpected result length: " + result.length);
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
