package br.com.zup.edu.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class CompraService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    public ResponseEntity<Void> cadastraPedido(ItemDePedidoRequest itensDePedidoRequest, Long idCliente, Long idProduto, UriComponentsBuilder uri) {
        Cliente cliente = buscaCliente(idCliente);
        Produto produto = buscaProduto(idProduto);
        ItemDePedido item = itensDePedidoRequest.toModel(produto);
        Pedido pedido = cliente.adicionaItemDePedido(item);
        clienteRepository.flush();
        URI location = uri.path("/clientes/{idCliente}/pedidos/{idPedido}/itens/{idItens}/produto/{idProduto}")
                .buildAndExpand(cliente.getId(), pedido.getId(), item.getId(), produto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<Void> atualizaPedido(ItemDePedidoRequest itensDePedidoRequest, Long idCliente, Long idProduto, Long idPedido, UriComponentsBuilder uri) {
        Cliente cliente = buscaCliente(idCliente);
        Produto produto = buscaProduto(idProduto);
        Pedido pedido = buscaPedido(idPedido);
        ItemDePedido item = itensDePedidoRequest.toModel(produto);
        cliente.atualiza(item, pedido);
        clienteRepository.flush();
        URI location = uri.path("/clientes/{idCliente}/pedidos/{idPedido}/itens/{idItens}/produto/{idProduto}")
                .buildAndExpand(cliente.getId(), pedido.getId(), item.getId(), produto.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    public ResponseEntity<Void> encerraCompra(Long idCliente, Long idPedido) {
        Cliente cliente = buscaCliente(idCliente);
        Pedido pedido = buscaPedido(idPedido);
        cliente.encerraStatus(pedido);
        clienteRepository.save(cliente);
        return ResponseEntity.noContent().build();
    }

    private Pedido buscaPedido(Long idPedido) {
        return pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    private Cliente buscaCliente(Long idCliente){
        return  clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente inexistente"));
    }

    private Produto buscaProduto(Long idProduto){
        return produtoRepository.findById(idProduto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }


}
