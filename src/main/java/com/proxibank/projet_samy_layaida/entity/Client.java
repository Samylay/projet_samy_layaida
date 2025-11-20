package com.proxibank.projet_samy_layaida.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conseiller_id", nullable = false)
    private Conseiller conseiller;

     @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
     private CompteCourant compteCourant;

     @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
     private CompteEpargne compteEpargne;
}