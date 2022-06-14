package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.model.ItemDePedido;
import br.com.zup.edu.pedidos.model.Pedido;
import br.com.zup.edu.pedidos.model.Status;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoResponse {


    private List<ItemDePedidoResponse> itens;

    private Status status = Status.ABERTO;

    public PedidoResponse(Pedido pedido) {
        this.itens = pedido.getItens().stream().map(ItemDePedidoResponse::new).collect(Collectors.toList());
        this.status = pedido.getStatus();
    }

    public PedidoResponse() {
    }

    public List<ItemDePedidoResponse> getItens() {
        return itens;
    }

    public Status getStatus() {
        return status;
    }


}
