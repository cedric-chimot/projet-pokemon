package com.pokemon.entity;

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
@Table(name = "natures")
public class Natures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nature")
    private Integer id;

    @Column(name = "nom_nature", nullable = false)
    private String nomNature;

    @Column(name = "nb_pokemon")
    private Long nbPokemon;

    @Column(name = "nb_shiny")
    private Long nbShiny;

    @JsonIgnore
    @OneToMany(mappedBy = "nature")
    private List<PokemonShiny> shinyList;

    public Natures(String nomNature, Long nbPokemon, Long nbShiny) {
        this.nomNature = nomNature;
        this.nbPokemon = nbPokemon;
        this.nbShiny = nbShiny;
    }

    @Override
    public String toString() {
        return "Natures{" +
                "id=" + id +
                ", nomNature='" + nomNature + '\'' +
                ", nbPokemon=" + nbPokemon +
                ", nbShiny=" + nbShiny +
                '}';
    }
}
