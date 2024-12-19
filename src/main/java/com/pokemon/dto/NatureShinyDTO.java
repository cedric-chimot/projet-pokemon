package com.pokemon.dto;

import lombok.Data;

@Data
public class NatureShinyDTO {

    private String nomNature;

    public NatureShinyDTO(String nomNature) {
        this.nomNature = nomNature;
    }
}
