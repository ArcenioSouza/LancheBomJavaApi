package br.com.lanchebom.services;

import br.com.lanchebom.models.dto.request.PedidoRequestDto;
import br.com.lanchebom.models.dto.response.PedidoResponseDto;
import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.entity.Pedido;
import br.com.lanchebom.models.repository.AdicionalRepository;
import br.com.lanchebom.models.repository.LancheRepository;
import br.com.lanchebom.models.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final LancheRepository lancheRepository;
    private final AdicionalRepository adicionalRepository;

    public PedidoService(PedidoRepository pedidoRepository, LancheRepository lancheRepository, AdicionalRepository adicionalRepository) {
        this.pedidoRepository = pedidoRepository;
        this.lancheRepository = lancheRepository;
        this.adicionalRepository = adicionalRepository;
    }

    public PedidoResponseDto salvar(PedidoRequestDto pedidoRequestDto){
        List<Adicional> adicionais = new ArrayList<>();
        pedidoRequestDto.idAdicionais().forEach(idAdicional -> adicionais.add(adicionalRepository.findById(idAdicional).get()));
        Lanche lanche = lancheRepository.findById(pedidoRequestDto.idLanche()).get();
        Pedido response = pedidoRepository.save(new Pedido(lanche, adicionais));
        return new PedidoResponseDto(response);
    }
}
