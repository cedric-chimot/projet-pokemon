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

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Kanto' AND p.id BETWEEN 1 AND 151")
    List<PokedexNational> findByKanto();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Johto' AND p.id BETWEEN 152 AND 251")
    List<PokedexNational> findByJohto();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Hoenn' AND p.id BETWEEN 252 AND 386")
    List<PokedexNational> findByHoenn();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Sinnoh' AND p.id BETWEEN 387 AND 493")
    List<PokedexNational> findBySinnoh();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Unys' AND p.id BETWEEN 494 AND 649")
    List<PokedexNational> findByUnys();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Kalos' AND p.id BETWEEN 650 AND 722")
    List<PokedexNational> findByKalos();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Alola' AND p.id BETWEEN 723 AND 815")
    List<PokedexNational> findByAlola();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Galar' AND p.id BETWEEN 816 AND 905")
    List<PokedexNational> findByGalar();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Hisui' AND p.id BETWEEN 906 AND 912")
    List<PokedexNational> findByHisui();

    @Query("SELECT p FROM PokedexNational p WHERE p.region = 'Paldea' AND p.id BETWEEN 913 AND 1032")
    List<PokedexNational> findByPaldea();

}
