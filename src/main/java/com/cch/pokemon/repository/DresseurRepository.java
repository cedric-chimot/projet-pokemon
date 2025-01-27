package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Dresseurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DresseurRepository extends JpaRepository<Dresseurs, Integer> {

    /**
     * Afficher les dresseurs au nombre de pokémon > 0
     * @return la liste des dresseurs
     */
    @Query("SELECT d FROM Dresseurs d WHERE d.nbPokemon > 0 AND d.nomDresseur != 'Event'")
    List<Dresseurs> findAllDresseursReduit();

    /**
     * Requête pour afficher tous les dresseurs de la région 1 (non découpés)
     */
    @Query("SELECT d FROM Dresseurs d " +
            "WHERE d.regionDresseur.idRegionDresseur = 1 " +
            "AND d.regionDresseur IS NOT NULL " +
            "AND d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursByRegion1();

    /**
     * Requêtes pour afficher des listes de dresseurs
     * de la région 1, divisée en deux groupes
     */
    @Query("SELECT d FROM Dresseurs d " +
            "WHERE d.regionDresseur.idRegionDresseur = 1 " +
            "AND d.id BETWEEN 1 AND 40 " +
            "AND d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursByRegion1Part1();

    @Query("SELECT d FROM Dresseurs d " +
            "WHERE d.regionDresseur.idRegionDresseur = 1 " +
            "AND d.id BETWEEN 41 AND 81 AND " +
            "d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursByRegion1Part2();

    /**
     * Requête pour afficher les dresseurs de la region 2
     */
    @Query("SELECT d FROM Dresseurs d " +
            "WHERE d.regionDresseur.idRegionDresseur = 2 " +
            "AND d.regionDresseur IS NOT NULL " +
            "AND d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursRegion2();

    /**
     * Requête pour afficher les dresseurs de la region 3
     */
    @Query("SELECT d FROM Dresseurs d " +
            "WHERE d.regionDresseur.idRegionDresseur = 3 " +
            "AND d.regionDresseur IS NOT NULL " +
            "AND d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursRegion3();

    /**
     * Requête pour compter le nombre total de dresseurs, en excluant certains Ids et ceux sans pokemon
      * @return le nombre de dresseurs
     */
    @Query("SELECT COUNT(d) FROM Dresseurs d WHERE (d.id < 119 OR d.id > 140) AND d.nbPokemon > 0")
    Long countDresseurs();

}
