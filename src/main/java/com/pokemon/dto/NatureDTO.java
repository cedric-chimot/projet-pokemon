package com.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NatureDTO {

    private Integer id;

    private String nomNature;

    private Long nbPokemon;

    private Long nbShiny;
}
