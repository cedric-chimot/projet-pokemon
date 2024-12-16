package com.pokemon.entity;

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
@Table(name = "dresseurs")
public class Dresseurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_dresseur", nullable = false)
    private String idDresseur;

    @Column(name = "nom_dresseur", nullable = false)
    private String nomDresseur;

    @Column(name = "nb_pokemon")
    private Long nbPokemon;

    @Column(name = "nb_shiny")
    private Long nbShiny;

    @OneToMany(mappedBy = "dresseur")
    private List<PokemonShiny> shinyList;

    public Dresseurs(String idDresseur, String nomDresseur, Long nbPokemon, Long nbShiny) {
        this.idDresseur = idDresseur;
        this.nomDresseur = nomDresseur;
        this.nbPokemon = nbPokemon;
        this.nbShiny = nbShiny;
    }

    @Override
    public String toString() {
        return "Dresseurs{" +
                "id=" + id +
                ", idDresseur='" + idDresseur + '\'' +
                ", nomDresseur='" + nomDresseur + '\'' +
                ", nbPokemon=" + nbPokemon +
                ", nbShiny=" + nbShiny +
                '}';
    }
}
