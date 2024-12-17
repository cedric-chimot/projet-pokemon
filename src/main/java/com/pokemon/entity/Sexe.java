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
@Table(name = "sexe")
public class Sexe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "nb_total")
    private Integer nbTotal;

    @Column(name = "nb_shiny")
    private Integer nbShiny;

    @OneToMany(mappedBy = "sexe")
    private List<PokemonShiny> shinyList;

    public Sexe(String sexe, Integer nbTotal, Integer nbShiny) {
        this.sexe = sexe;
        this.nbTotal = nbTotal;
        this.nbShiny = nbShiny;
    }

    @Override
    public String toString() {
        return "Sexe{" +
                "id=" + id +
                ", sexe='" + sexe + '\'' +
                ", nbTotal=" + nbTotal +
                ", nbShiny=" + nbShiny +
                '}';
    }
}
