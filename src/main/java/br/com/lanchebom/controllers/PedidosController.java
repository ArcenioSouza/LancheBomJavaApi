package br.com.lanchebom.controllers;

import br.com.lanchebom.models.dto.request.PedidoRequestDto;
import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.entity.Pedido;
import br.com.lanchebom.models.repository.AdicionalRepository;
import br.com.lanchebom.models.repository.LancheRepository;
import br.com.lanchebom.models.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidosController {

    private final PedidoRepository pedidoRepository;
    private final LancheRepository lancheRepository;
    private final AdicionalRepository adicionalRepository;

    public PedidosController(PedidoRepository pedidoRepository, LancheRepository lancheRepository, AdicionalRepository adicionalRepository) {
        this.pedidoRepository = pedidoRepository;
        this.lancheRepository = lancheRepository;
        this.adicionalRepository = adicionalRepository;
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@RequestBody PedidoRequestDto pedidoRequestDto){
        Pedido pedido = new Pedido();
        List<Adicional> adicionais = new ArrayList<>();
        pedidoRequestDto.idAdicionais().forEach(adicional -> {
            Adicional item = adicionalRepository.findById(adicional).get();
            adicionais.add(item);
        });
        Lanche lanche = lancheRepository.findById(pedidoRequestDto.idLanche()).get();
        pedido.setLanche(lanche);
        pedido.setListaAdicionais(adicionais);
        Pedido response = pedidoRepository.save(pedido);
        return ResponseEntity.ok(response);
    }
}
