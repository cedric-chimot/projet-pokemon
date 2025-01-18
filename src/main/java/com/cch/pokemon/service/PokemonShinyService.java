package com.cch.pokemon.service;

import com.cch.pokemon.dto.PokemonDTO;
import com.cch.pokemon.dto.PokemonReduitDTO;
import com.cch.pokemon.dto.PokemonRequeteDTO;
import com.cch.pokemon.dto.StatIvManquantDTO;
import com.cch.pokemon.entity.*;
import com.cch.pokemon.exceptions.CustomException;
import com.cch.pokemon.repository.PokemonShinyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
     * Appel des services des classes associées
     */
    private final NatureService natureService;
    private final DresseurService dresseurService;
    private final PokeballService pokeballService;
    private final TypeService typeService;
    private final SexeService sexeService;
    private final RegionsService regionsService;


    /**
     * Sérialisation d'objet Java au format Json
     */
    private final ObjectMapper objectMapper;

    /**
     * Le constructeur du service
     * @param shinyRepository Injection du repository Shiny
     * @param dresseurService et autres : pour injecter les services nécessaires
     * @param objectMapper Injection de l'ObjectMapper
     */
    public PokemonShinyService(PokemonShinyRepository shinyRepository, NatureService natureService, DresseurService dresseurService,
                               PokeballService pokeballService, TypeService typeService, SexeService sexeService, RegionsService regionsService,
                               ObjectMapper objectMapper) {
        this.shinyRepository = shinyRepository;
        this.natureService = natureService;
        this.dresseurService = dresseurService;
        this.pokeballService = pokeballService;
        this.typeService = typeService;
        this.sexeService = sexeService;
        this.regionsService = regionsService;
        this.objectMapper = objectMapper;
    }

    /**
     * Ajouter un shiny avec toutes les relations associées
     * @param pokemonRequeteDTO pour trouver les informations nécessaires à ajouter
     * @return le pokemon shiny nouvellement ajouté
     */
    public PokemonShiny shinySave(PokemonRequeteDTO pokemonRequeteDTO) {
        // Récupérer les entités associées via leurs services
        Natures nature = natureService.findById(pokemonRequeteDTO.getIdNature());
        Dresseurs dresseur = dresseurService.findById(pokemonRequeteDTO.getIdDresseur());
        Pokeballs pokeball = pokeballService.findById(pokemonRequeteDTO.getIdPokeball());
        Types type1 = typeService.findById(pokemonRequeteDTO.getType1());
        Types type2 = typeService.findById(pokemonRequeteDTO.getType2());
        Sexe sexe = sexeService.findById(pokemonRequeteDTO.getIdSexe());
        Regions region = regionsService.findById(pokemonRequeteDTO.getIdRegion());

        // Créer et sauvegarder le shiny
        PokemonShiny pokemonShiny = new PokemonShiny(
                pokemonRequeteDTO.getNumDex(),
                pokemonRequeteDTO.getNomPokemon(),
                nature,
                dresseur,
                pokeball,
                pokemonRequeteDTO.getIvManquant(),
                type1,
                type2,
                sexe,
                pokemonRequeteDTO.getAttaque1(),
                pokemonRequeteDTO.getAttaque2(),
                pokemonRequeteDTO.getAttaque3(),
                pokemonRequeteDTO.getAttaque4(),
                pokemonRequeteDTO.getBoite(),
                pokemonRequeteDTO.getPosition(),
                region
        );

        return shinyRepository.save(pokemonShiny);
    }

    /**
     * Méthode pour afficher la liste de tous les shinies
     * @return La liste de shinies
     */
    public List<PokemonDTO> findAllShinies() {
        List<PokemonShiny> shinyList = shinyRepository.findAll();
        return shinyList.stream()
                .map(shiny -> objectMapper.convertValue(shiny, PokemonDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un pokemon par son id
     * @param id L'id du pokemon recherché
     * @return le pokemon trouvé et toutes ses informations
     */
    public Optional<PokemonDTO> findById(Integer id) {
        return shinyRepository.findById(id)
                .map(shiny -> objectMapper.convertValue(shiny, PokemonDTO.class));
    }

    /**
     * Méthode pour trouver un shiny selon son numéro de pokédex
     * @param numDex Le numéro de pokédex recherché
     * @return Les données du pokémon trouvé
     */
    public List<PokemonReduitDTO> findByNumDex(String numDex) {
        List<PokemonReduitDTO> shinies = shinyRepository.findByNumDex(numDex);
        return shinies.stream()
                .map(shiny -> new PokemonReduitDTO(shiny.getId(), shiny.getNumDex(), shiny.getNomPokemon()))
                .collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver et afficher tous les shinies d'une boite
     * @param boite La boite recherchée
     * @return La liste des shinies de la boite
     */
    public List<PokemonDTO> findByBoite(String boite) {
        List<PokemonShiny> shinyList = shinyRepository.findByBoitePosition(boite);
        return shinyList.stream()
                .map(shiny -> objectMapper.convertValue(shiny, PokemonDTO.class))
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
     * Trouver la liste des pokemon shiny selon une région donnée
     * @param regionId l'id de la région demandée
     * @return le pokemon recherché
     */
    public List<PokemonShiny> getPokemonByRegion(Long regionId) {
        return shinyRepository.findByRegion(regionId);
    }

    /**
     * Méthode pour retrouver le nombre total de pokemons shiny
     * @return le nombre de shiny
     */
    public Long findShiniesCount() {
        return shinyRepository.countPokemonsShiny();
    }

    /**
     * Mettre à jour un shiny
     * @param shiny L'objet à mettre à jour
     * @return L'objet mis à jour
     */
    public PokemonShiny updatePokemonShiny(PokemonShiny shiny) {
        Optional<PokemonShiny> existingInPokedex= shinyRepository.findById(shiny.getId());

        if (existingInPokedex.isPresent()) {
            PokemonShiny existingPokemon = existingInPokedex.get();

            existingPokemon.setNumDex(shiny.getNumDex());
            existingPokemon.setNomPokemon(shiny.getNomPokemon());
            existingPokemon.setNature(shiny.getNature());
            existingPokemon.setDresseur(shiny.getDresseur());
            existingPokemon.setPokeball(shiny.getPokeball());
            existingPokemon.setIvManquant(shiny.getIvManquant());
            existingPokemon.setType1(shiny.getType1());
            existingPokemon.setType2(shiny.getType2());
            existingPokemon.setSexe(shiny.getSexe());
            existingPokemon.setAttaque1(shiny.getAttaque1());
            existingPokemon.setAttaque2(shiny.getAttaque2());
            existingPokemon.setAttaque3(shiny.getAttaque3());
            existingPokemon.setAttaque4(shiny.getAttaque4());
            existingPokemon.setBoite(shiny.getBoite());
            existingPokemon.setPosition(shiny.getPosition());
            existingPokemon.setRegionShiny(shiny.getRegionShiny());
            return shinyRepository.save(existingPokemon);
        } else {
            throw new CustomException("Le pokemon n'est pas présent dans le pokedex", "id", shiny.getId());
        }
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
