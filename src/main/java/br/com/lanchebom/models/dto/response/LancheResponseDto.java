package br.com.lanchebom.models.dto.response;

import br.com.lanchebom.models.dto.request.LancheRequestDto;
import br.com.lanchebom.models.entity.Lanche;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LancheResponseDto {
    private Long id;
    private String nome;
    private BigDecimal preco;

    public LancheResponseDto() {
    }

    public LancheResponseDto(Lanche lanche) {
        this.id = lanche.getId();
        this.nome = lanche.getNome();
        this.preco = lanche.getPreco();
    }

    public static List<LancheResponseDto> buildList(List<Lanche> lanches){
        return lanches.stream().map(LancheResponseDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
