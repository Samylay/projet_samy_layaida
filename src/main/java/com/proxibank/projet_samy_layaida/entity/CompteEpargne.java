package com.proxibank.projet_samy_layaida.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@DiscriminatorValue("EPARGNE")
@NoArgsConstructor
@Getter
@Setter
public class CompteEpargne extends CompteBancaire {

    private final double TAUX_REMUNERATION = 0.03;

    public CompteEpargne(String numeroCompte, double solde, Date dateOuverture) {
        super.setNumeroCompte(numeroCompte);
        super.setSolde(solde);
        super.setDateOuverture(dateOuverture);
    }

    @Override
    public boolean debiter(double montant) {
        if (this.getSolde() - montant >= 0) {
            this.setSolde(this.getSolde() - montant);
            return true;
        }
        return false;
    }

    public void appliquerInterets() {
        this.setSolde(this.getSolde() * (1 + TAUX_REMUNERATION));
    }
}