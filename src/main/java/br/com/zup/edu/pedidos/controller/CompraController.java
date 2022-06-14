package br.com.zup.edu.pedidos.controller;

import br.com.zup.edu.pedidos.service.CompraService;
import br.com.zup.edu.pedidos.dto.ItemDePedidoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

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

    @GetMapping("/{idCliente}")
    ResponseEntity<?> listaPedidosFinalizados(@PathVariable Long idCliente){
        return compraService.buscaPedidosFinalizados(idCliente);
    }
}
