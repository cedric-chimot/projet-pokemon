package com.pokemon.service;

import com.pokemon.entity.Boites;
import com.pokemon.repository.BoitesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoiteService {
    private final BoitesRepository boitesRepository;

    public BoiteService(BoitesRepository boitesRepository) {
        this.boitesRepository = boitesRepository;
    }

    public Boites save(Boites boite) {
        return boitesRepository.save(boite);
    }
    
    public List<Boites> getAllBoites() {
        return boitesRepository.findAll();
    }
    
    public Optional<Boites> getBoiteById(Integer id) {
        return boitesRepository.findById(id);
    }

    /**
     * Mettre à jour une boite
     * @param boite L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Boites update(Boites boite) {
        return boitesRepository.save(boite);
    }

    /**
     * Méthode pour supprimer une boite par son Id
     * @param id L'identifiant d'une boite à supprimer
     * @return L'objet supprimé
     */
    public Boites deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Boites> optionalboite = boitesRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalboite.isPresent()) {
            Boites boite = optionalboite.get();
            boitesRepository.delete(boite); // Supprimer l'objet
            return boite; // Retourner l'objet supprimé
        } else {
            throw new EntityNotFoundException("Boites with id " + id + " not found");
        }
    }

    /**
     * Supprimer tous les boites
     */
    public void deleteAll() {
        boitesRepository.deleteAll();
    }


}
