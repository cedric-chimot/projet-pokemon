package com.pokemon.service;

import com.pokemon.dto.*;
import com.pokemon.entity.PokemonShiny;
import com.pokemon.repository.PokemonShinyRepository;
import jakarta.persistence.EntityNotFoundException;
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
     * Le constructeur du service
     * @param shinyRepository Injection du repository Shiny
     */
    public PokemonShinyService(PokemonShinyRepository shinyRepository) {
        this.shinyRepository = shinyRepository;
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
    public List<PokemonShinyDTO> findAllShiny() {
        return shinyRepository.findAll()
                .stream().map(shiny -> {
                    PokemonShinyDTO dto = new PokemonShinyDTO();
                    dto.setId(shiny.getId());
                    dto.setNumDex(shiny.getNumDex());
                    dto.setNomPokemon(shiny.getNomPokemon());
                    dto.setIvManquant(shiny.getIvManquant());
                    dto.setNature(shiny.getNature() != null ? new NatureShinyDTO(shiny.getNature().getNomNature()) : null);

                    if (shiny.getDresseur() != null) {
                        dto.setDresseur(new DresseurShinyDTO(
                                shiny.getDresseur().getIdDresseur(),
                                shiny.getDresseur().getNomDresseur()
                        ));
                    }

                    dto.setPokeball(shiny.getNature() != null ? new PokeballShinyDTO(shiny.getPokeball().getNomPokeball()) : null);
                    dto.setType1(shiny.getType1() != null ? new TypeDTO(shiny.getType1().getNomType()) : null);
                    dto.setType2(shiny.getType2() != null ? new TypeDTO(shiny.getType2().getNomType()) : null);
                    dto.setSexe(shiny.getSexe() != null ? new SexeDTO(shiny.getSexe().getSexe()) : null);
                    dto.setAttaque1(shiny.getAttaque1());
                    dto.setAttaque2(shiny.getAttaque2());
                    dto.setAttaque3(shiny.getAttaque3());
                    dto.setAttaque4(shiny.getAttaque4());
                    dto.setBoite(shiny.getBoite());
                    dto.setPosition(shiny.getPosition());
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * Méthode pour trouver un pokemon par son id
     * @param id L'id du pokemon recherché
     * @return le pokemon trouvé
     */
    public Optional<PokemonShinyDTO> findById(Integer id) {
        return shinyRepository.findById(id)
            .map(shiny -> {
                PokemonShinyDTO dto = new PokemonShinyDTO();
                dto.setId(shiny.getId());
                dto.setNumDex(shiny.getNumDex());
                dto.setNomPokemon(shiny.getNomPokemon());
                dto.setIvManquant(shiny.getIvManquant());
                dto.setNature(shiny.getNature() != null ? new NatureShinyDTO(shiny.getNature().getNomNature()) : null);

                if (shiny.getDresseur() != null) {
                    dto.setDresseur(new DresseurShinyDTO(
                            shiny.getDresseur().getIdDresseur(),
                            shiny.getDresseur().getNomDresseur()
                    ));
                }

                dto.setPokeball(shiny.getNature() != null ? new PokeballShinyDTO(shiny.getPokeball().getNomPokeball()) : null);
                dto.setType1(shiny.getType1() != null ? new TypeDTO(shiny.getType1().getNomType()) : null);
                dto.setType2(shiny.getType2() != null ? new TypeDTO(shiny.getType2().getNomType()) : null);
                dto.setSexe(shiny.getSexe() != null ? new SexeDTO(shiny.getSexe().getSexe()) : null);
                dto.setAttaque1(shiny.getAttaque1());
                dto.setAttaque2(shiny.getAttaque2());
                dto.setAttaque3(shiny.getAttaque3());
                dto.setAttaque4(shiny.getAttaque4());
                dto.setBoite(shiny.getBoite());
                dto.setPosition(shiny.getPosition());
                return dto;
            });
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
                .map(pokemonShiny -> new PokemonShinyDTO(
                        pokemonShiny.getId(),
                        pokemonShiny.getNumDex(),
                        pokemonShiny.getNomPokemon(),
                        pokemonShiny.getNature() != null ? pokemonShiny.getNature().getNomNature() : null,
                        pokemonShiny.getDresseur() != null ? pokemonShiny.getDresseur().getIdDresseur() : null,
                        pokemonShiny.getDresseur() != null ? pokemonShiny.getDresseur().getNomDresseur() : null,
                        new PokeballShinyDTO(pokemonShiny.getPokeball().getNomPokeball()),
                        pokemonShiny.getIvManquant(),
                        new TypeDTO(pokemonShiny.getType1().getNomType()),
                        pokemonShiny.getType2() != null && !pokemonShiny.getType2().getNomType().isEmpty() ?
                                new TypeDTO(pokemonShiny.getType2().getNomType()) : null,
                        new SexeDTO(pokemonShiny.getSexe().getSexe()),
                        pokemonShiny.getAttaque1(),
                        pokemonShiny.getAttaque2(),
                        pokemonShiny.getAttaque3(),
                        pokemonShiny.getAttaque4(),
                        pokemonShiny.getBoite(),
                        pokemonShiny.getPosition()
                ))
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
            throw new EntityNotFoundException("PokemonShiny with id " + id + " not found");
        }
    }

    /**
     * Supprimer tous les shiny
     */
    public void deleteAll() {
        shinyRepository.deleteAll();
    }

}
