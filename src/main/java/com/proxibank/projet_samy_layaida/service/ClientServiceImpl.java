package com.proxibank.projet_samy_layaida.service;

import com.proxibank.projet_samy_layaida.entity.Client;
import com.proxibank.projet_samy_layaida.entity.Conseiller;
import com.proxibank.projet_samy_layaida.repository.ClientRepository;
import com.proxibank.projet_samy_layaida.repository.ConseillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ConseillerRepository conseillerRepository;

    @Override
    public Client createClient(Long conseillerId, Client newClient) {
        Conseiller conseiller = conseillerRepository.findById(conseillerId)
                .orElseThrow(() -> new EntityNotFoundException("Conseiller non trouvé avec l'ID: " + conseillerId));

        if (!conseiller.canAddClient()) {
            throw new RuntimeException("Limite de clients atteinte (max 10) pour le conseiller.");
        }

        newClient.setConseiller(conseiller);
        conseiller.getClients().add(newClient);

        return clientRepository.save(newClient);
    }

    @Override
    public Optional<Client> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public Client updateClient(Long clientId, Client clientDetails) {
        Client client = getClientById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client non trouvé avec l'ID: " + clientId));

        client.setNom(clientDetails.getNom());
        client.setPrenom(clientDetails.getPrenom());
        client.setAdresse(clientDetails.getAdresse());
        client.setTelephone(clientDetails.getTelephone());

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = getClientById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client non trouvé avec l'ID: " + clientId));
        clientRepository.delete(client);
    }
}