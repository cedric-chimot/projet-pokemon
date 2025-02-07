package com.cch.pokemon.repository;

import com.cch.pokemon.entity.BoitePokeball;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Pokeballs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoitePokeballRepository extends JpaRepository<BoitePokeball, Integer> {

  @Query("SELECT bp FROM BoitePokeball bp WHERE bp.boite = :boite AND bp.pokeball = :pokeball")
  BoitePokeball findByBoiteAndPokeball(@Param("boite") Boites boite, @Param("pokeball") Pokeballs pokeball);

}
