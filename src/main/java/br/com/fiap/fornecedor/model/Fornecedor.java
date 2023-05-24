package br.com.fiap.fornecedor.model;

import jakarta.persistence.*;
import br.com.fiap.pessoa.model.Pessoa;

/**
 * Representa um fornecedor
 */
@Entity
@Table(name = "FORNECEDOR_CP3")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FORNECEDOR")
    @SequenceGenerator(name = "SQ_FORNECEDOR", sequenceName = "SQ_FORNECEDOR", allocationSize = 1)
    @Column(name = "ID_FORNECEDOR")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_FORNECEDOR_PESSOA", value = ConstraintMode.CONSTRAINT))
    private Pessoa pessoa;

    public Fornecedor() {
    }

    public Fornecedor(Long id, Pessoa pessoa) {
        this.id = id;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public Fornecedor setId(Long id) {
        this.id = id;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Fornecedor setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }


    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                '}';
    }
}
