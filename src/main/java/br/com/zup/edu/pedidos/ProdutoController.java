package br.com.zup.edu.pedidos;

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

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastra(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uri){
        Produto produto = produtoRequest.toModel();
        produtoRepository.save(produto);

        URI location = uri.path("/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
