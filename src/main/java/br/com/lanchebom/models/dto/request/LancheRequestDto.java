package br.com.lanchebom.models.dto.request;

import br.com.lanchebom.models.entity.Lanche;

import java.math.BigDecimal;

public class LancheRequestDto {
    private String nome;
    private BigDecimal preco;

    public LancheRequestDto() {
    }

    public LancheRequestDto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public LancheRequestDto(Lanche lanche) {
        this.nome = lanche.getNome();
        this.preco = lanche.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
