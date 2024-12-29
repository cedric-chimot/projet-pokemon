package com.pokemon.service;

import com.pokemon.dto.DresseurDTO;
import com.pokemon.entity.Dresseurs;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.DresseurRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service des dresseurs
 */
@Service
@Transactional
public class DresseurService {

    /**
     * Le repository des dresseurs
     */
    private final DresseurRepository dresseurRepository;

    /**
     * Le constructeur
     * @param dresseurRepository Injection du repository
     */
    public DresseurService(DresseurRepository dresseurRepository) {
        this.dresseurRepository = dresseurRepository;
    }

    /**
     * Méthode pour créer un nouveau dresseur
     * @param dresseur le dresseur à créer
     * @return le dresseur nouvellement créé
     */
    public Dresseurs save(Dresseurs dresseur) {
        return dresseurRepository.save(dresseur);
    }

    /**
     * Méthode pour trouver tous les dresseurs
     * @return la liste de tous les dresseurs
     */
    public List<DresseurDTO> findAllDresseurs() {
        return dresseurRepository.findAll()
                .stream().map(dresseurs -> {
                    DresseurDTO dto = new DresseurDTO();
                    dto.setId(dresseurs.getId());
                    dto.setIdDresseur(dresseurs.getIdDresseur());
                    dto.setNomDresseur(dresseurs.getNomDresseur());
                    dto.setNb_pokemon(dresseurs.getNbPokemon());
                    dto.setNb_shiny(dresseurs.getNbShiny());
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un dresseur par son id
     * @param id l'id du dresseur recherché
     * @return le dresseur trouvé
     */
    public Optional<DresseurDTO> findDresseurById(Integer id) {
        return dresseurRepository.findById(id)
                .map(dresseurs -> {
                    DresseurDTO dto = new DresseurDTO();
                    dto.setId(dresseurs.getId());
                    dto.setIdDresseur(dresseurs.getIdDresseur());
                    dto.setNomDresseur(dresseurs.getNomDresseur());
                    dto.setNb_pokemon(dresseurs.getNbPokemon());
                    dto.setNb_shiny(dresseurs.getNbShiny());
                    return dto;
                });
    }

    /**
     * Mettre à jour un dresseur
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Dresseurs update(Dresseurs shiny) {
        return dresseurRepository.save(shiny);
    }

    /**
     * Méthode pour supprimer un dresseur par son Id
     * @param id L'identifiant du dresseur à supprimer
     * @return L'objet supprimé
     */
    public Dresseurs deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Dresseurs> optionalDresseur = dresseurRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalDresseur.isPresent()) {
            Dresseurs shiny = optionalDresseur.get();
            dresseurRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Dresseur", "id",  id);
        }
    }

    /**
     * Supprimer tous les dresseurs
     */
    public void deleteAll() {
        dresseurRepository.deleteAll();
    }

}
