package com.proxibank.projet_samy_layaida.service;

import com.proxibank.projet_samy_layaida.entity.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClientService {

    Client createClient(Long conseillerId, Client newClient);

    Optional<Client> getClientById(Long clientId);

    Client updateClient(Long clientId, Client clientDetails);

    void deleteClient(Long clientId);
}