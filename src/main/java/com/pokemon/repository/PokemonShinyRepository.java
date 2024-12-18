package com.pokemon.repository;

import com.pokemon.dto.PokemonDTO;
import com.pokemon.entity.PokemonShiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PokemonShinyRepository extends JpaRepository<PokemonShiny, Integer> {

    /*
    * Requête pour afficher un pokemon selon son numéro de pokedex
    * */
    @Query("SELECT new com.pokemon.dto.PokemonDTO(p.id, p.numDex, p.nomPokemon) FROM PokemonShiny p WHERE p.numDex = :numDex")
    List<PokemonDTO> findByNumDex(@Param("numDex") String numDex);


}
