package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.model.ItemDePedido;
import br.com.zup.edu.pedidos.model.Pedido;
import br.com.zup.edu.pedidos.model.Produto;

import javax.validation.constraints.NotNull;

public class PedidoRequest {


    @NotNull
    private ItemDePedidoRequest item;

    public Pedido toModel(Produto produto) {
        ItemDePedido itemDePedido = item.toModel(produto);
        Pedido pedido = new Pedido();
        pedido.adicionaItensDePedido(itemDePedido);
        return pedido;
    }

    public ItemDePedidoRequest getItem() {
        return item;
    }
}
