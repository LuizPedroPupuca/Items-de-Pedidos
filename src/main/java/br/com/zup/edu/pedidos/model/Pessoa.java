package br.com.zup.edu.pedidos.model;

import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
public class Pessoa {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Embedded
    private Endereco endereco;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento, Sexo sexo, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public Pessoa() {
    }
}
