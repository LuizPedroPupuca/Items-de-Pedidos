package br.com.zup.edu.pedidos.repository;

import br.com.zup.edu.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
