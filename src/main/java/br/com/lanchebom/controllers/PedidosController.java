package br.com.lanchebom.controllers;

import br.com.lanchebom.models.dto.request.PedidoRequestDto;
import br.com.lanchebom.models.dto.response.PedidoResponseDto;
import br.com.lanchebom.models.entity.Pedido;
import br.com.lanchebom.services.PedidoService;
import br.com.lanchebom.utils.GerarUri;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidosController {

    private final PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(
            summary = "Salva um pedido no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @PostMapping
    public ResponseEntity<PedidoResponseDto> post(@RequestBody PedidoRequestDto pedidoRequestDto){
        PedidoResponseDto response = pedidoService.salvar(pedidoRequestDto);
        URI uri = new GerarUri("apiv1/pedido/{id}", response.id()).build();
        return ResponseEntity.created(uri).body(response);
    }

    @Operation(
            summary = "Busca todos os pedidos no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema =
                    @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> getAll(){
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(PedidoResponseDto.buildList(pedidos));
    }
}
