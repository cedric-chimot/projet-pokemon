package com.pokemon.repository;

import com.pokemon.entity.Boites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoitesRepository extends JpaRepository<Boites, Integer> {

    @Query("SELECT p.nomPokeball AS pokeball, bp.nbPokemon " +
            "FROM BoitePokeball bp " +
            "JOIN bp.pokeball p " +
            "WHERE bp.boite.id = :boiteId")
    List<Object[]> findStatsByPokeball(@Param("boiteId") Integer boiteId);

    @Query("SELECT d.idDresseur AS idDresseur, d.nomDresseur AS dresseur, bd.nbPokemon " +
            "FROM BoiteDresseur bd " +
            "JOIN bd.dresseur d " +
            "WHERE bd.boite.id = :boiteId")
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
