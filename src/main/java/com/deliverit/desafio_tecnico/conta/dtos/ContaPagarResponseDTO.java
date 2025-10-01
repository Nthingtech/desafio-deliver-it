package com.deliverit.desafio_tecnico.conta.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaPagarResponseDTO(
        String nome,
        BigDecimal valorOriginal,
        BigDecimal valorCorrigido,
        Integer quantidadeDiasAtraso,
        LocalDate dataPagamento
        ) {
}
