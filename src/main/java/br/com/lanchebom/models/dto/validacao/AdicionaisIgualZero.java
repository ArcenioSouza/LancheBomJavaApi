package br.com.lanchebom.models.dto.validacao;

import br.com.lanchebom.interfaces.Desconto;
import br.com.lanchebom.models.entity.Pedido;

import java.math.BigDecimal;

public class AdicionaisIgualZero implements Desconto {
    @Override
    public BigDecimal calcular(BigDecimal valorTotal) {
        return valorTotal;
    }
}
