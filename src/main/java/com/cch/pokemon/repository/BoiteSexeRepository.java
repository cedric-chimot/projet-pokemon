package com.cch.pokemon.repository;

import com.cch.pokemon.entity.BoiteSexe;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Sexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoiteSexeRepository extends JpaRepository<BoiteSexe, Integer> {

  @Query("SELECT bs FROM BoiteSexe bs WHERE bs.boite = :boite AND bs.sexe = :sexe")
  BoiteSexe findByBoiteAndSexe(@Param("boite") Boites boite, @Param("sexe") Sexe sexe);

}
