package com.pokemon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NatureReduitDTO {

    private String nomNature;

    public NatureReduitDTO(String nomNature) {
        this.nomNature = nomNature;
    }

}
