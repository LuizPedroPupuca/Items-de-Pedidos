package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.model.ItemDePedido;
import br.com.zup.edu.pedidos.model.Produto;

import javax.validation.constraints.NotNull;

public class ItemDePedidoRequest {

    @NotNull
    private Integer quantidade;

    public ItemDePedidoRequest(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ItemDePedidoRequest() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemDePedido toModel(Produto produto){
        return new ItemDePedido(produto, quantidade);
    }
}
