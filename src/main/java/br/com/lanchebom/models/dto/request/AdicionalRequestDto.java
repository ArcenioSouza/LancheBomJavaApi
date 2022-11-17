package br.com.lanchebom.models.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AdicionalRequestDto {

    @NotNull @NotEmpty @Length(min = 2)
    private final String nome;
    @NotNull @DecimalMin("0.1")
    private final BigDecimal preco;

    public AdicionalRequestDto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
