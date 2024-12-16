package com.pokemon.dto;

import lombok.Data;

@Data
public class DresseurDTO {

    private String idDresseur;

    private String nomDresseur;

    public DresseurDTO(String idDresseur, String nomDresseur) {
        this.idDresseur = idDresseur;
        this.nomDresseur = nomDresseur;
    }
}
