package br.com.zup.edu.pedidos;

import javax.persistence.*;

@Entity
public class ItemDePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    @ManyToOne
    private Pedido pedido;

    public ItemDePedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItemDePedido() {
    }

    public Long getId() {
        return id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
