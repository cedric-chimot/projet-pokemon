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
@Table(name = "regions")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_region")
    private String nomRegion;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<PokedexNational> pokemonList;

    @JsonIgnore
    @OneToMany(mappedBy = "regionShiny")
    private List<PokemonShiny> shinyList;

    public Regions(Long id, String nomRegion) {
        this.id = id;
        this.nomRegion = nomRegion;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "nomRegion='" + nomRegion + '\'' +
                ", id=" + id +
                '}';
    }

}
