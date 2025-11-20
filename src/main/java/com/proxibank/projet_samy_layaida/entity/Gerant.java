package com.proxibank.projet_samy_layaida.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("GERANT")
@NoArgsConstructor
@Getter
@Setter
public class Gerant extends Employe {

    @OneToOne(mappedBy = "gerant")
    private Agence agence;
}