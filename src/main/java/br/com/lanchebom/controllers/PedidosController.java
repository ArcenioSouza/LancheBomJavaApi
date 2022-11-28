package br.com.lanchebom.controllers;

import br.com.lanchebom.models.dto.request.PedidoRequestDto;
import br.com.lanchebom.models.dto.response.PedidoResponseDto;
import br.com.lanchebom.services.PedidoService;
import br.com.lanchebom.utils.GerarUri;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
