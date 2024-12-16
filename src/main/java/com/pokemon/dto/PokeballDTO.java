package com.pokemon.dto;

import lombok.Data;

@Data
public class PokeballDTO {

    private String nomPokeball;

    public PokeballDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }
}
