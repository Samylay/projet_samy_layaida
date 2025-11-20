package com.proxibank.projet_samy_layaida.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
public class Agence {
    @Id
    @Column(length = 5)
    private String id;

    private LocalDate dateCreation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerant_id")
    private Gerant gerant;

    public Agence(String id, Gerant gerant) {
        this.id = id;
        this.gerant = gerant;
        this.dateCreation = LocalDate.now();
    }

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conseiller> conseillers = new ArrayList<>();
}