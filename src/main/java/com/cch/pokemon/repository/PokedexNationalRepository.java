package com.cch.pokemon.repository;

import com.cch.pokemon.entity.PokedexNational;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PokedexNationalRepository extends JpaRepository<PokedexNational, Long> {

    // Requête de relation entre le pokedex et les entités liées
    @Query("SELECT p FROM PokedexNational p " +
            "JOIN FETCH p.naturePokedex " +
            "JOIN FETCH p.pokeballPokedex " +
            "JOIN FETCH p.boitePokedex " +
            "JOIN FETCH p.dresseurPokedex")
    List<PokedexNational> findAllPokemonsWithRelations();

    // Requête qui retourne les pokémons d'une région spécifique en utilisant l'ID de la région
    @Query("SELECT p FROM PokedexNational p WHERE p.region.id = :regionId")
    List<PokedexNational> findByRegion(@Param("regionId") Long regionId);

    /**
     * Requête pour compter le nombre total de pokemons dans le pokedex
     * @return le nombre de pokemons
     */
    @Query("SELECT COUNT(p) FROM PokedexNational p")
    Long countPokemonsInPokedex();

}
