package com.pokemon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DresseurReduitDTO {

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
