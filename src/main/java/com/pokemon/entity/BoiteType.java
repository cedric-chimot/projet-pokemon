package com.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boite_type")
public class BoiteType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boite_id", nullable = false)
    private Boites boite;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Types type;

    @JoinColumn(name = "nb_pokemon", nullable = false)
    private Integer nbPokemon;

    @Override
    public String toString() {
        return "BoiteType{" +
                "id=" + id +
                ", boite=" + boite +
                ", type=" + type +
                ", nbPokemon=" + nbPokemon +
                '}';
    }

}
