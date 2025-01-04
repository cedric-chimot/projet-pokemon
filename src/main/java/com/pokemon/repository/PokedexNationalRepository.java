package com.pokemon.repository;

import com.pokemon.entity.PokedexNational;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokedexNationalRepository extends JpaRepository<PokedexNational, Long> {
    @Query("SELECT p FROM PokedexNational p " +
            "JOIN FETCH p.naturePokedex " +
            "JOIN FETCH p.pokeballPokedex " +
            "JOIN FETCH p.boitePokedex " +
            "JOIN FETCH p.dresseurPokedex")
    List<PokedexNational> findAllPokemonsWithRelations();

}
