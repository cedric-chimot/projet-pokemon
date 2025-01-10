package com.cch.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cch.pokemon.dto.BoitePokedexDTO;
import com.cch.pokemon.dto.BoitePokedexReduitDTO;
import com.cch.pokemon.entity.BoitePokedexNational;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.BoitePokedexNationalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service des boitePokedexNationals
 */
@Service
@Transactional
public class BoitePokedexNationalService {

    /**
     * Le repository des boitePokedexNationals
     */
    private final BoitePokedexNationalRepository boitePokedexRepository;

    /**
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur
     * @param boitePokedexRepository Injection du repository
     * @param objectMapper Injection du mapping d'objet
     */
    public BoitePokedexNationalService(BoitePokedexNationalRepository boitePokedexRepository, ObjectMapper objectMapper) {
        this.boitePokedexRepository = boitePokedexRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Méthode pour créer une nouvelle boite
     * @param boitePokedex la boite à créer
     * @return la boite nouvellement créée
     */
    public BoitePokedexNational save(BoitePokedexNational boitePokedex) {
        return boitePokedexRepository.save(boitePokedex);
    }

    /**
     * Méthode pour trouver toutes les boites
     * @return la liste de toutes les boites
     */
    public List<BoitePokedexDTO> findAllBoitePokedex() {
        List<BoitePokedexNational> boitePokedexNationalList = boitePokedexRepository.findAll();
        return boitePokedexNationalList.stream()
                .map(boitePokedex -> objectMapper.convertValue(boitePokedex, BoitePokedexDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver une boite du pokedex par son id (retourne l'entité complète)
     * @param id l'id de la boite du pokedex recherchée
     * @return la boite du pokedex trouvée
     */
    public BoitePokedexNational findById(Long id) {
        return boitePokedexRepository.findById(id)
                .orElseThrow(() -> new CustomException("Boite", "id", id)); // Renvoie l'entité
    }

    /**
     * Méthode pour trouver une boite du pokedex national par son id
     * @param id l'id de la boite du pokedex national recherché
     * @return la boite du pokedex national trouvé
     */
    public BoitePokedexReduitDTO findBoitePokedexById(Long id) {
        Optional<BoitePokedexNational> boitePokedex = boitePokedexRepository.findById(id);
        return objectMapper.convertValue(boitePokedex, BoitePokedexReduitDTO.class);
    }

    /**
     * Mettre à jour un boitePokedexNational
     * @param boite L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public BoitePokedexNational update(BoitePokedexNational boite) {
        Optional<BoitePokedexNational> existingBoitePokedex = boitePokedexRepository.findById(boite.getId());

        if (existingBoitePokedex.isPresent()) {
            BoitePokedexNational existingBoite = existingBoitePokedex.get();

            existingBoite.setNomBoite(boite.getNomBoite());
            existingBoite.setNbMales(boite.getNbMales());
            existingBoite.setNbFemelles(boite.getNbFemelles());
            existingBoite.setNbAssexues(boite.getNbAssexues());
            existingBoite.setNbLevel100(boite.getNbLevel100());

            return boitePokedexRepository.save(existingBoite);
        } else {
            throw new CustomException("La boite pokedex n'existe pas", "id", boite.getId());
        }
    }

    /**
     * Méthode pour supprimer un boitePokedexNational par son Id
     * @param id L'identifiant du boitePokedexNational à supprimer
     * @return L'objet supprimé
     */
    public BoitePokedexNational deleteById(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<BoitePokedexNational> optionalBoitePokedex = boitePokedexRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalBoitePokedex.isPresent()) {
            BoitePokedexNational boite = optionalBoitePokedex.get();
            boitePokedexRepository.delete(boite); // Supprimer l'objet
            return boite; // Retourner l'objet supprimé
        } else {
            throw new CustomException("La boite pokedex n'existe pas", "id",  id);
        }
    }

    /**
     * Supprimer tous les boitePokedexNationals
     */
    public void deleteAll() {
        boitePokedexRepository.deleteAll();
    }

}
