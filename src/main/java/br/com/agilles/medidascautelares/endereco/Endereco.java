package br.com.agilles.medidascautelares.endereco;

import br.com.agilles.medidascautelares.usuario.Usuario;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jille on 17/10/2016.
 */
@Entity
public class Endereco implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    
    private String logradouro;
    private String cidade;
    private String bairro;
    private int numero;

    @OneToOne
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    


}
