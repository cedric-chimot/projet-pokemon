package com.cch.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boite_nature")
public class BoiteNature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boite_id", nullable = false)
    private Boites boite;

    @ManyToOne
    @JoinColumn(name = "nature_id", nullable = false)
    private Natures nature;

    @JoinColumn(name = "nb_pokemon", nullable = false)
    private Integer nbPokemon;

    @Override
    public String toString() {
        return "BoiteNature{" +
                "id=" + id +
                ", boite=" + boite +
                ", nature=" + nature +
                ", nbPokemon=" + nbPokemon +
                '}';
    }
}
