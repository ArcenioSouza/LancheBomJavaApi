package br.com.lanchebom.interfaces;

import br.com.lanchebom.models.entity.Pedido;

import java.math.BigDecimal;

public interface Desconto {
    public BigDecimal calcular(BigDecimal valorTotal);
}
