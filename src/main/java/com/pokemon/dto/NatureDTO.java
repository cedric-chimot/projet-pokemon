package com.pokemon.dto;

import lombok.Data;

@Data
public class NatureDTO {

    private String nomNature;

    public NatureDTO(String nomNature) {
        this.nomNature = nomNature;
    }
}
