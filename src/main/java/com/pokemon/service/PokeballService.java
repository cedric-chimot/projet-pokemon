package com.pokemon.service;

import com.pokemon.dto.PokeballDTO;
import com.pokemon.entity.Pokeballs;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.PokeballRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service des pokeballs
 */
@Service
@Transactional
public class PokeballService {

    /**
     * Le repository des pokeballs
     */
    private final PokeballRepository pokeballRepository;

    /**
     * Le constructeur
     * @param pokeballRepository Injection du repository
     */
    public PokeballService(PokeballRepository pokeballRepository) {
        this.pokeballRepository = pokeballRepository;
    }

    /**
     * Méthode pour créer une nouvelle pokeball
     * @param pokeball la pokeball à créer
     * @return la pokeball nouvellement créée
     */
    public Pokeballs save(Pokeballs pokeball) {
        return pokeballRepository.save(pokeball);
    }

    /**
     * Méthode pour trouver toutes les pokeballs
     * @return la liste de toutes les pokeballs
     */
    public List<PokeballDTO> findAllPokeballs() {
        return pokeballRepository.findAll()
                .stream().map(pokeballs -> {
                    PokeballDTO dto = new PokeballDTO();
                    dto.setId(pokeballs.getId());
                    dto.setNomPokeball(pokeballs.getNomPokeball());
                    dto.setNbPokemon(pokeballs.getNbPokemon());
                    dto.setNbShiny(pokeballs.getNbShiny());
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver une pokeball par son id
     * @param id l'id de la pokeball recherchée
     * @return la pokeball trouvée
     */
    public Optional<PokeballDTO> findPokeballById(Integer id) {
        return pokeballRepository.findById(id)
                .map(pokeballs -> {
                    PokeballDTO dto = new PokeballDTO();
                    dto.setId(pokeballs.getId());
                    dto.setNomPokeball(pokeballs.getNomPokeball());
                    dto.setNbPokemon(pokeballs.getNbPokemon());
                    dto.setNbShiny(pokeballs.getNbShiny());
                    return dto;
                });
    }

    /**
     * Mettre à jour une pokeball
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public Pokeballs update(Pokeballs shiny) {
        return pokeballRepository.save(shiny);
    }

    /**
     * Méthode pour supprimer une pokeball par son Id
     * @param id L'identifiant de la pokeball à supprimer
     * @return L'objet supprimé
     */
    public Pokeballs deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<Pokeballs> optionalPokeball = pokeballRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalPokeball.isPresent()) {
            Pokeballs shiny = optionalPokeball.get();
            pokeballRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Pokeball", "id",  id);
        }
    }

    /**
     * Supprimer toutes les pokeballs
     */
    public void deleteAll() {
        pokeballRepository.deleteAll();
    }

}
