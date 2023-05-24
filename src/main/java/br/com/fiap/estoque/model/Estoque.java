package br.com.fiap.estoque.model;

import jakarta.persistence.*;
import br.com.fiap.produto.model.Produto;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

@Entity
@Table(name = "ESTOQUE_CP3")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTOQUE")
    @SequenceGenerator(name = "SQ_ESTOQUE", sequenceName = "SQ_ESTOQUE", allocationSize = 1)
    @Column(name = "ID_ESTOQUE")
    private Long id;

    //PRODUTO_ESTOCADO
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ESTOQUE_PRODUTO",
            joinColumns = @JoinColumn(name = "ESTOQUE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUTO_ID"))
    private Collection<Produto> produtos = new LinkedHashSet<>();

    @Column(name = "LOCAL_ESTOQUE")
    private String local;

    public Estoque() {
    }

    public Estoque(Collection<Produto> produtos, String local) {
        this.produtos = produtos;
        this.local = local;
    }

    public Collection<Produto> getProdutos() {
        return Collections.unmodifiableCollection(produtos);
    }

    public Estoque addProduto(Produto produto) {
        this.produtos.add(produto);
        return this;
    }

    public Estoque removeProduto(Produto produto) {
        this.produtos.remove(produto);
        return this;
    }

    public String getLocal() {
        return local;
    }

    public Estoque setLocal(String local) {
        this.local = local;
        return this;
    }


    @Override
    public String toString() {
        return "Estoque{" +
                "produtos=" + produtos +
                ", local='" + local + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Estoque setId(Long id) {
        this.id = id;
        return this;
    }
}
