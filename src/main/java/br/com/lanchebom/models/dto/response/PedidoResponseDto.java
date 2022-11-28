package br.com.lanchebom.models.dto.response;

import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.entity.Pedido;

import java.util.List;

public record PedidoResponseDto(Long id, Lanche lanche, List<Adicional> adicionais) {

    public PedidoResponseDto(Pedido pedido){
        this(pedido.getId(), pedido.getLanche(), pedido.getAdicionais());
    }
}
