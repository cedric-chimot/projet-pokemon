package com.pokemon.repository;

import com.pokemon.entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Types, Long> {
}
