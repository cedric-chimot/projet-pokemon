package com.cch.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attaques")
public class Attaques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_attaque")
    private String nomAttaque;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Types typeAttaque;

    // Relation OneToMany pour les PokémonShiny qui possèdent cette attaque
    @JsonIgnore
    @OneToMany(mappedBy = "attaque1")
    private Set<PokemonShiny> pokemonShinysAttaque1 = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "attaque2")
    private Set<PokemonShiny> pokemonShinysAttaque2 = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "attaque3")
    private Set<PokemonShiny> pokemonShinysAttaque3 = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "attaque4")
    private Set<PokemonShiny> pokemonShinysAttaque4 = new HashSet<>();

    public Attaques(String nomAttaque, Types type) {
        this.nomAttaque = nomAttaque;
        this.typeAttaque = type;
    }

    @Override
    public String toString() {
        return "Attaques{" +
                "id=" + id +
                ", nomAttaque='" + nomAttaque + '\'' +
                ", typeAttaque=" + typeAttaque +
                '}';
    }
}
