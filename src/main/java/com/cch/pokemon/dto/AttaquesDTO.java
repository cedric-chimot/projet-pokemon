package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttaquesDTO {

    private Long id;

    private String nomAttaque;

    private TypeShinyDTO typeAttaque;

}
