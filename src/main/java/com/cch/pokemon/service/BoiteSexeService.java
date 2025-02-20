package com.cch.pokemon.service;

import com.cch.pokemon.entity.BoiteSexe;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Sexe;
import com.cch.pokemon.repository.BoiteSexeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Le service BoiteDresseur
 */
@Service
@Transactional
public class BoiteSexeService {

  /**
   * Le repository BoiteSexe
   */
  private final BoiteSexeRepository boiteSexeRepository;

  /**
   * Le constructeur
   * @param boiteSexeRepository le repository de la relation boites et sexes
   */
  public BoiteSexeService(BoiteSexeRepository boiteSexeRepository) {
    this.boiteSexeRepository = boiteSexeRepository;
  }

  /**
   * Méthode pour mettre à jour ou ajouter une liaison dans la table boite_sexe
   * @param sexe la sexe
   * @param boite la boite
   */
  public void updateBoiteSexe(Sexe sexe, Boites boite) {
    // Vérifier si la ligne existe déjà
    BoiteSexe boiteSexe = boiteSexeRepository.findByBoiteAndSexe(boite, sexe);
    if (boiteSexe != null) {
      // Incrémenter nbPokemon
      boiteSexe.setNbPokemon(boiteSexe.getNbPokemon() + 1);
      boiteSexeRepository.save(boiteSexe);
    } else {
      // Ajouter une nouvelle ligne
      BoiteSexe newBoiteSexe = new BoiteSexe();
      newBoiteSexe.setBoite(boite);
      newBoiteSexe.setSexe(sexe);
      newBoiteSexe.setNbPokemon(1);
      boiteSexeRepository.save(newBoiteSexe);
    }
  }

  public void decrementBoiteSexe(Sexe sexe, Boites boite) {
    BoiteSexe boiteSexe = boiteSexeRepository.findByBoiteAndSexe(boite, sexe);
    if (boiteSexe != null) {
      boiteSexe.setNbPokemon(boiteSexe.getNbPokemon() - 1);
      if (boiteSexe.getNbPokemon() <= 0) {
        boiteSexeRepository.delete(boiteSexe);
      } else {
        boiteSexeRepository.save(boiteSexe);
      }
    }
  }

}
