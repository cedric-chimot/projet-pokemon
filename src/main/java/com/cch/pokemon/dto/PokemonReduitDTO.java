package com.cch.pokemon.dto;

import lombok.Data;

@Data
public class PokemonReduitDTO {

    private Integer id;

    private String numDex;

    private String nomPokemon;

    public PokemonReduitDTO(Integer id, String numDex, String nomPokemon) {
        this.id = id;
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
    }

}
