package com.pokemon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PokeballReduitDTO {

    private String nomPokeball;

    public PokeballReduitDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }
}
