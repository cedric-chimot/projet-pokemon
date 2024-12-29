package com.pokemon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokeballShinyDTO {

    private String nomPokeball;

    public PokeballShinyDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }
}
