package com.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boite_pokedex")
public class BoitePokedexNational {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_boite", nullable = false)
    private String nomBoite;

    @Column(name = "nb_males", nullable = false)
    private Long nbMales;

    @Column(name = "nb_femelles", nullable = false)
    private Long nbFemelles;

    @Column(name = "nb_assexues", nullable = false)
    private Long nbAssexues;

    @Column(name = "nb_level100", nullable = false)
    private Long nbLevel100;

    @JsonIgnore
    @OneToMany(mappedBy = "boitePokedex")
    private List<PokedexNational> pokemonList;

    @Override
    public String toString() {
        return "BoitePokedexNational{" +
                "nbLevel100=" + nbLevel100 +
                ", nbAssexues=" + nbAssexues +
                ", nbFemelles=" + nbFemelles +
                ", nbMales=" + nbMales +
                ", nomBoite='" + nomBoite + '\'' +
                ", id=" + id +
                '}';
    }

}
