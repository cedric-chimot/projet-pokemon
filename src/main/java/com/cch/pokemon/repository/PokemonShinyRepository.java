package com.cch.pokemon.repository;

import com.cch.pokemon.dto.PokemonReduitDTO;
import com.cch.pokemon.entity.PokemonShiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PokemonShinyRepository extends JpaRepository<PokemonShiny, Integer> {

    /*
    * Requête pour afficher un pokemon selon son numéro de pokedex
    * */
    @Query("SELECT new com.cch.pokemon.dto.PokemonDTO(p.id, p.numDex, p.nomPokemon) FROM PokemonShiny p WHERE p.numDex = :numDex")
    List<PokemonReduitDTO> findByNumDex(@Param("numDex") String numDex);

    /**
     * Requête pour ordonner une liste de shiny dans une boite
     * @param boite la boite à trier
     * @return La liste ordonnée des pokemons shiny d'une boite
     */
    @Query("SELECT p FROM PokemonShiny p WHERE p.boite = :boite ORDER BY p.position ASC")
    List<PokemonShiny> findByBoitePosition(@Param("boite") String boite);

    /**
     * Requête pour comptabiliser le nombre de shiny par Ivs manquants
     * @return le total de shiny pour chaque stats Iv manquants différent
     */
    @Query("SELECT p.ivManquant AS ivManquant, COUNT(p) AS count " +
            "FROM PokemonShiny p " +
            "GROUP BY p.ivManquant " +
            "ORDER BY p.ivManquant")
    List<Object[]> getStatsIvManquant();

    /**
     * Requête pour afficher tous les shiny par régions
     * @param idRegion l'id de la région recherchée
     * @return la liste des pokemons d'une région
     */
    @Query("SELECT p FROM PokemonShiny p WHERE p.regionShiny.id = :idRegion")
    List<PokemonShiny> findByRegion(@Param("idRegion") Long idRegion);

}
