package com.deliverit.desafio_tecnico.conta;

import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarRequestDTO;
import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarResponseDTO;

import java.util.List;

public interface ContaPagarService {

    public ContaPagarResponseDTO criar(ContaPagarRequestDTO contaPagarRequestDTO);

    public List<ContaPagarResponseDTO> listar();
}
