package com.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokedexRequeteDTO {

    private String numDex;

    private String nomPokemon;

    private Integer idNature;

    private Integer idDresseur;

    private Integer idPokeball;

    private Long idBoite;

    private Long idRegion;

}
