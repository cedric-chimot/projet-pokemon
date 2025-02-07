package com.cch.pokemon.service;

import com.cch.pokemon.entity.BoiteDresseur;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Dresseurs;
import com.cch.pokemon.repository.BoiteDresseurRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Le service BoiteDresseur
 */
@Service
@Transactional
public class BoiteDresseurService {

  /**
   * Le repository BoiteDresseur
   */
  private final BoiteDresseurRepository boiteDresseurRepository;

  /**
   * Le constructeur
   * @param boiteDresseurRepository le repository de la relation boites et dresseurs
   */
  public BoiteDresseurService(BoiteDresseurRepository boiteDresseurRepository) {
    this.boiteDresseurRepository = boiteDresseurRepository;
  }

  /**
   * Méthode pour mettre à jour ou ajouter une liaison dans la table boite_dresseur
   * @param dresseur le dresseur
   * @param boite la boite
   */
  public void updateBoiteDresseur(Dresseurs dresseur, Boites boite) {
    // Vérifier si la ligne existe déjà
    BoiteDresseur boiteDresseur = boiteDresseurRepository.findByBoiteAndDresseur(boite, dresseur);
    if (boiteDresseur != null) {
      // Incrémenter nbPokemon
      boiteDresseur.setNbPokemon(boiteDresseur.getNbPokemon() + 1);
      boiteDresseurRepository.save(boiteDresseur);
    } else {
      // Ajouter une nouvelle ligne
      BoiteDresseur newBoiteDresseur = new BoiteDresseur();
      newBoiteDresseur.setBoite(boite);
      newBoiteDresseur.setDresseur(dresseur);
      newBoiteDresseur.setNbPokemon(1);
      boiteDresseurRepository.save(newBoiteDresseur);
    }
  }

}
