package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Attaques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttaquesRepository extends JpaRepository<Attaques, Long> {

    /**
     * Requête pour compter le nombre total d'attaques
     * @return le nombre total d'attaques
     */
    @Query("SELECT COUNT(a) FROM Attaques a")
    Long countAttaques();

    /**
     * Requête qui retourne les attaques d'un type spécifique en utilisant l'ID du type
     * @param typeId l'identifiant du type
     * @return la liste des attaques correspondant au type
     */
    @Query("SELECT a FROM Attaques a WHERE a.typeAttaque.id = :typeId")
    List<Attaques> findByType(@Param("typeId") Integer typeId);

    /**
     * Requête pour afficher le nombre d'attaques par types
     * @return le nombre d'attaques triées par types
     */
    @Query("SELECT t.nomType, COUNT(a) " +
            "FROM Attaques a JOIN a.typeAttaque t " +
            "GROUP BY t.nomType")
    List<Object[]> countAttaquesByType();

}
