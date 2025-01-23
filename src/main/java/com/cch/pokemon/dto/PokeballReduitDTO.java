package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokeballReduitDTO {

    private Integer id;

    private String nomPokeball;

    public PokeballReduitDTO(String nomPokeball) {
        this.nomPokeball = nomPokeball;
    }

}
