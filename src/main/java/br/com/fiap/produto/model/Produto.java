package br.com.fiap.produto.model;

import jakarta.persistence.*;
import br.com.fiap.fornecedor.model.Fornecedor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUTO_CP3")
@DiscriminatorColumn(name="TP_PRODUTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    @Column(name = "ID_PRODUTO")
    Long id;
    @Column(name = "NOME_PRODUTO")
    private String nome;
    @Column(name = "DESCRICAO_PRODUTO")
    private String descricao;
    @Column(name = "PRECO_PRODUTO")
    private double preco;
    @Column(name = "FABRICACAO_PRODUTO")
    private LocalDateTime fabricacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR",
            foreignKey = @ForeignKey(name = "FK_PRODUTO_FORNECEDOR", value = ConstraintMode.CONSTRAINT))
    private Fornecedor fornecedor;


    public Produto() {
    }

    public Produto(String nome, String descricao, double preco, LocalDateTime fabricacao, Fornecedor fornecedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.fabricacao = fabricacao;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDateTime getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(LocalDateTime fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", fabricacao=" + fabricacao +
                ", fornecedor=" + fornecedor +
                '}';
    }
}
