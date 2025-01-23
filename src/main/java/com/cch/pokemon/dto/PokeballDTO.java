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

    public PokeballDTO(Integer id, String nomPokeball) {
        this.id = id;
        this.nomPokeball = nomPokeball;
    }

    public PokeballDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }
}
