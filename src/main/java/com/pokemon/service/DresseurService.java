package com.pokemon.service;

import com.pokemon.dto.DresseurDTO;
import com.pokemon.entity.Dresseurs;
import com.pokemon.repository.DresseurRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DresseurService {

    private final DresseurRepository dresseurRepository;

    public DresseurService(DresseurRepository dresseurRepository) {
        this.dresseurRepository = dresseurRepository;
    }

    @Transactional
    public Dresseurs save(Dresseurs dresseurs) {
        return dresseurRepository.save(dresseurs);
    }

    public List<DresseurDTO> findAllDresseurs() {
        return dresseurRepository.findAll()
                .stream().map(dresseurs -> {
                    DresseurDTO dto = new DresseurDTO();
                    dto.setIdDresseur(dresseurs.getIdDresseur());
                    dto.setNomDresseur(dresseurs.getNomDresseur());
                    dto.setNb_pokemon(dresseurs.getNbPokemon());
                    dto.setNb_shiny(dresseurs.getNbShiny());
                    return dto;
                }).collect(Collectors.toList());
    }

    public Optional<DresseurDTO> findDresseurById(Integer id) {
        return dresseurRepository.findById(id)
                .map(dresseurs -> {
                    DresseurDTO dto = new DresseurDTO();
                    dto.setIdDresseur(dresseurs.getIdDresseur());
                    dto.setNomDresseur(dresseurs.getNomDresseur());
                    dto.setNb_pokemon(dresseurs.getNbPokemon());
                    dto.setNb_shiny(dresseurs.getNbShiny());
                    return dto;
                });
    }

}
