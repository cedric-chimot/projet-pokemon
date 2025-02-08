package com.cch.pokemon.repository;

import com.cch.pokemon.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoiteTypeRepository extends JpaRepository<BoiteType, Integer> {

  @Query("SELECT bt FROM BoiteType bt WHERE bt.boite = :boite AND bt.type = :type")
  BoiteType findByBoiteAndType(@Param("boite") Boites boite, @Param("type") Types type);

}
