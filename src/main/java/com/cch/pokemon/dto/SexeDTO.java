package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SexeDTO {

    private Integer id;

    private String sexe;

    private Integer nbPokemon;

    private Integer nbShiny;

}
