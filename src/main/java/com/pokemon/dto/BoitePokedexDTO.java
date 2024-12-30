package com.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoitePokedexDTO {

    private Long id;

    private String nomBoite;

    private Long nbMales;

    private Long nbFemelles;

    private Long nbAssexues;

    private Long nbLevel100;

    public BoitePokedexDTO(String nomBoite) {
        this.nomBoite = nomBoite;
    }

}
