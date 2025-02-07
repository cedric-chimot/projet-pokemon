package com.cch.pokemon.service;

import com.cch.pokemon.entity.BoitePokeball;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Pokeballs;
import com.cch.pokemon.repository.BoitePokeballRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Le service BoitePokeball
 */
@Service
@Transactional
public class BoitePokeballService {

  /**
   * Le repository BoitePokeball
   */
  private final BoitePokeballRepository boitePokeballRepository;

  /**
   * Le constructeur
   * @param boitePokeballRepository le repository de la relation boites et pokeballs
   */
  public BoitePokeballService(BoitePokeballRepository boitePokeballRepository) {
    this.boitePokeballRepository = boitePokeballRepository;
  }

  /**
   * Méthode pour mettre à jour ou ajouter une liaison dans la table boite_pokeball
   * @param pokeball la pokeball
   * @param boite la boite
   */
  public void updateBoitePokeball(Pokeballs pokeball, Boites boite) {
    // Vérifier si la ligne existe déjà
    BoitePokeball boitePokeball = boitePokeballRepository.findByBoiteAndPokeball(boite, pokeball);
    if (boitePokeball != null) {
      // Incrémenter nbPokemon
      boitePokeball.setNbPokemon(boitePokeball.getNbPokemon() + 1);
      boitePokeballRepository.save(boitePokeball);
    } else {
      // Ajouter une nouvelle ligne
      BoitePokeball newBoitePokeball = new BoitePokeball();
      newBoitePokeball.setBoite(boite);
      newBoitePokeball.setPokeball(pokeball);
      newBoitePokeball.setNbPokemon(1);
      boitePokeballRepository.save(newBoitePokeball);
    }
  }

}
