package br.com.zup.edu.pedidos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private BigDecimal total;

    @OneToMany(mappedBy = "pedido", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ItemDePedido> itens = new ArrayList<>();;

    public Pedido(String numero, BigDecimal total, ItemDePedido item) {
        this.numero = numero;
        this.total = total;
        itens.add(item);
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void adicionaPedido() {
        itens.stream().forEach(itemDePedido -> itemDePedido.setPedido(this));
    }
}
