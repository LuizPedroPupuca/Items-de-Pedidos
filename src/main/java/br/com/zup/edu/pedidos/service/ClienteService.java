package br.com.zup.edu.pedidos.service;

import br.com.zup.edu.pedidos.dto.ClienteRequest;
import br.com.zup.edu.pedidos.model.Cliente;
import br.com.zup.edu.pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ResponseEntity<Void> salva(ClienteRequest request, UriComponentsBuilder uri) {
        Cliente cliente = request.toModel();
        repository.save(cliente);
        URI location = uri.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
