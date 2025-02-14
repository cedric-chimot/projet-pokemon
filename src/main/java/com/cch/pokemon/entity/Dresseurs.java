package com.cch.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "dresseurs")
public class Dresseurs {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "num_dresseur", nullable = false)
  private String numDresseur;

  @Column(name = "nom_dresseur", nullable = false)
  private String nomDresseur;

  @Column(name = "nb_pokemon")
  private Long nbPokemon;

  @Column(name = "nb_shiny")
  private Long nbShiny;

  @ManyToOne
  @JoinColumn(name = "id_region_dresseur")
  private RegionDresseur regionDresseur;

  @JsonIgnore
  @OneToMany(mappedBy = "dresseur")
  private List<PokemonShiny> shinyList;

  @JsonIgnore
  @OneToMany(mappedBy = "dresseurPokedex")
  private List<PokedexNational> pokemonList;

  public Dresseurs(String numDresseur, String nomDresseur, Long nbPokemon, Long nbShiny, RegionDresseur regionDresseur) {
    this.numDresseur = numDresseur;
    this.nomDresseur = nomDresseur;
    this.nbPokemon = nbPokemon;
    this.nbShiny = nbShiny;
    this.regionDresseur = regionDresseur;
  }

  public Dresseurs(String numDresseur, String nomDresseur, Long nbPokemon, Long nbShiny) {
    this.numDresseur = numDresseur;
    this.nomDresseur = nomDresseur;
    this.nbPokemon = nbPokemon;
    this.nbShiny = nbShiny;
    this.regionDresseur = null;
  }

  @Override
  public String toString() {
    return "Dresseurs{" +
      "id=" + id +
      ", numDresseur='" + numDresseur + '\'' +
      ", nomDresseur='" + nomDresseur + '\'' +
      ", nbPokemon=" + nbPokemon +
      ", nbShiny=" + nbShiny +
      ", regionDresseur=" + (regionDresseur != null ? regionDresseur.getNomRegionDresseur() : "null") +
      '}';
  }
}
