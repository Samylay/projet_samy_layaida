package com.proxibank.projet_samy_layaida.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@DiscriminatorValue("COURANT")
@NoArgsConstructor
public class CompteCourant extends CompteBancaire {

    private final double DECOUVERT_AUTORISE = 1000.0;

    public CompteCourant(String numeroCompte, double solde, Date dateOuverture) {
        super.setNumeroCompte(numeroCompte);
        super.setSolde(solde);
        super.setDateOuverture(dateOuverture);
    }

    @Override
    public boolean debiter(double montant) {
        if (this.getSolde() - montant >= -DECOUVERT_AUTORISE) {
            this.setSolde(this.getSolde() - montant);
            return true;
        }
        return false;
    }
}