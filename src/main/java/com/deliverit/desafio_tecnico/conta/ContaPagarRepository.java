package com.deliverit.desafio_tecnico.conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPagarRepository extends JpaRepository<ContaPagar, Long> {
}
