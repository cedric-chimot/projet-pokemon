package com.cch.pokemon.repository;

import com.cch.pokemon.entity.ShinyAttaques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShinyAttaquesRepository extends JpaRepository<ShinyAttaques, Long> {

    @Query("SELECT sa FROM ShinyAttaques sa WHERE sa.pokemonShiny.id = :pokemonShinyId ORDER BY sa.position")
    List<ShinyAttaques> findByPokemonShinyId(@Param("pokemonShinyId") Integer pokemonShinyId);

}
