package br.com.lanchebom.models.dto.request;

import java.util.List;

public record PedidoRequestDto(Long idLanche, List<Long> idAdicionais) {
}
