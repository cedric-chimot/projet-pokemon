package com.cch.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boite_dresseur")
public class BoiteDresseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boite_id", nullable = false)
    private Boites boite;

    @ManyToOne
    @JoinColumn(name = "dresseur_id", nullable = false)
    private Dresseurs dresseur;

    @JoinColumn(name = "nb_pokemon", nullable = false)
    private Integer nbPokemon;

    @Override
    public String toString() {
        return "BoiteDresseur{" +
                "id=" + id +
                ", boite=" + boite +
                ", dresseur=" + dresseur +
                ", nbPokemon=" + nbPokemon +
                '}';
    }
}
