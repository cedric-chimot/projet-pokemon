package com.cch.pokemon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon_shiny")
public class PokemonShiny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "num_dex", nullable = false)
    private String numDex;

    @Column(name = "nom_pokemon", nullable = false)
    private String nomPokemon;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false)
    private Natures nature;

    @ManyToOne
    @JoinColumn(name = "id_dresseur", nullable = false)
    private Dresseurs dresseur;

    @ManyToOne
    @JoinColumn(name = "id_pokeball", nullable = false)
    private Pokeballs pokeball;

    @Column(name = "iv_manquant", nullable = false)
    private String ivManquant;

    @ManyToOne
    @JoinColumn(name = "type1", nullable = false)
    private Types type1;

    @ManyToOne
    @JoinColumn(name = "type2")
    private Types type2;

    @ManyToOne
    @JoinColumn(name = "id_sexe")
    private Sexe sexe;

    // Remplacement de la relation ManyToMany par des ManyToOne pour chaque attaque
    @ManyToOne
    @JoinColumn(name = "attaque1")
    private Attaques attaque1;

    @ManyToOne
    @JoinColumn(name = "attaque2")
    private Attaques attaque2;

    @ManyToOne
    @JoinColumn(name = "attaque3")
    private Attaques attaque3;

    @ManyToOne
    @JoinColumn(name = "attaque4")
    private Attaques attaque4;

    @ManyToOne
    @JoinColumn(name = "id_boite")
    private Boites boite;

    @Column(name = "position", nullable = false)
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Regions regionShiny;

    public PokemonShiny(String numDex, String nomPokemon, Natures nature, Dresseurs dresseur, Pokeballs pokeball, String ivManquant,
                        Types type1, Types type2, Sexe sexe, Attaques attaque1, Attaques attaque2, Attaques attaque3, Attaques attaque4,
                        Boites boite, Integer position, Regions regionShiny) {
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.nature = nature;
        this.dresseur = dresseur;
        this.pokeball = pokeball;
        this.ivManquant = ivManquant;
        this.type1 = type1;
        this.type2 = type2;
        this.sexe = sexe;
        this.attaque1 = attaque1;
        this.attaque2 = attaque2;
        this.attaque3 = attaque3;
        this.attaque4 = attaque4;
        this.boite = boite;
        this.position = position;
        this.regionShiny = regionShiny;
    }

    public PokemonShiny(String numDex, String nomPokemon, Natures nature, Dresseurs dresseur, Pokeballs pokeball, String ivManquant,
                        Types type1, Sexe sexe, Attaques attaque1, Attaques attaque2, Attaques attaque3, Attaques attaque4,
                        Boites boite, Integer position, Regions regionShiny) {
        this.numDex = numDex;
        this.nomPokemon = nomPokemon;
        this.nature = nature;
        this.dresseur = dresseur;
        this.pokeball = pokeball;
        this.ivManquant = ivManquant;
        this.type1 = type1;
        this.type2 = null; // 👈 On met explicitement `null` si ce constructeur est utilisé
        this.sexe = sexe;
        this.attaque1 = attaque1;
        this.attaque2 = attaque2;
        this.attaque3 = attaque3;
        this.attaque4 = attaque4;
        this.boite = boite;
        this.position = position;
        this.regionShiny = regionShiny;
    }

    @Override
    public String toString() {
      return "PokemonShiny{" +
        "id=" + id +
        ", numDex='" + numDex + '\'' +
        ", nomPokemon='" + nomPokemon + '\'' +
        ", nature=" + (nature != null ? nature.getNomNature() : "null") +
        ", dresseur=" + (dresseur != null ? dresseur.getNomDresseur() : "null") +
        ", pokeball=" + (pokeball != null ? pokeball.getNomPokeball() : "null") +
        ", ivManquant='" + ivManquant + '\'' +
        ", type1=" + (type1 != null ? type1.getNomType() : "null") +
        ", type2=" + (type2 != null ? type2.getNomType() : "null") +
        ", sexe=" + (sexe != null ? sexe.getSexe() : "null") +
        ", attaque1=" + (attaque1 != null ? attaque1.getNomAttaque() : "null") +
        ", attaque2=" + (attaque2 != null ? attaque2.getNomAttaque() : "null") +
        ", attaque3=" + (attaque3 != null ? attaque3.getNomAttaque() : "null") +
        ", attaque4=" + (attaque4 != null ? attaque4.getNomAttaque() : "null") +
        ", boiteShiny=" + (boite != null ? boite.getNom() : "null") +
        ", regionShiny=" + (regionShiny != null ? regionShiny.getNomRegion() : "null") +
        '}';
    }

}
