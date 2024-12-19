package com.pokemon.dto;

import lombok.Data;

@Data
public class PokeballShinyDTO {

    private String nomPokeball;

    public PokeballShinyDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }
}
