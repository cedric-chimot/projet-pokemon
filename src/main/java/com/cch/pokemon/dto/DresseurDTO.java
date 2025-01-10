package com.cch.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DresseurDTO {

    private Integer id;

    private String numDresseur;

    private String nomDresseur;

    private Long nb_pokemon;

    private Long nb_shiny;

    public DresseurDTO(String idDresseur, String nomDresseur) {
        this.numDresseur = idDresseur;
        this.nomDresseur = nomDresseur;
    }

}
