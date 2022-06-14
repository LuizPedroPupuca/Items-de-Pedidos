package br.com.zup.edu.pedidos.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    private BigDecimal valor;

    public Produto(String titulo, BigDecimal valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    @Deprecated
    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
