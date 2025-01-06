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
@Table(name = "pokedex")
public class PokedexNational {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "num_dex")
    private String numDex;

    @Column(name = "nom_pokemon")
    private String nomPokemon;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false)
    private Natures naturePokedex;

    @ManyToOne
    @JoinColumn(name = "dresseur_id", nullable = false)
    private Dresseurs dresseurPokedex;

    @ManyToOne
    @JoinColumn(name = "id_pokeball", nullable = false)
    private Pokeballs pokeballPokedex;

    @ManyToOne
    @JoinColumn(name = "id_boite", nullable = false)
    private BoitePokedexNational boitePokedex;

    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Regions region;

    public PokedexNational(String numDex, String nomPokemon, Natures naturePokedex, Dresseurs dresseurPokedex, Pokeballs pokeballPokedex,
                           BoitePokedexNational boitePokedex, Regions region) {
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.naturePokedex = naturePokedex;
        this.dresseurPokedex = dresseurPokedex;
        this.pokeballPokedex = pokeballPokedex;
        this.boitePokedex = boitePokedex;
        this.region = region;
    }

    @Override
    public String toString() {
        return "PokedexNational{" +
                "id=" + id +
                ", numDex='" + numDex + '\'' +
                ", nomPokemon='" + nomPokemon + '\'' +
                ", naturePokedex=" + naturePokedex +
                ", dresseurPokedex=" + dresseurPokedex +
                ", pokeballPokedex=" + pokeballPokedex +
                ", boitePokedex=" + boitePokedex +
                ", region=" + region +
                '}';
    }

}
