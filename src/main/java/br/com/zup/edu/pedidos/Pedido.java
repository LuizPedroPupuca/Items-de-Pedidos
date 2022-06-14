package br.com.zup.edu.pedidos;

import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal total = BigDecimal.valueOf(0);

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> itens = new ArrayList<>();;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ABERTO;

    @ManyToOne
    Cliente cliente;

    public Pedido(ItemDePedido item, Cliente cliente) {
        item.setPedido(this);
        this.itens.add(item);
        this.cliente = cliente;
        adicionaTotal(item);
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void adicionaItensDePedido(ItemDePedido itemDePedido) {
        itemDePedido.setPedido(this);
        itens.add(itemDePedido);
        adicionaTotal(itemDePedido);
    }

    private void adicionaTotal(ItemDePedido itemDePedido) {
        int qtde = itemDePedido.getQuantidade();
        BigDecimal valor = itemDePedido.getProduto().getValor();
        total = total.add(valor.multiply(BigDecimal.valueOf(qtde)));
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id.equals(pedido.id) && total.equals(pedido.total) && itens.equals(pedido.itens) && status == pedido.status && cliente.equals(pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, itens, status, cliente);
    }
}
