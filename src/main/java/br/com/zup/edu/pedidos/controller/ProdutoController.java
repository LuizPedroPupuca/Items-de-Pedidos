package br.com.zup.edu.pedidos.controller;

import br.com.zup.edu.pedidos.model.Produto;
import br.com.zup.edu.pedidos.repository.ProdutoRepository;
import br.com.zup.edu.pedidos.dto.ProdutoRequest;
import br.com.zup.edu.pedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uri){
        return produtoService.salva(produtoRequest, uri);
    }
}
