package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.model.ItemDePedido;
import br.com.zup.edu.pedidos.model.Produto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class ItemDePedidoResponse {

    private Produto produto;

    private Integer quantidade;

    public ItemDePedidoResponse(ItemDePedido item) {
        this.produto = item.getProduto();
        this.quantidade = item.getQuantidade();
    }

    public ItemDePedidoResponse() {
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
