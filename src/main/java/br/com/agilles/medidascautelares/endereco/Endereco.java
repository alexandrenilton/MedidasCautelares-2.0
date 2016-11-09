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
    private String cep;
    private String estado;

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

   public String getCep() {
        return cep;
    }
   

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
