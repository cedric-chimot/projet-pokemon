package com.cch.pokemon.repository;

import com.cch.pokemon.entity.BoiteNature;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Natures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoiteNatureRepository extends JpaRepository<BoiteNature, Integer> {

  @Query("SELECT bn FROM BoiteNature bn WHERE bn.boite = :boite AND bn.nature = :nature")
  BoiteNature findByBoiteAndNature(@Param("boite") Boites boite, @Param("nature") Natures nature);

}
