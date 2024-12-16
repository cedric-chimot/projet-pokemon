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
@Table(name = "type")
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nomType;

    @Column(name = "nb_shiny")
    private Integer nbShiny;

    @OneToMany(mappedBy = "type1")
    private List<PokemonShiny> shinyListType1;

    @OneToMany(mappedBy = "type2")
    private List<PokemonShiny> shinyListType2;

    public Types(String nomType, Integer nbShiny) {
        this.nomType = nomType;
        this.nbShiny = nbShiny;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", nomType='" + nomType + '\'' +
                ", nbShiny=" + nbShiny +
                '}';
    }

}
