package br.com.agilles.medidascautelares.endereco ;

import java.io.Serializable;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}
