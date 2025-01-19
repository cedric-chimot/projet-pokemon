package com.cch.pokemon.service;

import com.cch.pokemon.dto.TypeDTO;
import com.cch.pokemon.entity.Types;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.TypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service des types
 */
@Service
@Transactional
public class TypeService {

    /**
     * Le repository des types
     */
    private final TypeRepository typeRepository;

    /**
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur
     * @param typeRepository Injection du repository
     */
    public TypeService(TypeRepository typeRepository, ObjectMapper objectMapper) {
        this.typeRepository = typeRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Méthode pour créer un nouveau type
     * @param type le type à créer
     * @return le type nouvellement créé
     */
    public Types save(Types type) {
        return typeRepository.save(type);
    }

    /**
     * Méthode pour trouver tous les types
     * @return la liste de tous les types
     */

    public List<TypeDTO> findAllTypes() {
        List<Types> typeList = typeRepository.findAll();
        return typeList.stream()
                .map(type -> objectMapper.convertValue(type, TypeDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un type par son id (Générique)
     * @param id l'id du type recherché
     * @return le type trouvé
     */
    public Types findById(Integer id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Dresseur", "id", id));
    }

    /**
     * Méthode pour trouver un type par son id (DTO)
     * @param id l'id du type recherché
     * @return le type trouvé
     */
    public Optional<TypeDTO> findTypeById(Integer id) {
        return typeRepository.findById(id)
                .map(type-> objectMapper.convertValue(type, TypeDTO.class));
    }

    /**
     * Mettre à jour un type
     * @param type L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Types update(Types type) {
        Optional<Types> isTypeExist = typeRepository.findById(type.getId());

        if (isTypeExist.isPresent()) {
            Types existingType = isTypeExist.get();

            existingType.setNbShiny(type.getNbShiny());
            return typeRepository.save(existingType);
        } else {
            throw new CustomException("Le sexe est inconnu", "id", type.getId());
        }
    }

    /**
     * Méthode pour supprimer un type par son Id
     * @param id L'identifiant du type à supprimer
     * @return L'objet supprimé
     */
    public Types deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Types> optionalType = typeRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalType.isPresent()) {
            Types shiny = optionalType.get();
            typeRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Type", "id",  id);
        }
    }

    /**
     * Supprimer tous les types
     */
    public void deleteAll() {
        typeRepository.deleteAll();
    }

}
