package br.com.lanchebom.controllers;

import br.com.lanchebom.models.dto.request.LancheRequestDto;
import br.com.lanchebom.models.dto.response.LancheResponseDto;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.repository.LancheRepository;
import br.com.lanchebom.services.LancheService;
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
@RequestMapping("/api/v1/lanche")
public class LancheController {

    private final LancheRepository lancheRepository;
    private final LancheService lancheService;

    public LancheController(LancheRepository lancheRepository) {
        this.lancheService = new LancheService();
        this.lancheRepository = lancheRepository;
    }

    @Operation(
            summary = "Salva um lanche no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }
    )
    @PostMapping
    public ResponseEntity<LancheResponseDto> post(@RequestBody @Valid LancheRequestDto lancheRequestDto) {
        Lanche lanche = lancheService.save(lancheRepository, lancheRequestDto);
        GerarUri gerarUri = new GerarUri();
        URI uri = gerarUri.build("/api/v1/lanche/{id}", lanche.getId());
        return ResponseEntity.created(uri).body(new LancheResponseDto(lanche));
    }

    @Operation(
            summary = "Busca os lanches do banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }

    )
    @GetMapping
    public ResponseEntity<List<LancheResponseDto>> get() {
        List<Lanche> listaLanches = lancheService.getAll(lancheRepository);
        return ResponseEntity.ok(LancheResponseDto.buildList(listaLanches));
    }

    @Operation(
            summary = "Busca um lanche do banco de dados pelo seu id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }

    )
    @GetMapping("/{id}")
    public ResponseEntity<LancheResponseDto> getById(@PathVariable Long id) {
        Lanche lanche = lancheService.getOne(lancheRepository, id);
        return ResponseEntity.ok(new LancheResponseDto(lanche));
    }

    @Operation(
            summary = "Atualiza um lanche do banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }

    )
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LancheResponseDto> put(@PathVariable Long id, @RequestBody @Valid LancheRequestDto lancheRequestDto){
        Lanche lanche = lancheService.update(lancheRepository, id, lancheRequestDto);
        return ResponseEntity.ok(new LancheResponseDto(lanche));
    }

    @Operation(
            summary = "Exclui um lanche do banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(hidden = true)))
            }

    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        lancheService.delete(lancheRepository, id);
        return ResponseEntity.ok("Registro excluido com sucesso");
    }

}
