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
                    dto.setNature(shiny.getNature() != null ? new NatureDTO(shiny.getNature().getNomNature()) : null);
                    dto.setDresseur(shiny.getDresseur() != null ? new DresseurDTO(shiny.getDresseur().getIdDresseur(), shiny.getDresseur().getNomDresseur()) : null);
                    dto.setPokeball(shiny.getNature() != null ? new PokeballDTO(shiny.getPokeball().getNomPokeball()) : null);
                    dto.setType1(shiny.getType1() != null ? new TypeDTO(shiny.getType1().getNomType()) : null);
                    dto.setType2(shiny.getType2() != null ? new TypeDTO(shiny.getType2().getNomType()) : null);
                    dto.setSexe(shiny.getSexe() != null ? new SexeDTO(shiny.getSexe().getSexe()) : null);
                    dto.setAttaque1(shiny.getAttaque1());
                    dto.setAttaque2(shiny.getAttaque2());
                    dto.setAttaque3(shiny.getAttaque3());
                    dto.setAttaque4(shiny.getAttaque4());
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
                dto.setNature(shiny.getNature() != null ? new NatureDTO(shiny.getNature().getNomNature()) : null);
                dto.setDresseur(shiny.getDresseur() != null ? new DresseurDTO(shiny.getDresseur().getIdDresseur(), shiny.getDresseur().getNomDresseur()) : null);
                dto.setPokeball(shiny.getNature() != null ? new PokeballDTO(shiny.getPokeball().getNomPokeball()) : null);
                dto.setType1(shiny.getType1() != null ? new TypeDTO(shiny.getType1().getNomType()) : null);
                dto.setType2(shiny.getType2() != null ? new TypeDTO(shiny.getType2().getNomType()) : null);
                dto.setSexe(shiny.getSexe() != null ? new SexeDTO(shiny.getSexe().getSexe()) : null);
                dto.setAttaque1(shiny.getAttaque1());
                dto.setAttaque2(shiny.getAttaque2());
                dto.setAttaque3(shiny.getAttaque3());
                dto.setAttaque4(shiny.getAttaque4());
                return dto;
            });
    }
}
