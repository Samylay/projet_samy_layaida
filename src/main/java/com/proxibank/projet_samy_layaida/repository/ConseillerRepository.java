package com.proxibank.projet_samy_layaida.repository;

import com.proxibank.projet_samy_layaida.entity.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {
}