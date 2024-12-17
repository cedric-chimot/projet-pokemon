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

    public PokemonShiny(String numDex, String nomPokemon, Natures nature, Dresseurs dresseur, Pokeballs pokeball, String ivManquant, Types type1, Types type2, Sexe sexe) {
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.nature = nature;
        this.dresseur = dresseur;
        this.pokeball = pokeball;
        this.ivManquant = ivManquant;
        this.type1 = type1;
        this.type2 = type2;
        this.sexe = sexe;
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
                '}';
    }
}
