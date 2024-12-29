package com.pokemon.service;

import com.pokemon.dto.TypeDTO;
import com.pokemon.entity.Types;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.TypeRepository;
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
     * Le constructeur
     * @param typeRepository Injection du repository
     */
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * Méthode pour créer un nouveau type
     * @param type le type à créer
     * @return le type nouvellement créée
     */
    public Types save(Types type) {
        return typeRepository.save(type);
    }

    /**
     * Méthode pour trouver tous les types
     * @return la liste de tous les types
     */
    public List<TypeDTO> findAllTypes() {
        return typeRepository.findAll()
                .stream().map(types -> {
                    TypeDTO dto = new TypeDTO();
                    dto.setId(types.getId());
                    dto.setNomType(types.getNomType());
                    dto.setNbShiny(types.getNbShiny());
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un type par son id
     * @param id l'id du type recherché
     * @return le type trouvé
     */
    public Optional<TypeDTO> findTypeById(Integer id) {
        return typeRepository.findById(id)
                .map(types -> {
                    TypeDTO dto = new TypeDTO();
                    dto.setId(types.getId());
                    dto.setNomType(types.getNomType());
                    dto.setNbShiny(types.getNbShiny());
                    return dto;
                });
    }

    /**
     * Mettre à jour un type
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Types update(Types shiny) {
        return typeRepository.save(shiny);
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
