package br.com.fiap.venda.model;

import jakarta.persistence.*;
import br.com.fiap.carrinho.model.Carrinho;

import java.time.LocalDateTime;

@Entity
@Table(name = "VENDA_CP3")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VENDA")
    @SequenceGenerator(name = "SQ_VENDA", sequenceName = "SQ_VENDA", allocationSize = 1)
    @Column(name = "ID_VENDA")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARRINHO", referencedColumnName = "ID_CARRINHO",
            foreignKey = @ForeignKey(name = "FK_VENDA_CARRINHO", value = ConstraintMode.CONSTRAINT))
    private Carrinho carrinho;

    @Column(name = "DATA_VENDA")
    private LocalDateTime data;

    @Column(name = "VALOR_COMPRA")
    private double Valor;

    public Venda() {
    }

    public Venda(Long id, Carrinho carrinho, LocalDateTime data, double valor) {
        this.id = id;
        this.carrinho = carrinho;
        this.data = data;
        Valor = valor;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Venda setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
        return this;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Venda setData(LocalDateTime data) {
        this.data = data;
        return this;
    }

    public double getValor() {
        return Valor;
    }

    public Venda setValor(double valor) {
        Valor = valor;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Venda setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", carrinho=" + carrinho +
                ", data=" + data +
                ", Valor=" + Valor +
                '}';
    }
}
