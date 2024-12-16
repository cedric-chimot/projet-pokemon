package com.pokemon.repository;

import com.pokemon.entity.Natures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NatureRepository extends JpaRepository<Natures, Long> {
}
