package br.com.agilles.medidascautelares.usuario;

import br.com.agilles.medidascautelares.endereco.Endereco;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 * Created by jille on 17/10/2016.
 */
@Named
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioDao dao;
    
    @Inject
    private Usuario usuario;

    @Inject
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void logar(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrar() {
        dao.registrarNovoUsuario(usuario);
        
        return "";
        
    }

}
