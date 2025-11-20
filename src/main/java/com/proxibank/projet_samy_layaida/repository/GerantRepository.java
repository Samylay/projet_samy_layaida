package com.proxibank.projet_samy_layaida.repository;

import com.proxibank.projet_samy_layaida.entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long> {
}