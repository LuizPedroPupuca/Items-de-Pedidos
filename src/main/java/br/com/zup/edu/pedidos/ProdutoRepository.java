package br.com.zup.edu.pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByTitulo(String titulo);
}
