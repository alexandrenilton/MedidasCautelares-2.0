package br.com.agilles.medidascautelares.endereco ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jille on 17/10/2016.
 */
@Named
@RequestScoped
public class EnderecoBean implements Serializable {

    @Inject
    private Endereco endereco;
    @Inject
    private EnderecoDao dao;

    private List<Endereco> enderecosPorBairro = new ArrayList<>();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



    public List<Endereco> getEnderecosPorBairro() {
        return enderecosPorBairro;
    }

    public void setEnderecosPorBairro(List<Endereco> enderecosPorBairro) {
        this.enderecosPorBairro = enderecosPorBairro;
    }
}
