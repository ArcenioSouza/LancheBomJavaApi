package br.com.lanchebom.models.dto.request;

import br.com.lanchebom.models.entity.Lanche;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class LancheRequestDto {
    @NotNull @NotEmpty @Length(min = 2)
    private final String nome;
    @NotNull @DecimalMin("0.1")
    private final BigDecimal preco;

    public LancheRequestDto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public LancheRequestDto(Lanche lanche) {
        this.nome = lanche.getNome();
        this.preco = lanche.getPreco();
    }

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }


}
