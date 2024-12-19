package com.pokemon.service;

import com.pokemon.dto.*;
import com.pokemon.entity.PokemonShiny;
import com.pokemon.repository.PokemonShinyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonShinyService {

    private final PokemonShinyRepository shinyRepository;

    public PokemonShinyService(PokemonShinyRepository shinyRepository) {
        this.shinyRepository = shinyRepository;
    }

    @Transactional
    public PokemonShiny shinySave(PokemonShiny shiny) {
        return shinyRepository.save(shiny);
    }

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
                    return dto;
                }).collect(Collectors.toList());
    }

    /**
     * @param id l'id du pokémon recherché
     * @return le pokémon et toutes ses données
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
                return dto;
            });
    }

    public List<PokemonDTO> findByNumDex(String numDex) {
        List<PokemonDTO> shinies = shinyRepository.findByNumDex(numDex);
        return shinies.stream()
                .map(shiny -> new PokemonDTO(shiny.getId(), shiny.getNumDex(), shiny.getNomPokemon()))
                .collect(Collectors.toList());
    }

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

}
