package com.pokemon.dto;

import lombok.Data;

@Data
public class DresseurDTO {

    private String idDresseur;

    private String nomDresseur;

    private Long nb_pokemon;

    private Long nb_shiny;

    public DresseurDTO() {

    }
}
