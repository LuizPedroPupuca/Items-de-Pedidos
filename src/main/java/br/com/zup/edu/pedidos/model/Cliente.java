package br.com.zup.edu.pedidos.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Embedded
    private Pessoa pessoa;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;


    @Column(nullable = false)
    private LocalDateTime horaCadastro = LocalDateTime.now();

    public Cliente(String login, String senha, Pessoa pessoa) {
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public Pedido adicionaItemDePedido(ItemDePedido itemDePedido) {
        Pedido pedido = new Pedido(itemDePedido, this);
        pedidos.add(pedido);
        return pedido;
    }

    public void atualiza(ItemDePedido itemDePedido, Pedido pedido) {
        this.pedidos.stream().filter(p -> p.equals(pedido)).forEach(p -> p.adicionaItensDePedido(itemDePedido));
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void encerraStatus(Pedido pedido) {
        pedidos.stream().filter(p -> p.equals(pedido)).forEach(p -> p.setStatus(Status.ENCERRADO));
    }
}
