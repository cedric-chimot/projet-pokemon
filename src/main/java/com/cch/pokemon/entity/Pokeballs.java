package com.cch.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokeballs")
public class Pokeballs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pokeball")
    private Integer id;

    @Column(name = "nom_pokeball", nullable = false)
    private String nomPokeball;

    @Column(name = "nb_pokemon")
    private Long nbPokemon;

    @Column(name = "nb_shiny")
    private Long nbShiny;

    @JsonIgnore
    @OneToMany(mappedBy = "pokeball")
    private List<PokemonShiny> shinyList;

    @JsonIgnore
    @OneToMany(mappedBy = "pokeballPokedex")
    private List<PokedexNational> pokemonList;

    public Pokeballs(String nomPokeball, Long nbPokemon, Long nbShiny) {
        this.nomPokeball = nomPokeball;
        this.nbPokemon = nbPokemon;
        this.nbShiny = nbShiny;
    }

    @Override
    public String toString() {
        return "Pokeballs{" +
                "id=" + id +
                ", nomPokeball='" + nomPokeball + '\'' +
                ", nbPokemon=" + nbPokemon +
                ", nbShiny=" + nbShiny +
                '}';
    }
}
