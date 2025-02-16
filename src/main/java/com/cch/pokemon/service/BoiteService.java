package com.cch.pokemon.service;

import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.BoitesRepository;
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
  public Boites findBoiteById(Integer id) {
      return boitesRepository.findById(id)
        .orElseThrow(() -> new CustomException("Boite", "id", id)); // Renvoie l'entité
  }

  /**
   * Récupération des statistiques globales
   * @param type le type pour lequel on récupère les données
   * @return toutes les stats pour chaque type
   */
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
      return mapAllStats(results, type);
  }

  /**
   * Récupération des statistiques par boite
   * @param type le type pour lequel on récupère les données
   * @param boiteId l'identifiant de la boite
   * @return toutes les stats pour chaque type par boite
   */
  public List<Map<String, Object>> getStatsByBoite(String type, Integer boiteId) {
      type = type.toLowerCase();
      List<Object[]> results = switch (type) {
          case "pokeballs" -> boitesRepository.statsByBoitePokeball(boiteId);
          case "dresseurs" -> boitesRepository.statsByBoiteDresseur(boiteId);
          case "natures" -> boitesRepository.statsByBoiteNature(boiteId);
          case "sexes" -> boitesRepository.statsByBoiteSexe(boiteId);
          case "types" -> boitesRepository.statsByBoiteType(boiteId);
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
  private List<Map<String, Object>> mapAllStats(List<Object[]> results, String type) {
      return results.stream()
              .map(result -> {
                  if ("dresseurs".equals(type) && result.length == 3) {
                      // Gérer le cas de `idDresseur` qui peut être NULL
                      Object idDresseur = result[2] == null ? "Aucun ID" : result[2];
                      return Map.of(
                              "numDresseur", idDresseur,
                              "dresseur", result[0],
                              "nbShiny", result[1]
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

  /**
   * Mapping d'une liste de résultats pour regrouper les données par boite
   * @param results la liste de résultat
   * @param type le type de données (dresseur, pokeball etc)
   * @return Une liste de résultats de données pour chaque type
   */
  private List<Map<String, Object>> mapBoiteStats(List<Object[]> results, String type) {
      return results.stream()
              .map(result -> {
                if ("dresseurs".equals(type) && result.length == 4) {
                  return Map.of(
                    "dresseur", result[0],
                    "nbPokemon", result[1],
                    "numDresseur", result[2],
                    "idDresseur", result[3] != null ? result[3] : "Event"  // Si NULL, on met "Event"
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
   * Méthode pour retrouver le nombre total de boites shiny
   * @return le nombre de boites
   */
  public Long findBoitesCount() {
      return boitesRepository.countBoitesShiny();
  }

  /**
   * Trouver une boite par son nom
   * @param nomBoite le nom de la boite
   * @return la boite par son nom
   */
  public Boites findByNom(String nomBoite) {
    return boitesRepository.findByNom(nomBoite);  // Assume qu'il y a une méthode dans ton repository qui trouve une Boite par son nom
  }

  /**
   * Mettre à jour une boite
   * @param boite L'objet à mettre à jour
   * @return L'objet mis à jour
   */
  public Boites updateBoite(Boites boite) {
      Optional<Boites> existingBoiteShiny= boitesRepository.findById(boite.getId());

      if (existingBoiteShiny.isPresent()) {
          Boites existingBoite = existingBoiteShiny.get();

          existingBoite.setNom(boite.getNom());
          existingBoite.setNbLevel100(boite.getNbLevel100());
          return boitesRepository.save(existingBoite);
      } else {
          throw new CustomException("La boite est inconnue", "id", boite.getId());
      }
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
          throw new CustomException("Boite", "id",  id);
      }
  }

  /**
   * Supprimer toutes les boites
   */
  public void deleteAll() {
      boitesRepository.deleteAll();
  }

}
