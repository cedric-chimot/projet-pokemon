package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Regions, Long> {
}
