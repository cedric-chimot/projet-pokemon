package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Boites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoitesRepository extends JpaRepository<Boites, Integer> {

  // Requête personnalisée pour trouver une boîte par son nom
  @Query("SELECT b FROM Boites b WHERE b.nom = :nom")
  Boites findByNom(@Param("nom") String nom);

  // Stats globales par Pokeball
  @Query("SELECT p.nomPokeball AS pokeball, p.nbShiny " +
        "FROM Pokeballs p " +
        "WHERE p.nbShiny > 0 AND p.nbShiny IS NOT NULL " +
        "ORDER BY p.nbShiny DESC")
  List<Object[]> allStatsByPokeball();

  // Retourne une liste d'objets avec les résultats des statistiques des dresseurs
  @Query("SELECT " +
        "CASE WHEN d.nomDresseur = 'event' THEN 'event' ELSE d.nomDresseur END AS dresseur, " +
        "SUM(bd.nbPokemon) AS nbPokemon, " +
        "CASE WHEN d.nomDresseur = 'event' THEN 'event' ELSE d.numDresseur END AS numDresseur " +
        "FROM BoiteDresseur bd " +
        "JOIN bd.dresseur d " +
        "GROUP BY CASE WHEN d.nomDresseur = 'event' THEN 'event' ELSE d.nomDresseur END, " +
        "CASE WHEN d.nomDresseur = 'event' THEN 'event' ELSE d.numDresseur END " +
        "ORDER BY numDresseur, dresseur")
  List<Object[]> allStatsByDresseur();

  // Stats globales par Sexe
  @Query("SELECT s.sexe AS sexe, s.nbShiny " +
        "FROM Sexe s")
  List<Object[]> allStatsBySexe();

  // Stats globales par Nature
  @Query("SELECT n.nomNature AS nature, n.nbShiny " +
        "FROM Natures n " +
        "WHERE n.nbShiny > 0 AND n.nbShiny IS NOT NULL " +
        "ORDER BY n.nbShiny DESC")
  List<Object[]> allStatsByNature();

  // Stats globales par Type
  @Query("SELECT t.nomType AS type, t.nbShiny " +
        "FROM Types t")
  List<Object[]> allStatsByType();

  // Récupérer les stats d'une boîte spécifique pour les pokéballs
  @Query("SELECT p.nomPokeball AS pokeball, bp.nbPokemon " +
        "FROM BoitePokeball bp " +
        "JOIN bp.pokeball p " +
        "WHERE bp.boite.id = :boiteId")
  List<Object[]> statsByBoitePokeball(@Param("boiteId") Integer boiteId);

  // Récupérer les stats d'une boîte spécifique pour les dresseurs
  @Query("SELECT " +
        "CASE WHEN d1.nomDresseur = 'Event' THEN 'Event' ELSE d1.nomDresseur END AS dresseur, " +
        "SUM(bd1.nbPokemon) AS nbPokemon, " +
        "CASE WHEN d1.nomDresseur = 'Event' THEN 'Event' ELSE d1.numDresseur END AS numDresseur, " +
        "MAX(CASE WHEN d1.nomDresseur = 'Event' THEN NULL ELSE d1.id END) AS idDresseur " +  // Utiliser MAX pour rendre SQL heureux
        "FROM BoiteDresseur bd1 " +
        "JOIN bd1.dresseur d1 " +
        "WHERE bd1.boite.id = :boiteId " +
        "GROUP BY dresseur, numDresseur " +  // Pas d'idDresseur ici pour éviter le dégroupage
        "ORDER BY numDresseur, dresseur")
  List<Object[]> statsByBoiteDresseur(@Param("boiteId") Integer boiteId);

  // Récupérer les stats d'une boîte spécifique pour les genres
  @Query("SELECT s.sexe AS sexe, bs.nbPokemon " +
        "FROM BoiteSexe bs " +
        "JOIN bs.sexe s " +
        "WHERE bs.boite.id = :boiteId")
  List<Object[]> statsByBoiteSexe(@Param("boiteId") Integer boiteId);

  // Récupérer les stats d'une boîte spécifique pour les natures
  @Query("SELECT n.nomNature AS nature, bn.nbPokemon " +
        "FROM BoiteNature bn " +
        "JOIN bn.nature n " +
        "WHERE bn.boite.id = :boiteId")
  List<Object[]> statsByBoiteNature(@Param("boiteId") Integer boiteId);

  // Récupérer les stats d'une boîte spécifique pour les types
  @Query("SELECT t.nomType AS type, bt.nbPokemon " +
        "FROM BoiteType bt " +
        "JOIN bt.type t " +
          "WHERE bt.boite.id = :boiteId")
  List<Object[]> statsByBoiteType(@Param("boiteId") Integer boiteId);

  /**
   * Requête pour compter le nombre total de boites shiny
   * @return le nombre de boites
   */
  @Query("SELECT COUNT(b) FROM Boites b")
  Long countBoitesShiny();

}
