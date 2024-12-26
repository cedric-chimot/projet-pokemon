package com.pokemon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NatureShinyDTO {

    private String nomNature;

    public NatureShinyDTO(String nomNature) {
        this.nomNature = nomNature;
    }

}
