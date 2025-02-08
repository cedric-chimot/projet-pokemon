package com.cch.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "boites")
public class Boites {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "nom")
  private String nom;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "boite_dresseur",
          joinColumns = @JoinColumn(name = "boite_id"),
          inverseJoinColumns = @JoinColumn(name = "dresseur_id")
  )
  private Set<Dresseurs> dresseurs = new HashSet<>();

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "boite_type",
          joinColumns = @JoinColumn(name = "boite_id"),
          inverseJoinColumns = @JoinColumn(name = "type_id")
  )
  private Set<Types> types = new HashSet<>();

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "boite_sexe",
          joinColumns = @JoinColumn(name = "boite_id"),
          inverseJoinColumns = @JoinColumn(name = "sexe_id")
  )
  private Set<Sexe> sexes = new HashSet<>();

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "boite_nature",
          joinColumns = @JoinColumn(name = "boite_id"),
          inverseJoinColumns = @JoinColumn(name = "nature_id")
  )
  private Set<Natures> natures = new HashSet<>();

  @JsonIgnore
  @ManyToMany
  @JoinTable(
          name = "boite_pokeball",
          joinColumns = @JoinColumn(name = "boite_id"),
          inverseJoinColumns = @JoinColumn(name = "pokeball_id")
  )
  private Set<Pokeballs> pokeballs = new HashSet<>();

  @Override
  public String toString() {
      return "Boites{" +
              "id=" + id +
              ", nom='" + nom + '\'' +
              ", dresseurs=" + dresseurs +
              ", types=" + types +
              ", sexes=" + sexes +
              ", natures=" + natures +
              ", pokeballs=" + pokeballs +
              '}';
  }
}
