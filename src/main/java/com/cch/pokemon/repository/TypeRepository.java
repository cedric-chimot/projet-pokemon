package com.cch.pokemon.repository;

import com.cch.pokemon.entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Types, Integer> {
}
