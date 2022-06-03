package br.com.zup.edu.pedidos;

import javax.validation.constraints.NotBlank;

public class ProdutoRequest {

    @NotBlank
    private String titulo;

    public ProdutoRequest(String titulo) {
        this.titulo = titulo;
    }

    public ProdutoRequest() {
    }

    public String getTitulo() {
        return titulo;
    }


    public Produto toModel() {
        return new Produto(titulo);
    }
}
