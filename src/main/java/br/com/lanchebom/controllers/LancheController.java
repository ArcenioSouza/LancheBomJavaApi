package br.com.lanchebom.controllers;

import br.com.lanchebom.models.dto.request.LancheRequestDto;
import br.com.lanchebom.models.dto.response.LancheResponseDto;
import br.com.lanchebom.models.entity.Lanche;
import br.com.lanchebom.models.repository.LancheRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "LancheBom_API",
                description = "Api de gerenciamento de pedidos de uma lanchone",
                version = "1",
                contact = @Contact(name = "Arcenio Souza", email = "arcenio_neto@icloud.com")
        )
)
@RestController
@RequestMapping("/api/v1/lanche")
public class LancheController {

    @Autowired
    private LancheRepository lancheRepository;
    @Operation(
            description = "Salva um lanche no banco de dados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Registro criado com sucesso."),
                    @ApiResponse(responseCode = "500", description = "Problemas com a requisição")
            }

    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancheResponseDto post(@RequestBody LancheRequestDto lancheRequestDto) {
        Lanche lanche = lancheRepository.save(new Lanche(lancheRequestDto.getNome(), lancheRequestDto.getPreco()));
        return new LancheResponseDto(lanche);
    }

    @Operation(
            description = "Busca os lanches do banco de dados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não foi encontrado registros no banco")
            }

    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LancheResponseDto> get() {
        List<Lanche> listaLanches = lancheRepository.findAll();
        return LancheResponseDto.buildList(listaLanches);
    }
}
