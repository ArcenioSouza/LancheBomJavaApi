package br.com.lanchebom.models.dto.response;

import br.com.lanchebom.models.entity.Adicional;
import br.com.lanchebom.models.entity.Lanche;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class AdicionalResponseDto {

    private int id;
    private String nome;
    private BigDecimal preco;

    public AdicionalResponseDto(Adicional adicional) {
        this.id = adicional.getId();
        this.nome = adicional.getNome();
        this.preco = adicional.getPreco();
    }

    public static List<AdicionalResponseDto> buildList(List<Adicional> adicional){
        return adicional.stream().map(AdicionalResponseDto::new).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
