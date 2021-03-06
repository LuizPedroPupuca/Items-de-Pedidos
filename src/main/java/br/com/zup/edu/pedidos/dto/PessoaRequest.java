package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.dto.EnderecoRequest;
import br.com.zup.edu.pedidos.model.Pessoa;
import br.com.zup.edu.pedidos.model.Sexo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PessoaRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private LocalDate dataNascimento;

    @NotNull
    private Sexo sexo;

    @NotNull
    private EnderecoRequest endereco;

    public Pessoa toModel() {
        return new Pessoa(nome, cpf, dataNascimento, sexo, endereco.toModel());
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }
}
