package br.com.agilles.medidascautelares.pessoa;

import br.com.agilles.medidascautelares.endereco.Endereco;
import br.com.agilles.medidascautelares.endereco.EnderecoBean;
import br.com.agilles.medidascautelares.endereco.WebServiceEndereco;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by jille on 04/11/2016.
 */
@Named
@RequestScoped
public class PessoaBean implements Serializable{
    @Inject
    private Pessoa pessoa;
    @Inject
    private PessoaDao dao;

    @Inject
    private Endereco endereco;
    
    public void gravarPessoa(){
        
        if(dao.gravarPessoa(pessoa)){
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Sucesso!', 'Nova pessoa inserida no sistema!', 'success')");
            this.pessoa = new Pessoa();

        }else {
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Erro!', 'Algo aconteceu errado, tente novamente ou entre em contato com o Administrador do sistema!', 'error')");
        }
    }



    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco preencherCep(){
        this.endereco = WebServiceEndereco.getEnderecoPorCep(endereco.getCep());
        if (endereco !=null){
            pessoa.setEndereco(endereco);
        }
        return this.endereco;

    }
}

