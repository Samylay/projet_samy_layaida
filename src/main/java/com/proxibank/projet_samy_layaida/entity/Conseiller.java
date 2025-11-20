package com.proxibank.projet_samy_layaida.entity;

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
    @JoinColumn(name = "agence_id", nullable = false)
    private Agence agence;

    @OneToMany(mappedBy = "conseiller", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Client> clients = new ArrayList<>();

    public boolean canAddClient() {
        return this.clients.size() < 10;
    }
    public void addClient(Client client) {
        this.clients.add(client);
    }
    public void removeClient(Client client) {
        this.clients.remove(client);
    }
}