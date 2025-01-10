package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Pokeballs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokeballRepository extends JpaRepository<Pokeballs, Integer> {

    /**
     * Trouver la liste des pokeballs dont le nombre de pokemon est supérieur à 0
     * @return La liste des pokeballs ayant 1 ou plusieurs pokemon
     */
    @Query("SELECT p FROM Pokeballs p WHERE nbPokemon > 0")
    List<Pokeballs> findAllPokeballs();

}
