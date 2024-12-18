package com.pokemon.dto;

import lombok.Data;

@Data
public class DresseurShinyDTO {

    private String idDresseur;

    private String nomDresseur;

    public DresseurShinyDTO(String idDresseur, String nomDresseur) {
        this.idDresseur = idDresseur;
        this.nomDresseur = nomDresseur;
    }

}
