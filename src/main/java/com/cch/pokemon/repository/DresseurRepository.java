package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Dresseurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DresseurRepository extends JpaRepository<Dresseurs, Integer> {

    /**
     * Requêtes pour afficher des listes de dresseurs
     * dont l'id est compris entre deux ids distincts
     * @return les listes de dresseurs correspondantes
     */
    @Query("SELECT d FROM Dresseurs d WHERE d.id BETWEEN 1 AND 81 AND d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursByGeneration1();

    @Query("SELECT d FROM Dresseurs d WHERE (d.id BETWEEN 82 AND 118 OR d.id > 141) AND d.nbPokemon > 0")
    List<Dresseurs> findAllDresseursByGeneration2();

}
