package br.com.lanchebom.controllers;

import br.com.lanchebom.models.dto.request.AdicionalRequestDto;
import br.com.lanchebom.models.dto.response.AdicionalResponseDto;
import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.services.AdicionalService;
import br.com.lanchebom.utils.GerarUri;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/adicional")
public class AdicionaisController {
    private final AdicionalService adicionalService;

    public AdicionaisController(AdicionalService adicionalService) {
        this.adicionalService = adicionalService;
    }

    @Operation(
            summary = "Salva um adicional no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @PostMapping
    public ResponseEntity<AdicionalResponseDto> post(@RequestBody @Valid AdicionalRequestDto adicionalRequestDto){
        Adicional adicional = adicionalService.save(adicionalRequestDto);
        URI uri = new GerarUri("/api/v1/adicional/{id}", adicional.getId()).build();
        return ResponseEntity.created(uri).body(new AdicionalResponseDto(adicional));
    }

    @Operation(
            summary = "Busca os adicionais do banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping
    public ResponseEntity<List<AdicionalResponseDto>> get(){
        List<Adicional> listaAdicionais = adicionalService.getAll();
        return ResponseEntity.ok(AdicionalResponseDto.buildList(listaAdicionais));
    }

    @Operation(
            summary = "Busca um adicional do banco de dados por id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<AdicionalResponseDto> getById(@PathVariable Long id){
        Adicional adicional = adicionalService.getOne(id);
        return ResponseEntity.ok(new AdicionalResponseDto(adicional));
    }

    @Operation(
            summary = "Atualiza um adicional no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AdicionalResponseDto> put(@RequestBody @Valid AdicionalRequestDto adicionalRequestDto,
                                                    @PathVariable Long id){
        Adicional adicional = adicionalService.update(id, adicionalRequestDto);
        return ResponseEntity.ok(new AdicionalResponseDto(adicional));
    }

    @Operation(
            summary = "Exclui um adicional no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable Long id){
        adicionalService.delete(id);
        return ResponseEntity.ok("Registro excluido com sucesso");
    }

}
