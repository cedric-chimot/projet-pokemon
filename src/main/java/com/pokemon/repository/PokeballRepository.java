package com.pokemon.repository;

import com.pokemon.entity.Pokeballs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeballRepository extends JpaRepository<Pokeballs, Long> {
}
