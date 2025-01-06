package com.pokemon.dto;

import com.pokemon.entity.Regions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokedexDTO {

    private String numDex;

    private String nomPokemon;

    private NatureReduitDTO nomNature;

    private PokeballReduitDTO nomPokeball;

    private BoitePokedexReduitDTO nomBoite;

    private DresseurReduitDTO dresseur;

    private Regions region;

}
