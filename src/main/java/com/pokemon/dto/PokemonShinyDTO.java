package com.pokemon.dto;

import lombok.Data;

@Data
public class PokemonShinyDTO {

    private Integer id;

    private String numDex;

    private String nomPokemon;

    private NatureDTO nature;

    private DresseurDTO dresseur;

    private PokeballDTO pokeball;

    private String ivManquant;

    private TypeDTO type1;

    private TypeDTO type2;

    private SexeDTO sexe;

    private String attaque1;

    private String attaque2;

    private String attaque3;

    private String attaque4;

}
