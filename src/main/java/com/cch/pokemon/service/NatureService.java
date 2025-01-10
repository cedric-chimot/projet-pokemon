package com.cch.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cch.pokemon.dto.NatureDTO;
import com.cch.pokemon.dto.NatureReduitDTO;
import com.cch.pokemon.entity.Natures;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.NatureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service des natures
 */
@Service
@Transactional
public class NatureService {

    /**
     * Le repository des natures
     */
    private final NatureRepository natureRepository;

    /**
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur
     * @param natureRepository Injection du repository
     */
    public NatureService(NatureRepository natureRepository, ObjectMapper objectMapper) {
        this.natureRepository = natureRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Méthode pour créer une nouvelle nature
     * @param nature la nature à créer
     * @return la nature nouvellement créée
     */
    public Natures save(Natures nature) {
        return natureRepository.save(nature);
    }

    /**
     * Méthode pour trouver toutes les natures (complet)
     * @return la liste de toutes les natures
     */
    public List<NatureDTO> findAllNatures() {
        List<Natures> natureList = natureRepository.findAll();
        return natureList.stream()
                .map(nature -> objectMapper.convertValue(nature, NatureDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver toutes les natures (retourne le nom)
     * @return la liste des natures
     */
    public List<NatureReduitDTO> findAllNaturesByNom() {
        List<Natures> natureList = natureRepository.findAll();
        return natureList.stream()
                .map(pokeball -> objectMapper.convertValue(pokeball, NatureReduitDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver une nature par son id (retourne l'entité complète)
     * @param id l'id de la nature recherchée
     * @return la nature trouvée
     */
    public Natures findById(Integer id) {
        return natureRepository.findById(id)
                .orElseThrow(() -> new CustomException("Nature", "id", id)); // Renvoie l'entité
    }

    /**
     * Méthode pour trouver une nature par son id
     * @param id l'id de la nature recherchée
     * @return la nature trouvée
     */
    public NatureReduitDTO findNatureById(Integer id) {
        Optional<Natures> nature = natureRepository.findById(id);
        return objectMapper.convertValue(nature, NatureReduitDTO.class);
    }

    /**
     * Mettre à jour une nature
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Natures update(Natures shiny) {
        return natureRepository.save(shiny);
    }

    /**
     * Méthode pour supprimer une nature par son Id
     * @param id L'identifiant de la nature à supprimer
     * @return L'objet supprimé
     */
    public Natures deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Natures> optionalNature = natureRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalNature.isPresent()) {
            Natures shiny = optionalNature.get();
            natureRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Nature", "id",  id);
        }
    }

    /**
     * Supprimer toutes les natures
     */
    public void deleteAll() {
        natureRepository.deleteAll();
    }

}
