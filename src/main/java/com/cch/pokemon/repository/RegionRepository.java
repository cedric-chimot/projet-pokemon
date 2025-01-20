package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegionRepository extends JpaRepository<Regions, Long> {

    /**
     * Requête pour compter le nombre total de régions
     * @return le nombre total de régions
     */
    @Query("SELECT COUNT(r) FROM Regions r")
    Long countRegions();

}
