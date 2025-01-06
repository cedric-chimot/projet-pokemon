package com.pokemon.repository;

import com.pokemon.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Regions, Long> {
}
