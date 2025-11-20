package com.proxibank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CONSEILLER")
@NoArgsConstructor
@Getter
@Setter
public class Conseiller extends Employe {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(mappedBy = "conseiller", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Client> clients = new ArrayList<>();

    public boolean canAddClient() {
        return this.clients.size() < 10;
    }
}