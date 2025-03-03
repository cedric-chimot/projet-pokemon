package com.cch.pokemon.dto;

import com.cch.pokemon.entity.Regions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokedexDTO {

    private Long id;

    private String numDex;

    private String nomPokemon;

    private NatureReduitDTO nomNature;

    private PokeballReduitDTO nomPokeball;

    private BoitePokedexReduitDTO boite;

    private DresseurReduitDTO dresseur;

    private Regions region;

}