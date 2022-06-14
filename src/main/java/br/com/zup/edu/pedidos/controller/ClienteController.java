package br.com.zup.edu.pedidos.controller;

import br.com.zup.edu.pedidos.service.ClienteService;
import br.com.zup.edu.pedidos.model.Cliente;
import br.com.zup.edu.pedidos.repository.ClienteRepository;
import br.com.zup.edu.pedidos.dto.ClienteRequest;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteRequest request, UriComponentsBuilder uri){
        return clienteService.salva(request, uri);
    }
}
