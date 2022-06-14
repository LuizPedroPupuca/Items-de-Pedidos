package br.com.zup.edu.pedidos.repository;

import br.com.zup.edu.pedidos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
