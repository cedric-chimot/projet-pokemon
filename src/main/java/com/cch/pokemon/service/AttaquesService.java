package com.cch.pokemon.service;

import com.cch.pokemon.entity.Attaques;
import com.cch.pokemon.entity.Types;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.AttaquesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Le service des attaques
 */
@Service
@Transactional
public class AttaquesService {

    /**
     * Le repository des attaques
     */
    private final AttaquesRepository attaqueRepository;


    /**
     * Le service des types
     */
    private final TypeService typeService;

    /**
     * Le constructeur
     * @param attaqueRepository Injection du repository
     */
    public AttaquesService(AttaquesRepository attaqueRepository, TypeService typeService) {
        this.attaqueRepository = attaqueRepository;
        this.typeService = typeService;
    }


    public Attaques save(String nomAttaque, Integer idType) {
        Types type = typeService.findById(idType);

        Attaques attaque = new Attaques(nomAttaque, type);

        return attaqueRepository.save(attaque);
    }

    /**
     * Méthode pour trouver toutes les attaques
     * @return la liste des attaques
     */
    public List<Attaques> findAll() {
        return attaqueRepository.findAll();
    }

    /**
     * Méthode pour trouver une attaque par son id (retourne l'entité complète)
     * @param id l'id de l'attaque recherchée
     * @return l'attaque trouvée
     */
    public Attaques findById(Long id) {
        return attaqueRepository.findById(id)
                .orElseThrow(() -> new CustomException("Attaques", "id", id)); // Renvoie l'entité
    }

    /**
     * Méthode pour trouver la liste des attaques pour un type donné
     * @param typeId l'id du type
     * @return la liste des attaques
     */
    public List<Attaques> findAttaquesByType(Integer typeId) {
        return attaqueRepository.findByType(typeId);
    }

    /**
     * Méthode pour retrouver le nombre total d'attaques
     * @return le nombre de attaques
     */
    public Long findAttaquesCount() {
        return attaqueRepository.countAttaques();
    }

    /**
     * Mettre à jour une attaque
     * @param attaque L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Attaques updateAttaque(Attaques attaque) {
        Optional<Attaques> isAttaqueExist= attaqueRepository.findById(attaque.getId());

        if (isAttaqueExist.isPresent()) {
            Attaques existingAttaque = isAttaqueExist.get();

            existingAttaque.setNomAttaque(attaque.getNomAttaque());
            existingAttaque.setTypeAttaque(attaque.getTypeAttaque());
            return attaqueRepository.save(existingAttaque);
        } else {
            throw new CustomException("L'attaque n'existe pas", "id", attaque.getId());
        }
    }

    /**
     * Méthode pour supprimer une attaque par son Id
     * @param id L'identifiant de l'attaque à supprimer
     * @return L'objet supprimé
     */
    public Attaques deleteById(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<Attaques> optionalAttaques = attaqueRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalAttaques.isPresent()) {
            Attaques shiny = optionalAttaques.get();
            attaqueRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Attaques", "id",  id);
        }
    }

    /**
     * Supprimer toutes les attaques
     */
    public void deleteAll() {
        attaqueRepository.deleteAll();
    }

}
