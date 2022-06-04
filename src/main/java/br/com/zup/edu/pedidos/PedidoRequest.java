package br.com.zup.edu.pedidos;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoRequest {

    @NotBlank
    private String numero;

    @NotNull
    private BigDecimal total;

    @NotNull
    private ItemDePedidoRequest item;

    public Pedido toModel(Produto produto) {
        ItemDePedido itemDePedido = item.toModel(produto);
        Pedido pedido = new Pedido(numero, total, itemDePedido);
        pedido.adicionaPedido(itemDePedido);
        return pedido;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public ItemDePedidoRequest getItem() {
        return item;
    }
}
