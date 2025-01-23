package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoitePokedexReduitDTO {

    private Long id;

    private String nomBoite;

    public BoitePokedexReduitDTO(String nomBoite) {
    }
}
