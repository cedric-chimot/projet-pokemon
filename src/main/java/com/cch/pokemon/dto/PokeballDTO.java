package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokeballDTO {

    private Integer id;

    private String nomPokeball;

    private Long nbPokemon;

    private Long nbShiny;

    public PokeballDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }
}
