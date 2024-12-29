package com.pokemon.service;

import com.pokemon.dto.SexeDTO;
import com.pokemon.entity.Sexe;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.SexeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service des sexes
 */
@Service
@Transactional
public class SexeService {

    /**
     * Le repository des sexes
     */
    private final SexeRepository sexeRepository;

    /**
     * Le constructeur
     * @param sexeRepository Injection du repository
     */
    public SexeService(SexeRepository sexeRepository) {
        this.sexeRepository = sexeRepository;
    }

    /**
     * Méthode pour créer un nouveau sexe
     * @param sexe le sexe à créer
     * @return le sexe nouvellement créé
     */
    public Sexe save(Sexe sexe) {
        return sexeRepository.save(sexe);
    }

    /**
     * Méthode pour trouver tous les sexes
     * @return la liste de tous les sexes
     */
    public List<SexeDTO> findAllSexes() {
        return sexeRepository.findAll()
                .stream().map(sexes -> {
                    SexeDTO dto = new SexeDTO();
                    dto.setId(sexes.getId());
                    dto.setSexe(sexes.getSexe());
                    dto.setNbPokemon(sexes.getNbTotal());
                    dto.setNbShiny(sexes.getNbShiny());
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un sexe par son id
     * @param id l'id du sexe recherché
     * @return le sexe trouvé
     */
    public Optional<SexeDTO> findSexeById(Integer id) {
        return sexeRepository.findById(id)
                .map(sexes -> {
                    SexeDTO dto = new SexeDTO();
                    dto.setId(sexes.getId());
                    dto.setSexe(sexes.getSexe());
                    dto.setNbPokemon(sexes.getNbTotal());
                    dto.setNbShiny(sexes.getNbShiny());
                    return dto;
                });
    }

    /**
     * Mettre à jour un sexe
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Sexe update(Sexe shiny) {
        return sexeRepository.save(shiny);
    }

    /**
     * Méthode pour supprimer un sexe par son Id
     * @param id L'identifiant de la sexe à supprimer
     * @return L'objet supprimé
     */
    public Sexe deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Sexe> optionalSexe = sexeRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalSexe.isPresent()) {
            Sexe shiny = optionalSexe.get();
            sexeRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Sexe", "id",  id);
        }
    }

    /**
     * Supprimer tous les sexes
     */
    public void deleteAll() {
        sexeRepository.deleteAll();
    }

}
