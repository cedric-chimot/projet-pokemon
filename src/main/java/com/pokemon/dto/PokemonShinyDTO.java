package com.pokemon.dto;

import lombok.Data;

@Data
public class PokemonShinyDTO {

    private Integer id;

    private String numDex;

    private String nomPokemon;

    private NatureShinyDTO nature;

    private DresseurShinyDTO dresseur;

    private PokeballShinyDTO pokeball;

    private String ivManquant;

    private TypeDTO type1;

    private TypeDTO type2;

    private SexeDTO sexe;

    private String attaque1;

    private String attaque2;

    private String attaque3;

    private String attaque4;

    private String boite;

    private Integer position;

    public PokemonShinyDTO() {
    }

    public PokemonShinyDTO(Integer id, String numDex, String nomPokemon, String nomNature, String idDresseur,
                           String nomDresseur, PokeballShinyDTO pokeball, String ivManquant, TypeDTO type1, TypeDTO type2,
                           SexeDTO sexe, String attaque1, String attaque2, String attaque3, String attaque4,
                           String boite, Integer position) {
        this.id = id;
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.nature = new NatureShinyDTO(nomNature);
        this.dresseur = new DresseurShinyDTO(idDresseur, nomDresseur);
        this.pokeball = pokeball;
        this.ivManquant = ivManquant;
        this.type1 = type1;
        this.type2 = type2;
        this.sexe = sexe;
        this.attaque1 = attaque1;
        this.attaque2 = attaque2;
        this.attaque3 = attaque3;
        this.attaque4 = attaque4;
        this.boite = boite;
        this.position = position;
    }

}
