package com.deliverit.desafio_tecnico.conta;

import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarRequestDTO;
import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarResponseDTO;
import com.deliverit.desafio_tecnico.conta.mappers.ContaPagarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaPagarServiceImpl implements ContaPagarService {

    private final ContaPagarRepository contaPagarRepository;
    private final ContaPagarMapper contaPagarMapper;

    public ContaPagarServiceImpl(ContaPagarRepository contaPagarRepository, ContaPagarMapper contaPagarMapper) {
        this.contaPagarRepository = contaPagarRepository;
        this.contaPagarMapper = contaPagarMapper;
    }

    @Override
    public ContaPagarResponseDTO criar(ContaPagarRequestDTO contaPagarRequestDTO) {
        ContaPagar contaPagar = contaPagarMapper.toEntity(contaPagarRequestDTO);
        ContaPagar conta = contaPagarRepository.save(contaPagar);
        return contaPagarMapper.toDto(conta);
    }

    @Override
    public List<ContaPagarResponseDTO> listar() {
        return contaPagarRepository.findAll().stream()
                .map(contaPagarMapper:: toDto)
                .collect(Collectors.toList());
    }
}
