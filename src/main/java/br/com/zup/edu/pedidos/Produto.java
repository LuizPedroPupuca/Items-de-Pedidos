package br.com.zup.edu.pedidos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    public Produto(String titulo) {
        this.titulo = titulo;
    }

    @Deprecated
    public Produto() {
    }

    public Long getId() {
        return id;
    }
}
