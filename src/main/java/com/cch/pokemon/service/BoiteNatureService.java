package com.cch.pokemon.service;

import com.cch.pokemon.entity.BoiteNature;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Natures;
import com.cch.pokemon.repository.BoiteNatureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Le service BoiteNature
 */
@Service
@Transactional
public class BoiteNatureService {

  /**
   * Le repository BoiteNature
   */
  private final BoiteNatureRepository boiteNatureRepository;

  /**
   * Le constructeur
   * @param boiteNatureRepository le repository de la relation boites et natures
   */
  public BoiteNatureService(BoiteNatureRepository boiteNatureRepository) {
    this.boiteNatureRepository = boiteNatureRepository;
  }

  /**
   * Méthode pour mettre à jour ou ajouter une liaison dans la table boite_nature
   * @param nature la nature
   * @param boite la boite
   */
  public void updateBoiteNature(Natures nature, Boites boite) {
    if (boite.getId() == 7 || boite.getId() == 8 || boite.getId() == 9) {
      return;
    }

    // Vérifier si la ligne existe déjà
    BoiteNature boiteNature = boiteNatureRepository.findByBoiteAndNature(boite, nature);
    if (boiteNature != null) {
      // Incrémenter nbPokemon
      boiteNature.setNbPokemon(boiteNature.getNbPokemon() + 1);
      boiteNatureRepository.save(boiteNature);
    } else {
      // Ajouter une nouvelle ligne
      BoiteNature newBoiteNature = new BoiteNature();
      newBoiteNature.setBoite(boite);
      newBoiteNature.setNature(nature);
      newBoiteNature.setNbPokemon(1);
      boiteNatureRepository.save(newBoiteNature);
    }
  }

  public void decrementBoiteNature(Natures nature, Boites boite) {
    BoiteNature boiteNature = boiteNatureRepository.findByBoiteAndNature(boite, nature);
    if (boiteNature != null) {
      boiteNature.setNbPokemon(boiteNature.getNbPokemon() - 1);
      if (boiteNature.getNbPokemon() <= 0) {
        boiteNatureRepository.delete(boiteNature);
      } else {
        boiteNatureRepository.save(boiteNature);
      }
    }
  }

}
