package com.cch.pokemon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boite_sexe")
public class BoiteSexe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "boite_id", nullable = false)
    private Boites boite;

    @ManyToOne
    @JoinColumn(name = "sexe_id", nullable = false)
    private Sexe sexe;

    @JoinColumn(name = "nb_pokemon", nullable = false)
    private Integer nbPokemon;

    @Override
    public String toString() {
        return "BoiteSexe{" +
                "id=" + id +
                ", boite=" + boite +
                ", sexe=" + sexe +
                ", nbPokemon=" + nbPokemon +
                '}';
    }

}
