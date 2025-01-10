package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Natures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureRepository extends JpaRepository<Natures, Integer> {
}
