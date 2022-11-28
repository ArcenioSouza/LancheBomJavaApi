package br.com.lanchebom.models.dto.response;

import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.entity.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record PedidoResponseDto(Long id, Lanche lanche, List<Adicional> adicionais, BigDecimal valorTotal) {

    public PedidoResponseDto(Pedido pedido){
        this(pedido.getId(), pedido.getLanche(), pedido.getAdicionais(), pedido.getValorTotal());
    }

    public static List<PedidoResponseDto> buildList(List<Pedido> pedidos){
        return pedidos.stream().map(PedidoResponseDto::new).collect(Collectors.toList());
    }
}
