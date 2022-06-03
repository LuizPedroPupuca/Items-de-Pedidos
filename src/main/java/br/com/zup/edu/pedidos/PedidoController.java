package br.com.zup.edu.pedidos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;


    public PedidoController(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/{idProduto}")
     ResponseEntity<Void> cadastra(@RequestBody @Valid PedidoRequest pedidoRequest, @PathVariable Long idProduto, UriComponentsBuilder uri){
        Produto produto = produtoRepository.findById(idProduto).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto inexistente"));
        Pedido pedido = pedidoRequest.toModel(produto);
        pedidoRepository.save(pedido);

        URI location = uri.path("/{id}").buildAndExpand(pedido.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{idPedido}")
    ResponseEntity<Void> remove(@PathVariable Long idPedido){
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido inexistente"));
        pedidoRepository.delete(pedido);

        return ResponseEntity.noContent().build();
    }
}
