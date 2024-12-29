package com.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DresseurDTO {

    private Integer id;

    private String idDresseur;

    private String nomDresseur;

    private Long nb_pokemon;

    private Long nb_shiny;

}
