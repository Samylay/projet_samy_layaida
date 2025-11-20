package com.proxibank.projet_samy_layaida.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "compte_bancaire")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@Getter
@Setter
public abstract class CompteBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCompte;
    private double solde;
    private Date dateOuverture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;

    public abstract boolean debiter(double montant);

    public void crediter(double montant) {
        this.solde += montant;
    }

//    public void faireVirement(CompteBancaire compteCible, double montant) throws Exception {
//        if (this.debiter(montant)) {
//            compteCible.crediter(montant);
//        } else {
//            throw new Exception("Virement impossible: Solde insuffisant ou découvert dépassé.");
//        }
//    }
}