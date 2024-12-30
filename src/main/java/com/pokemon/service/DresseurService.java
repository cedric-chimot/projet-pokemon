package com.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.dto.DresseurReduitDTO;
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
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;


    /**
     * Le constructeur
     * @param dresseurRepository Injection du repository
     */
    public DresseurService(DresseurRepository dresseurRepository, ObjectMapper objectMapper) {
        this.dresseurRepository = dresseurRepository;
        this.objectMapper = objectMapper;
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
    public List<DresseurReduitDTO> findAllDresseurs() {
        List<Dresseurs> dresseurList = dresseurRepository.findAll();
        return dresseurList.stream()
                .map(dresseur -> objectMapper.convertValue(dresseur, DresseurReduitDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un dresseur par son id (retourne l'entité complète)
     * @param id l'id du dresseur recherché
     * @return le dresseur trouvé
     */
    public Dresseurs findById(Integer id) {
        return dresseurRepository.findById(id)
                .orElseThrow(() -> new CustomException("Dresseur", "id", id)); // Renvoie l'entité
    }

    /**
     * Méthode pour trouver un dresseur par son id
     * @param id l'id du dresseur recherché
     * @return le dresseur trouvé
     */
    public DresseurReduitDTO findDresseurById(Integer id) {
        Dresseurs dresseur = dresseurRepository.findById(id)
                .orElseThrow(() -> new CustomException("Dresseur", "id", id)); // Gère l'absence de dresseur
        return objectMapper.convertValue(dresseur, DresseurReduitDTO.class); // Convertit l'entité en DTO
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
