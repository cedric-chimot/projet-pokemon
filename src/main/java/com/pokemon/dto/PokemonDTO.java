package com.pokemon.dto;

import com.pokemon.entity.Regions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {

    private Integer id;

    private String numDex;

    private String nomPokemon;

    private NatureReduitDTO nature;

    private DresseurReduitDTO dresseur;

    private PokeballReduitDTO pokeball;

    private String ivManquant;

    private TypeShinyDTO type1;

    private TypeShinyDTO type2;

    private SexeShinyDTO sexe;

    private String attaque1;

    private String attaque2;

    private String attaque3;

    private String attaque4;

    private String boite;

    private Integer position;

    private Regions region;

    public PokemonDTO(Integer id, String numDex, String nomPokemon, String nomNature, String numDresseur,
                      String nomDresseur, String pokeball, String ivManquant, TypeShinyDTO type1, TypeShinyDTO type2,
                      SexeShinyDTO sexe, String attaque1, String attaque2, String attaque3, String attaque4,
                      String boite, Integer position, Regions region) {
        this.id = id;
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.nature = new NatureReduitDTO(nomNature);
        this.dresseur = new DresseurReduitDTO(numDresseur, nomDresseur);
        this.pokeball = new PokeballReduitDTO(pokeball);
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
        this.region = region;
    }

}
