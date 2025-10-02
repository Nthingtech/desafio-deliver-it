package com.deliverit.desafio_tecnico.conta;

import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarRequestDTO;
import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/contas-pagar")
@CrossOrigin(origins = "*")
public class ContaPagarController {

    private final ContaPagarService contaPagarService;

    public ContaPagarController(ContaPagarService service) {
        this.contaPagarService = service;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContaPagarResponseDTO criar(@Valid @RequestBody ContaPagarRequestDTO contaPagarRequestDTO){
        return contaPagarService.criar(contaPagarRequestDTO);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ContaPagarResponseDTO> listar() {
        return contaPagarService.listar();
    }
}
