package com.cch.pokemon.service;

import com.cch.pokemon.entity.BoiteType;
import com.cch.pokemon.entity.Boites;
import com.cch.pokemon.entity.Types;
import com.cch.pokemon.repository.BoiteTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Le service BoiteType
 */
@Service
@Transactional
public class BoiteTypeService {

  /**
   * Le repository BoiteType
   */
  private final BoiteTypeRepository boiteTypeRepository;

  /**
   * Le constructeur
   * @param boiteTypeRepository le repository de la relation boites et types
   */
  public BoiteTypeService(BoiteTypeRepository boiteTypeRepository) {
    this.boiteTypeRepository = boiteTypeRepository;
  }

  /**
   * Méthode pour mettre à jour ou ajouter une liaison dans la table boite_type
   * @param type le type
   * @param boite la boite
   */
  public void updateBoiteType(Types type, Boites boite) {
    if (boite.getId() == 7 || boite.getId() == 8 || boite.getId() == 9) {
      return;
    }
    // Vérifier si la ligne existe déjà
    BoiteType boiteType = boiteTypeRepository.findByBoiteAndType(boite, type);
    if (boiteType != null) {
      // Incrémenter nbPokemon
      boiteType.setNbPokemon(boiteType.getNbPokemon() + 1);
      boiteTypeRepository.save(boiteType);
    } else {
      // Ajouter une nouvelle ligne
      BoiteType newBoiteType = new BoiteType();
      newBoiteType.setBoite(boite);
      newBoiteType.setType(type);
      newBoiteType.setNbPokemon(1);
      boiteTypeRepository.save(newBoiteType);
    }
  }

}
