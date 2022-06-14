package br.com.zup.edu.pedidos.dto;

import br.com.zup.edu.pedidos.model.Endereco;
import br.com.zup.edu.pedidos.model.Lougradouro;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {

    @NotNull
    private Lougradouro lougradouro;

    @NotBlank
    private String endereco;

    @NotBlank
    private String cep;

    private String complemento;

    public EnderecoRequest(Lougradouro lougradouro, String endereco, String cep, String complemento) {
        this.lougradouro = lougradouro;
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Lougradouro getLougradouro() {
        return lougradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco toModel() {
        return new Endereco(lougradouro, endereco, cep, complemento);
    }
}
