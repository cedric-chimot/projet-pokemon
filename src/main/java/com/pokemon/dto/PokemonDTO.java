package com.pokemon.dto;

import lombok.Data;

@Data
public class PokemonDTO {

    private Integer id;

    private String numDex;

    private String nomPokemon;

    public PokemonDTO(Integer id, String numDex, String nomPokemon) {
        this.id = id;
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
    }

}
