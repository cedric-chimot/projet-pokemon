package com.cch.pokemon.service;

import com.cch.pokemon.entity.RegionDresseur;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.RegionDresseurRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Le service des regionDresseurs
 */
@Service
@Transactional
public class RegionDresseurService {

    /**
     * Le repository des regionDresseurs
     */
    private final RegionDresseurRepository regionDresseurRepository;

    /**
     * Le constructeur
     * @param regionDresseurRepository Injection du repository
     */
    public RegionDresseurService(RegionDresseurRepository regionDresseurRepository) {
        this.regionDresseurRepository = regionDresseurRepository;
    }

    /**
     * Méthode pour créer une nouvelle regionDresseur
     * @param regionDresseur la regionDresseur à créer
     * @return la regionDresseur nouvellement créée
     */
    public RegionDresseur save(RegionDresseur regionDresseur) {
        return regionDresseurRepository.save(regionDresseur);
    }

    /**
     * Méthode pour trouver toutes les regionDresseurs
     * @return la liste de toutes les regionDresseurs
     */
    public List<RegionDresseur> findAllRegionDresseurs() {
        return regionDresseurRepository.findAll();
    }


    /**
     * Méthode pour trouver une regionDresseur par son id (retourne l'entité complète)
     * @param id l'id de la regionDresseur recherché
     * @return la regionDresseur trouvée
     */
    public RegionDresseur findById(Long id) {
        return regionDresseurRepository.findById(id)
                .orElseThrow(() -> new CustomException("RegionDresseur", "id", id));
    }

    /**
     * Mettre à jour une regionDresseur
     * @param regionDresseur L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public RegionDresseur update(RegionDresseur regionDresseur) {
        Optional<RegionDresseur> existingInTable = regionDresseurRepository.findById(regionDresseur.getIdRegionDresseur());

        if (existingInTable.isPresent()) {
            RegionDresseur existingRegionDresseur = existingInTable.get();
            existingRegionDresseur.setNomRegionDresseur(regionDresseur.getNomRegionDresseur());
            return regionDresseurRepository.save(existingRegionDresseur);
        } else {
            throw new CustomException("La région dresseur n'existe pas", "id", regionDresseur.getIdRegionDresseur());
        }
    }

    /**
     * Méthode pour supprimer une regionDresseur par son Id
     * @param id L'identifiant de la regionDresseur à supprimer
     * @return L'objet supprimé
     */
    public RegionDresseur deleteById(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<RegionDresseur> optionalRegionDresseur = regionDresseurRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalRegionDresseur.isPresent()) {
            RegionDresseur shiny = optionalRegionDresseur.get();
            regionDresseurRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("RegionDresseur", "id",  id);
        }
    }

    /**
     * Supprimer toutes les regionDresseurs
     */
    public void deleteAll() {
        regionDresseurRepository.deleteAll();
    }

}
