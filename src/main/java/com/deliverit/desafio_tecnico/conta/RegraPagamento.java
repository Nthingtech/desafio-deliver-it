package com.deliverit.desafio_tecnico.conta;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

public enum RegraPagamento {

    ATE_3_DIAS(1, 3, new BigDecimal("2.0"), new BigDecimal("0.1")),
    SUPERIOR_3_DIAS(4, 5, new BigDecimal("3.0"), new BigDecimal("0.2")),
    SUPERIOR_5_DIAS(6, Integer.MAX_VALUE, new BigDecimal("5.0"), new BigDecimal("0.3"));


    private static final int MONETARY_SCALE = 2;
    private static final int INTERMEDIATE_CALCULATION_SCALE = 4;
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    private final int diasMinimo;
    private final int diasMaximo;
    private final BigDecimal percentualMulta;
    private final BigDecimal percentualJurosDia;

    RegraPagamento(int diasMinimo, int diasMaximo, BigDecimal percentualMulta, BigDecimal percentualJurosDia) {
        this.diasMinimo = diasMinimo;
        this.diasMaximo = diasMaximo;
        this.percentualMulta = percentualMulta;
        this.percentualJurosDia = percentualJurosDia;
    }

    public static RegraPagamento regraPorDiasAtraso(int diasAtraso) {
        if (diasAtraso <= 0) {
            return null;
        }

        return Stream.of(values())
                .filter(regra -> diasAtraso >= regra.diasMinimo && diasAtraso <= regra.diasMaximo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma regra de cáculo para " + diasAtraso + " dias de atraso"));
    }

    public BigDecimal calcularValorCorrigido(BigDecimal valorOriginal, int diasAtraso) {
        if (diasAtraso <= 0 || valorOriginal == null) {
            return valorOriginal;
        }


        BigDecimal multa = valorOriginal
                .multiply(percentualMulta)
                .divide(ONE_HUNDRED, MONETARY_SCALE, RoundingMode.HALF_UP);


        BigDecimal juros = valorOriginal
                .multiply(percentualJurosDia)
                .divide(ONE_HUNDRED, INTERMEDIATE_CALCULATION_SCALE, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(diasAtraso));


        return valorOriginal
                .add(multa)
                .add(juros)
                .setScale(MONETARY_SCALE, RoundingMode.HALF_UP);
    }

    public String getDescricao() {
        return String.format("%s%% multa + %s%% juros/dia",
                percentualMulta.stripTrailingZeros().toPlainString(),
                percentualJurosDia.stripTrailingZeros().toPlainString());
    }

    public BigDecimal getPercentualMulta() {
        return percentualMulta;
    }

    public BigDecimal getPercentualJurosDia() {
        return percentualJurosDia;
    }

    public int getDiasMinimo() {
        return diasMinimo;
    }

    public int getDiasMaximo() {
        return diasMaximo;
    }
}
