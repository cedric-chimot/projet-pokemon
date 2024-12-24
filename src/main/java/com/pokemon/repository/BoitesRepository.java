package com.pokemon.repository;

import com.pokemon.entity.Boites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoitesRepository extends JpaRepository<Boites, Integer> {

    // Stats globales par Pokeball
    @Query("SELECT p.nomPokeball AS pokeball, p.nbShiny " +
            "FROM Pokeballs p " +
            "WHERE p.nbShiny > 0 AND p.nbShiny IS NOT NULL")
    List<Object[]> allStatsByPokeball();

    // Stats globales par Dresseur
    @Query("SELECT d.idDresseur, d.nomDresseur AS dresseur, d.nbShiny " +
            "FROM Dresseurs d " +
            "WHERE d.nbShiny > 0 AND d.nbShiny IS NOT NULL")
    List<Object[]> allStatsByDresseur();

    // Stats globales par Sexe
    @Query("SELECT s.sexe AS sexe, s.nbShiny " +
            "FROM Sexe s")
    List<Object[]> allStatsBySexe();

    // Stats globales par Nature
    @Query("SELECT n.nomNature AS nature, n.nbShiny " +
            "FROM Natures n " +
            "WHERE n.nbShiny > 0 AND n.nbShiny IS NOT NULL")
    List<Object[]> allStatsByNature();

    // Stats globales par Type
    @Query("SELECT t.nomType AS type, t.nbShiny " +
            "FROM Types t")
    List<Object[]> allStatsByType();

    @Query("SELECT p.nomPokeball AS pokeball, bp.nbPokemon " +
            "FROM BoitePokeball bp " +
            "JOIN bp.pokeball p " +
            "WHERE bp.boite.id = :boiteId")
    List<Object[]> findStatsByPokeball(@Param("boiteId") Integer boiteId);

    @Query("SELECT d.idDresseur AS idDresseur, d.nomDresseur AS dresseur, bd.nbPokemon " +
            "FROM BoiteDresseur bd " +
            "JOIN bd.dresseur d " +
            "WHERE bd.boite.id = :boiteId ")
    List<Object[]> findStatsByDresseur(@Param("boiteId") Integer boiteId);

    @Query("SELECT s.sexe AS sexe, bs.nbPokemon " +
            "FROM BoiteSexe bs " +
            "JOIN bs.sexe s " +
            "WHERE bs.boite.id = :boiteId")
    List<Object[]> findStatsBySexe(@Param("boiteId") Integer boiteId);

    @Query("SELECT n.nomNature AS nature, bn.nbPokemon " +
            "FROM BoiteNature bn " +
            "JOIN bn.nature n " +
            "WHERE bn.boite.id = :boiteId")
    List<Object[]> findStatsByNature(@Param("boiteId") Integer boiteId);

    @Query("SELECT t.nomType AS type, bt.nbPokemon " +
            "FROM BoiteType bt " +
            "JOIN bt.type t " +
            "WHERE bt.boite.id = :boiteId")
    List<Object[]> findStatsByType(@Param("boiteId") Integer boiteId);

}
