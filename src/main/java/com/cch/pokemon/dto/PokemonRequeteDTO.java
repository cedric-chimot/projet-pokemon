package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequeteDTO {

    private String numDex;

    private String nomPokemon;

    private Integer idNature;

    private Integer idDresseur;

    private Integer idPokeball;

    private String ivManquant;

    private Integer type1;

    private Integer type2;

    private Integer idSexe;

    private String attaque1;

    private String attaque2;

    private String attaque3;

    private String attaque4;

    private String boite;

    private Integer position;

    private Long idRegion;

}
