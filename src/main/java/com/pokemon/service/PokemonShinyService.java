package com.pokemon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.dto.PokemonDTO;
import com.pokemon.dto.PokemonShinyDTO;
import com.pokemon.dto.StatIvManquantDTO;
import com.pokemon.entity.PokemonShiny;
import com.pokemon.exceptions.CustomException;
import com.pokemon.repository.PokemonShinyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Le service PokemonShiny
 */
@Service
@Transactional
public class PokemonShinyService {

    /**
     * Le repository PokemonShiny
     */
    private final PokemonShinyRepository shinyRepository;

    /**
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur du service
     * @param shinyRepository Injection du repository Shiny
     * @param objectMapper Injection de l'ObjectMapper
     */
    public PokemonShinyService(PokemonShinyRepository shinyRepository, ObjectMapper objectMapper) {
        this.shinyRepository = shinyRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Méthode pour ajouter un shiny
     * @param shiny Le shiny à ajouter
     * @return Le shiny ajouté
     */
    public PokemonShiny shinySave(PokemonShiny shiny) {
        return shinyRepository.save(shiny);
    }

    /**
     * Méthode pour afficher la liste de tous les shinies
     * @return La liste de shinies
     */
    public List<PokemonShinyDTO> findAllShinies() {
        List<PokemonShiny> shinyList = shinyRepository.findAll();
        return shinyList.stream()
                .map(shiny -> objectMapper.convertValue(shiny, PokemonShinyDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un pokemon par son id
     * @param id L'id du pokemon recherché
     * @return le pokemon trouvé et toutes ses informations
     */
    public Optional<PokemonShinyDTO> findById(Integer id) {
        return shinyRepository.findById(id)
                .map(shiny -> objectMapper.convertValue(shiny, PokemonShinyDTO.class));
    }

    /**
     * Méthode pour trouver un shiny selon son numéro de pokédex
     * @param numDex Le numéro de pokédex recherché
     * @return Les données du pokémon trouvé
     */
    public List<PokemonDTO> findByNumDex(String numDex) {
        List<PokemonDTO> shinies = shinyRepository.findByNumDex(numDex);
        return shinies.stream()
                .map(shiny -> new PokemonDTO(shiny.getId(), shiny.getNumDex(), shiny.getNomPokemon()))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver et afficher tous les shinies d'une boite
     * @param boite La boite recherchée
     * @return La liste des shinies de la boite
     */
    public List<PokemonShinyDTO> findByBoite(String boite) {
        List<PokemonShiny> shinyList = shinyRepository.findByBoitePosition(boite);
        return shinyList.stream()
                .map(shiny -> objectMapper.convertValue(shiny, PokemonShinyDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Trouver le nombre de pokémon par Ivs Manquants
     * @return la liste des Ivs manquants et le nombre pour chaque
     */
    public List<StatIvManquantDTO> getStatsIvManquant() {
        List<Object[]> results = shinyRepository.getStatsIvManquant();

        return results.stream()
                .map(row -> new StatIvManquantDTO((String) row[0], (Long) row[1]))
                .collect(Collectors.toList());
    }

    /**
     * Mettre à jour un shiny
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public PokemonShiny update(PokemonShiny shiny) {
        return shinyRepository.save(shiny);
    }

    /**
     * Méthode pour supprimer un shiny par son Id
     * @param id L'identifiant du shiny à supprimer
     * @return L'objet supprimé
     */
    public PokemonShiny deleteById(Integer id) {
        // Récupérer l'objet dans un Optional
        Optional<PokemonShiny> optionalShiny = shinyRepository.findById(id);

        // Vérifier si l'objet existe
        if (optionalShiny.isPresent()) {
            PokemonShiny shiny = optionalShiny.get();
            shinyRepository.delete(shiny); // Supprimer l'objet
            return shiny; // Retourner l'objet supprimé
        } else {
            throw new CustomException("Shiny", "id", id);
        }
    }

    /**
     * Supprimer tous les shiny
     */
    public void deleteAll() {
        shinyRepository.deleteAll();
    }

}
