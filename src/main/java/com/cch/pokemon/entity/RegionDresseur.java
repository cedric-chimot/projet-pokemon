package com.cch.pokemon.entity;

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
@Table(name = "region_dresseur")
public class RegionDresseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegionDresseur")
    private Long idRegionDresseur;

    @Column(name = "nom_region")
    private String nomRegionDresseur;

    @JsonIgnore
    @OneToMany(mappedBy = "regionDresseur")
    private List<Dresseurs> dresseurList;

    public RegionDresseur(String nomRegionDresseur) {
        this.nomRegionDresseur = nomRegionDresseur;
    }

    @Override
    public String toString() {
        return "RegionDresseur{" +
                "idRegionDresseur=" + idRegionDresseur +
                ", nomRegionDresseur='" + nomRegionDresseur + '\'' +
                '}';
    }
}
