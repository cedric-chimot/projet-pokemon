package com.pokemon.dto;

import lombok.Data;

@Data
public class TypeDTO {

    private String nomType;

    public TypeDTO(String nomType) {
        this.nomType = nomType;
    }
}
