package com.pokemon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon_shiny")
public class PokemonShiny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "num_dex", nullable = false)
    private String numDex;

    @Column(name = "nom_pokemon", nullable = false)
    private String nomPokemon;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false)
    private Natures nature;

    @ManyToOne
    @JoinColumn(name = "id_dresseur", nullable = false)
    private Dresseurs dresseur;

    @ManyToOne
    @JoinColumn(name = "id_pokeball", nullable = false)
    private Pokeballs pokeball;

    @Column(name = "iv_manquant", nullable = false)
    private String ivManquant;

    @ManyToOne
    @JoinColumn(name = "type1", nullable = false)
    private Types type1;

    @ManyToOne
    @JoinColumn(name = "type2")
    private Types type2;

    @ManyToOne
    @JoinColumn(name = "id_sexe")
    private Sexe sexe;

    @Column(name = "attaque1", nullable = false)
    private String attaque1;

    @Column(name = "attaque2", nullable = false)
    private String attaque2;

    @Column(name = "attaque3", nullable = false)
    private String attaque3;

    @Column(name = "attaque4", nullable = false)
    private String attaque4;

    @Column(name = "boite", nullable = false)
    private String boite;

    @Column(name = "position", nullable = false)
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Regions regionShiny;

    public PokemonShiny(String numDex, String nomPokemon, Natures nature, Dresseurs dresseur, Pokeballs pokeball, String ivManquant, Types type1,
                        Types type2, Sexe sexe, String attaque1, String attaque2, String attaque3, String attaque4, String boite, Integer position,
                        Regions regions) {
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.nature = nature;
        this.dresseur = dresseur;
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
        this.regionShiny = regions;
    }

    @Override
    public String toString() {
        return "PokemonShiny{" +
                "id=" + id +
                ", numDex='" + numDex + '\'' +
                ", nomPokemon='" + nomPokemon + '\'' +
                ", nature=" + nature +
                ", dresseur=" + dresseur +
                ", pokeball=" + pokeball +
                ", ivManquant='" + ivManquant + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", sexe=" + sexe +
                ", attaque1='" + attaque1 + '\'' +
                ", attaque2='" + attaque2 + '\'' +
                ", attaque3='" + attaque3 + '\'' +
                ", attaque4='" + attaque4 + '\'' +
                ", boite='" + boite + '\'' +
                ", position=" + position + '\'' +
                ", region='" + regionShiny +
                '}';
    }
}
