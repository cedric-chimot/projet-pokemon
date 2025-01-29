package com.cch.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "shiny_attaques")
public class ShinyAttaques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_shiny", nullable = false)
    private PokemonShiny pokemonShiny;

    @ManyToOne
    @JoinColumn(name = "id_attaque", nullable = false)
    private Attaques attaques;

    private Long position;

    public ShinyAttaques(PokemonShiny pokemonShiny, Attaques attaques, Long position) {
        this.pokemonShiny = pokemonShiny;
        this.attaques = attaques;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ShinyAttaque{" +
                "id=" + id +
                ", pokemonShiny=" + pokemonShiny +
                ", attaque=" + attaques +
                '}';
    }
}
