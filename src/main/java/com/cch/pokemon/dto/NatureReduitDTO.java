package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NatureReduitDTO {

    private Integer id;

    private String nomNature;

    public NatureReduitDTO(String nomNature) {
        this.nomNature = nomNature;
    }

}
