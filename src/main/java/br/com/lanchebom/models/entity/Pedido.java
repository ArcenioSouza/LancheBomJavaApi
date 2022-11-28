package br.com.lanchebom.models.entity;

import javax.persistence.*;
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

    public Pedido(Lanche lanche, List<Adicional> adicionais) {
        this.lanche = lanche;
        this.adicionais = adicionais;
    }

    public Pedido() {

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

    public void setListaAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
    }
}
