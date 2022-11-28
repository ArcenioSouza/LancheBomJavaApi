package br.com.lanchebom.models.entity;

import br.com.lanchebom.interfaces.Desconto;
import br.com.lanchebom.models.dto.validacao.AdicionaisIgualUm;
import br.com.lanchebom.models.dto.validacao.AdicionaisIgualZero;
import br.com.lanchebom.models.dto.validacao.AdicionaisMaiorQueUm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Lanche lanche;
    @ManyToMany
    @JoinTable(
            name = "pedido_adicional",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "adicional_id")
    )
    private List<Adicional> adicionais;
    private BigDecimal valorTotal;

    public Pedido(Lanche lanche, List<Adicional> adicionais) {
        this.lanche = lanche;
        this.adicionais = adicionais;
        this.calculaValorPedido();
    }

    public Pedido() {

    }

    public void calculaValorPedido(){
        BigDecimal totalAdicional = this.adicionais.stream().map(Adicional::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        BigDecimal total = totalAdicional.add(lanche.getPreco());

        //Usar o chain of responsibility aqui!!!
        switch (this.adicionais.size()) {
            case 0 -> this.valorTotal = calcularValorComDesconto(total, new AdicionaisIgualZero());
            case 1 -> this.valorTotal = calcularValorComDesconto(total, new AdicionaisIgualUm());
            default -> this.valorTotal = calcularValorComDesconto(total, new AdicionaisMaiorQueUm());
        }
    }
    public BigDecimal calcularValorComDesconto(BigDecimal valorTotal, Desconto desconto){
        return desconto.calcular(valorTotal);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public void setLanche(Lanche lanche) {
        this.lanche = lanche;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
