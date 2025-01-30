package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequeteDTO {

    private Integer id;

    private String numDex;

    private String nomPokemon;

    private Integer idNature;

    private Integer idDresseur;

    private Integer idPokeball;

    private String ivManquant;

    private Integer type1;

    private Integer type2;

    private Integer idSexe;

    private Long attaque1;

    private Long attaque2;

    private Long attaque3;

    private Long attaque4;

    private String boite;

    private Integer position;

    private Long idRegion;

}
