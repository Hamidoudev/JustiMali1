package com.JustiMali.JustiMali1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeDemande;
    private String etat;

    @ManyToOne
    private Procureur procureur;

    @ManyToOne
    private Maire maire;

    @ManyToOne
    private Citoyen citoyen;
}
