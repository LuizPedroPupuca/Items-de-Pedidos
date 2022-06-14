package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    private String titulo;

    @NotNull
    private BigDecimal valor;

    public ProdutoRequest(String titulo, BigDecimal valor) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public ProdutoRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Produto toModel() {
        return new Produto(titulo, valor);
    }
}
