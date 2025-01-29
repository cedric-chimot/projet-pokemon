package com.cch.pokemon.service;

import com.cch.pokemon.entity.Attaques;
import com.cch.pokemon.entity.PokemonShiny;
import com.cch.pokemon.entity.ShinyAttaques;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.ShinyAttaquesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShinyAttaquesService {

    /**
     * Le répository à injecter
     */
    private ShinyAttaquesRepository shinyAttaquesRepository;

    /**
     * Les services associés
     */
    private final AttaquesService attaqueService;
    private final PokemonShinyService shinyService;

    public ShinyAttaquesService(ShinyAttaquesRepository shinyAttaquesRepository, AttaquesService attaqueService, PokemonShinyService shinyService) {
        this.shinyAttaquesRepository = shinyAttaquesRepository;
        this.attaqueService = attaqueService;
        this.shinyService = shinyService;
    }

    /**
     * Ajouter une association Pokemon shiny/Attaques
     * @param shinyId l'id du shiny
     * @param attaqueId l'id de l'attaque
     * @return la nouvelle association
     */
    public ShinyAttaques addShinyAttaque(Integer shinyId, Long attaqueId, Long position) {
        // Récupérer les entités Pokémon shiny et Attaques à partir de leurs IDs
        PokemonShiny pokemonShiny = shinyService.findShinyById(shinyId);
        Attaques attaque = attaqueService.findById(attaqueId);

        ShinyAttaques shinyAttaque = new ShinyAttaques(pokemonShiny, attaque, position);

        return shinyAttaque;
    }

    /**
     * Méthode pour trouver toutes les associations
     * @return la liste de toutes les associations
     */
    public List<ShinyAttaques> getAllShinyAttaques() {
        return shinyAttaquesRepository.findAll();
    }

    /**
     * Récupérer une association par son ID
     * @param id l'id de l'association
     * @return l'association récupérée
     */
    public Optional<ShinyAttaques> getShinyAttaqueById(Long id) {
        return shinyAttaquesRepository.findById(id);
    }

    /**
     * Méthode pour trouver la liste des attaques pour un shiny
     * @param shinyId l'id du shiny
     * @return la liste des attaques d'un shiny donné
     */
    public List<ShinyAttaques> findAttaquesByShinyId(Integer shinyId) {
        return shinyAttaquesRepository.findByPokemonShinyId(shinyId);
    }

    /**
     * Mettre à jour une association
     * @param attaque L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public ShinyAttaques updateShinyAttaque(ShinyAttaques shinyAttaque) {
        Optional<ShinyAttaques> isRelationExist= shinyAttaquesRepository.findById(shinyAttaque.getId());

        if (isRelationExist.isPresent()) {
            ShinyAttaques existingRelation = isRelationExist.get();

            existingRelation.setPokemonShiny(shinyAttaque.getPokemonShiny());
            existingRelation.setAttaques(shinyAttaque.getAttaques());
            existingRelation.setPosition(shinyAttaque.getPosition());
            return shinyAttaquesRepository.save(existingRelation);
        } else {
            throw new CustomException("L'association n'existe pas", "id", shinyAttaque.getId());
        }
    }

    /**
     * Supprimer une association par son id
     * @param id l'id de l'association à supprimer
     * @return l'association supprimée
     */
    public ShinyAttaques deleteShinyAttaque(Long id) {
        // Récupérer l'objet dans un Optional
        Optional<ShinyAttaques> optionalShinyAttaque = shinyAttaquesRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalShinyAttaque.isPresent()) {
            ShinyAttaques shinyAttaque = optionalShinyAttaque.get();
            shinyAttaquesRepository.delete(shinyAttaque); // Supprimer l'objet
            return shinyAttaque; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Type", "id",  id);
        }
    }

    /**
     * Supprimer toutes les associations
     */
    public void deleteAllShinyAttaques() {
        shinyAttaquesRepository.deleteAll();
    }
}
