package com.cch.pokemon.service;

import com.cch.pokemon.entity.Regions;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.RegionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Le service des regions
 */
@Service
@Transactional
public class RegionsService {

    /**
     * Le repository des regions
     */
    private final RegionRepository regionRepository;

    /**
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur
     * @param regionRepository Injection du repository
     */
    public RegionsService(RegionRepository regionRepository, ObjectMapper objectMapper) {
        this.regionRepository = regionRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Méthode pour créer un nouveau region
     * @param region le region à créer
     * @return le region nouvellement créé
     */
    public Regions save(Regions region) {
        return regionRepository.save(region);
    }

    /**
     * Méthode pour trouver tous les regions
     * @return la liste de tous les regions
     */
    public List<Regions> findAllRegions() {
        return regionRepository.findAll();
    }

    /**
     * Méthode pour trouver un region par son id
     * @param id l'id de la region recherché
     * @return le region trouvé
     */
    public Regions findById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Region", "id", id)); // Renvoie l'entité
    }

    /**
     * Méthode pour retrouver le nombre total de régions
     * @return le nombre de régions
     */
    public Long findRegionCount() {
        return regionRepository.countRegions();
    }

    /**
     * Mettre à jour une region
     * @param region L'objet à mettre à jour
     * @return L'objet mis à jour
     */

    public Regions update(Regions region) {
        Optional<Regions> isRegionExist = regionRepository.findById(region.getId());

        if (isRegionExist.isPresent()) {
            Regions existingRegion = isRegionExist.get();

            existingRegion.setNomRegion(region.getNomRegion());
            return regionRepository.save(existingRegion);
        } else {
            throw new CustomException("La région est inconnue", "id", region.getId());
        }
    }

    /**
     * Méthode pour supprimer un region par son Id
     * @param id L'identifiant de la region à supprimer
     * @return L'objet supprimé
     */
    public Regions deleteById(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<Regions> optionalRegions = regionRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalRegions.isPresent()) {
            Regions region = optionalRegions.get();
            regionRepository.delete(region); // Supprimer l'objet
            return region; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Regions", "id",  id);
        }
    }

    /**
     * Supprimer tous les regions
     */
    public void deleteAll() {
        regionRepository.deleteAll();
    }

}
