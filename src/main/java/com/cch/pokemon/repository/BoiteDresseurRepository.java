package com.cch.pokemon.repository;

import com.cch.pokemon.entity.BoiteDresseur;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Dresseurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoiteDresseurRepository extends JpaRepository<BoiteDresseur, Integer> {

  @Query("SELECT bd FROM BoiteDresseur bd WHERE bd.boite = :boite AND bd.dresseur = :dresseur")
  BoiteDresseur findByBoiteAndDresseur(@Param("boite") Boites boite, @Param("dresseur") Dresseurs dresseur);

}
