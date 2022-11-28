package br.com.lanchebom.models.dto.validacao;

import br.com.lanchebom.interfaces.Desconto;

import java.math.BigDecimal;

public class AdicionaisIgualUm implements Desconto {
    @Override
    public BigDecimal calcular(BigDecimal valorTotal) {
        BigDecimal desconto = valorTotal.multiply(new BigDecimal("0.1"));
        return valorTotal.subtract(desconto);
    }
}
