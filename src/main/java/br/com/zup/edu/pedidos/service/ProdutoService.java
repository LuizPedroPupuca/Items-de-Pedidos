package br.com.zup.edu.pedidos.service;

import br.com.zup.edu.pedidos.dto.ProdutoRequest;
import br.com.zup.edu.pedidos.model.Produto;
import br.com.zup.edu.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity<Void> salva(ProdutoRequest produtoRequest, UriComponentsBuilder uri) {

        if(produtoRepository.existsByTitulo(produtoRequest.getTitulo())){
            return ResponseEntity.unprocessableEntity().build();
        }
        Produto produto = produtoRequest.toModel();
        produtoRepository.save(produto);

        URI location = uri.path("/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
