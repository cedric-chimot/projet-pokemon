package com.pokemon.repository;

import com.pokemon.entity.PokemonShiny;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonShinyRepository extends JpaRepository<PokemonShiny, Integer> {
}
