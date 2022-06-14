package br.com.zup.edu.pedidos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Endereco {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Lougradouro lougradouro;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cep;

    private String complemento;

    public Endereco(Lougradouro lougradouro, String endereco, String cep, String complemento) {
        this.lougradouro = lougradouro;
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Endereco() {
    }
}
