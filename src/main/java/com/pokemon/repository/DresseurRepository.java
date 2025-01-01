package com.pokemon.repository;

import com.pokemon.entity.Dresseurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DresseurRepository extends JpaRepository<Dresseurs, Integer> {

    /**
     * Requête pour exclure les dresseurs dont l'id est compris entre 119 et 141
     * @return la liste des dresseurs filtrée
     */
    @Query("SELECT d FROM Dresseurs d WHERE d.id < 119 OR d.id > 141")
    List<Dresseurs> findAllDresseursExceptRange();

}
