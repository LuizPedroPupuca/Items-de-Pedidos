package br.com.zup.edu.pedidos;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @NotNull
    private PessoaRequest pessoa;

    public ClienteRequest(String login, String senha, PessoaRequest pessoa) {
        this.login = login;
        this.senha = senha;
        this.pessoa = pessoa;
    }

    public ClienteRequest() {
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public PessoaRequest getPessoa() {
        return pessoa;
    }

    public Cliente toModel() {
        return new Cliente(login, senha, pessoa.toModel());
    }
}
