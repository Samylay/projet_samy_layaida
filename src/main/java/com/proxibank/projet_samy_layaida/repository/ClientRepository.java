package com.proxibank.projet_samy_layaida.repository;

import com.proxibank.projet_samy_layaida.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByConseillerId(Long conseillerId);
}