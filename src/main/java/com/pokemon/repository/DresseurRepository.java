package com.pokemon.repository;

import com.pokemon.entity.Dresseurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DresseurRepository extends JpaRepository<Dresseurs, Long> {
}
