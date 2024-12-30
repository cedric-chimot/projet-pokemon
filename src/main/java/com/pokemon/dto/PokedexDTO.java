package com.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokedexDTO {

    private String numDex;

    private String nomPokemon;

    private String nomNature;

    private String nomPokeball;

    private String nomBoite;

    private String numDresseur;

    private String nomDresseur;

}
