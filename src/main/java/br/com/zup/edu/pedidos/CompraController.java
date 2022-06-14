package br.com.zup.edu.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CompraController {

   private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/clientes/{idCliente}/produtos/{idProduto}")
     ResponseEntity<Void> cadastraPedido(@RequestBody @Valid ItemDePedidoRequest itensDePedidoRequest
            , @PathVariable Long idCliente,@PathVariable Long idProduto, UriComponentsBuilder uri){
        return compraService.cadastraPedido(itensDePedidoRequest, idCliente, idProduto, uri);
    }

    @PostMapping("/clientes/{idCliente}/pedidos/{idPedido}/produtos/{idProduto}")
    ResponseEntity<Void> atuallizaPedido(@RequestBody @Valid ItemDePedidoRequest itensDePedidoRequest
            , @PathVariable Long idCliente,@PathVariable Long idProduto, @PathVariable Long idPedido, UriComponentsBuilder uri){
        return compraService.atualizaPedido(itensDePedidoRequest, idCliente, idProduto, idPedido, uri);
    }

    @PatchMapping("/clientes/{idCliente}/pedidos/{idPedido}")
    ResponseEntity<Void> finalizaCompra(@PathVariable Long idCliente,@PathVariable Long idPedido){
        return compraService.encerraCompra(idCliente, idPedido);
    }
}
