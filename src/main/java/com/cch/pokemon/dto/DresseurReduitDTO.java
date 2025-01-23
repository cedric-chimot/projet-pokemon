package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DresseurReduitDTO {

    private Integer id;

    private String numDresseur;

    private String nomDresseur;

    public DresseurReduitDTO(String nomDresseur) {
        this.nomDresseur = nomDresseur;
    }

    public DresseurReduitDTO(String numDresseur, String nomDresseur) {
        this.numDresseur = numDresseur;
        this.nomDresseur = nomDresseur;
    }

}
