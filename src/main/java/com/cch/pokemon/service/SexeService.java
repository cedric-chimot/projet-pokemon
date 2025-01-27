package com.cch.pokemon.service;

import com.cch.pokemon.dto.SexeDTO;
import com.cch.pokemon.entity.Sexe;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.SexeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur
     * @param sexeRepository Injection du repository
     */
    public SexeService(SexeRepository sexeRepository, ObjectMapper objectMapper) {
        this.sexeRepository = sexeRepository;
        this.objectMapper = objectMapper;
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
     * Méthode pour trouver tous les sexes (complets)
     * @return la liste des sexes
     */
    public List<Sexe> findAll() {
        return sexeRepository.findAll();
    }

    /**
     * Méthode pour trouver tous les sexes (DTO)
     * @return la liste de tous les sexes
     */
    public List<SexeDTO> findAllSexes() {
        List<Sexe> sexeList = sexeRepository.findAll();
        return sexeList.stream()
                .map(sexe -> objectMapper.convertValue(sexe, SexeDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un sexe par son id (générique)
     * @param id l'id de la  sexe recherché
     * @return le sexe trouvé
     */
    public Sexe findById(Integer id) {
        return sexeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Dresseur", "id", id));
    }

    /**
     * Méthode pour trouver un sexe par son id (DTO)
     * @param id l'id de la  sexe recherché
     * @return le sexe trouvé
     */
    public Optional<SexeDTO> findSexeById(Integer id) {
        return sexeRepository.findById(id)
                .map(sexe -> objectMapper.convertValue(sexe, SexeDTO.class));
    }

    /**
     * Mettre à jour un sexe
     * @param sexe L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Sexe update(Sexe sexe) {
        Optional<Sexe> isSexeExist = sexeRepository.findById(sexe.getId());

        if (isSexeExist.isPresent()) {
            Sexe existingSexe = isSexeExist.get();

            existingSexe.setNbTotal(sexe.getNbTotal());
            existingSexe.setNbShiny(sexe.getNbShiny());
            return sexeRepository.save(existingSexe);
        } else {
            throw new CustomException("Le sexe est inconnu", "id", sexe.getId());
        }
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
