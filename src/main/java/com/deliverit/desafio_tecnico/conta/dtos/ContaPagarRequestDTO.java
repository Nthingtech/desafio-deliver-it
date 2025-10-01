package com.deliverit.desafio_tecnico.conta.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContaPagarRequestDTO(
                                   @NotBlank(message = "Nome é obrigatório")
                                   String nome,

                                   @NotNull(message = "Valor original é obrigatório")
                                   @Positive(message = "Valor original deve ser positivo")
                                   BigDecimal valorOriginal,

                                   @NotNull(message = "Data de vencimento é obrigatório")
                                   LocalDate dataVencimento,

                                   @NotNull(message = "Data de pagamento é obrigatória")
                                   LocalDate dataPagamento
) {
}
