package com.deliverit.desafio_tecnico.conta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "contas_pg")
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 50, message = "Máximo de 50 caracteres")
    @Column(nullable = false, length = 50)
    private String nome;

    @NotNull(message = "Valor original é obrigatório")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal valorOriginal;

    @NotNull(message = "Data de pagamento é obrigatória.")
    @Column(nullable = false)
    private LocalDate dataPagamento;

    @Column(nullable = false)
    private Integer diasAtraso;

    @Column(precision = 19, scale = 2)
    private BigDecimal valorCorrigido;

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private RegraPagamento regraAplicada;

    @Column(length = 110)
    private String descricaoRegra;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public BigDecimal getValorCorrigido() {
        return valorCorrigido;
    }

    public void setValorCorrigido(BigDecimal valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public RegraPagamento getRegraAplicada() {
        return regraAplicada;
    }

    public void setRegraAplicada(RegraPagamento regraAplicada) {
        this.regraAplicada = regraAplicada;
    }

    public String getDescricaoRegra() {
        return descricaoRegra;
    }

    public void setDescricaoRegra(String descricaoRegra) {
        this.descricaoRegra = descricaoRegra;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaPagar that = (ContaPagar) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
