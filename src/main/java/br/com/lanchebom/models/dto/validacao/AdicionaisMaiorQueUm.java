package br.com.lanchebom.models.dto.validacao;

import br.com.lanchebom.interfaces.Desconto;
import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.entity.Pedido;

import java.math.BigDecimal;

public class AdicionaisMaiorQueUm implements Desconto {
    @Override
    public BigDecimal calcular(BigDecimal valorTotal) {
        BigDecimal desconto = valorTotal.multiply(new BigDecimal("0.2"));
        return valorTotal.subtract(desconto);
    }
}
