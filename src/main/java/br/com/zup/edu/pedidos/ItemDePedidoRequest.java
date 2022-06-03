package br.com.zup.edu.pedidos;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

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
