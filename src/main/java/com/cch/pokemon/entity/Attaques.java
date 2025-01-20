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
@Table(name = "attaques")
public class Attaques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_attaque")
    private String nomAttaque;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Types typeAttaque;

    public Attaques(String nomAttaque, Types type) {
        this.nomAttaque = nomAttaque;
        this.typeAttaque = type;
    }

    @Override
    public String toString() {
        return "attaques{" +
                "id=" + id +
                ", nomAttaque='" + nomAttaque + '\'' +
                ", type=" + typeAttaque +
                '}';
    }
}
