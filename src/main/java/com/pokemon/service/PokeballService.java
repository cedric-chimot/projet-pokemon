package com.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.dto.PokeballDTO;
import com.pokemon.dto.PokeballReduitDTO;
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
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur
     * @param pokeballRepository Injection du repository
     */
    public PokeballService(PokeballRepository pokeballRepository, ObjectMapper objectMapper) {
        this.pokeballRepository = pokeballRepository;
        this.objectMapper = objectMapper;
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
     * Méthode pour trouver toutes les pokeballs (retourne toutes les données)
     * @return la liste de toutes les pokeballs
     */
    public List<PokeballDTO> findAllPokeballs() {
        List<Pokeballs> pokeballList = pokeballRepository.findAllPokeballs();
        return pokeballList.stream()
                .map(pokeball -> objectMapper.convertValue(pokeball, PokeballDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver toutes les pokeballs (retourne le nom)
     * @return la liste de toutes les pokeballs
     */
    public List<PokeballReduitDTO> findAllPokeballsByNom() {
        List<Pokeballs> pokeballList = pokeballRepository.findAll();
        return pokeballList.stream()
                .map(pokeball -> objectMapper.convertValue(pokeball, PokeballReduitDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver une pokeball par son id (retourne l'entité complète)
     * @param id l'id de la pokeball recherchée
     * @return la pokeball trouvée
     */
    public Pokeballs findById(Integer id) {
        return pokeballRepository.findById(id)
                .orElseThrow(() -> new CustomException("Pokeball", "id", id)); // Renvoie l'entité
    }

    /**
     * Méthode pour trouver une pokeball par son id (retourne le nom de la pokeball)
     * @param id l'id de la pokeball recherchée
     * @return la pokeball trouvée
     */
    public PokeballReduitDTO findPokeballById(Integer id) {
        Optional<Pokeballs> pokeball = pokeballRepository.findById(id);
        return objectMapper.convertValue(pokeball, PokeballReduitDTO.class);
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
