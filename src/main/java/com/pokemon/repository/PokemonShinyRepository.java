package com.pokemon.repository;

import com.pokemon.dto.PokemonReduitDTO;
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
    List<PokemonReduitDTO> findByNumDex(@Param("numDex") String numDex);

    @Query("SELECT p FROM PokemonShiny p WHERE p.boite = :boite ORDER BY p.position ASC")
    List<PokemonShiny> findByBoitePosition(@Param("boite") String boite);

    @Query("SELECT p.ivManquant AS ivManquant, COUNT(p) AS count " +
            "FROM PokemonShiny p " +
            "GROUP BY p.ivManquant " +
            "ORDER BY p.ivManquant")
    List<Object[]> getStatsIvManquant();

}
