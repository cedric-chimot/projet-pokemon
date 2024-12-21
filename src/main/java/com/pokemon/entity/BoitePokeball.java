package com.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boite_pokeball")
public class BoitePokeball {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boite_id", nullable = false)
    private Boites boite;

    @ManyToOne
    @JoinColumn(name = "pokeball_id", nullable = false)
    private Pokeballs pokeball;

    @JoinColumn(name = "nb_pokemon", nullable = false)
    private Integer nbPokemon;

    @Override
    public String toString() {
        return "BoitePokeball{" +
                "id=" + id +
                ", boite=" + boite +
                ", pokeball=" + pokeball +
                ", nbPokemon=" + nbPokemon +
                '}';
    }

}
