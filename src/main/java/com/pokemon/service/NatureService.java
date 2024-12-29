package com.pokemon.service;

import com.pokemon.dto.NatureDTO;
import com.pokemon.entity.Natures;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.NatureRepository;
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
     * Le constructeur
     * @param natureRepository Injection du repository
     */
    public NatureService(NatureRepository natureRepository) {
        this.natureRepository = natureRepository;
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
     * Méthode pour trouver toutes les natures
     * @return la liste de toutes les natures
     */
    public List<NatureDTO> findAllNatures() {
        return natureRepository.findAll()
                .stream().map(natures -> {
                    NatureDTO dto = new NatureDTO();
                    dto.setId(natures.getId());
                    dto.setNomNature(natures.getNomNature());
                    dto.setNbPokemon(natures.getNbPokemon());
                    dto.setNbShiny(natures.getNbShiny());
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver une nature par son id
     * @param id l'id de la nature recherchée
     * @return la nature trouvée
     */
    public Optional<NatureDTO> findNatureById(Integer id) {
        return natureRepository.findById(id)
                .map(natures -> {
                    NatureDTO dto = new NatureDTO();
                    dto.setId(natures.getId());
                    dto.setNomNature(natures.getNomNature());
                    dto.setNbPokemon(natures.getNbPokemon());
                    dto.setNbShiny(natures.getNbShiny());
                    return dto;
                });
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
