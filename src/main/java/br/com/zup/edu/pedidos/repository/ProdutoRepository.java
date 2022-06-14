package br.com.zup.edu.pedidos.repository;

import br.com.zup.edu.pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByTitulo(String titulo);
}
