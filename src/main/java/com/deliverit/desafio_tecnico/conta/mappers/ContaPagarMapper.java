package com.deliverit.desafio_tecnico.conta.mappers;

import com.deliverit.desafio_tecnico.conta.ContaPagar;
import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarRequestDTO;
import com.deliverit.desafio_tecnico.conta.dtos.ContaPagarResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContaPagarMapper {

    ContaPagar toEntity(ContaPagarRequestDTO contaPagarRequestDTO);

    @Mapping(source = "diasAtraso", target = "quantidadeDiasAtraso")
    ContaPagarResponseDTO toDto(ContaPagar contaPagar);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ContaPagar partialUpdate(ContaPagarRequestDTO contaPagarRequestDTO, @MappingTarget ContaPagar contaPagar);
}