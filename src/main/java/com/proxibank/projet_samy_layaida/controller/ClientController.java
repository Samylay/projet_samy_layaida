package com.proxibank.projet_samy_layaida.controller;

import com.proxibank.projet_samy_layaida.entity.Client;
import com.proxibank.projet_samy_layaida.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(
            @RequestParam Long conseillerId,
            @RequestBody Client client) {

        try {
            Client createdClient = clientService.createClient(conseillerId, client);
            return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {

        return clientService.getClientById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long clientId,
            @RequestBody Client clientDetails) {
        try {
            Client updatedClient = clientService.updateClient(clientId, clientDetails);
            return ResponseEntity.ok(updatedClient);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
        try {
            clientService.deleteClient(clientId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}