package com.pokemon.dto;

import lombok.Data;

@Data
public class SexeDTO {

    private String sexe;

    public SexeDTO(String sexe) {
        this.sexe = sexe;
    }
}
