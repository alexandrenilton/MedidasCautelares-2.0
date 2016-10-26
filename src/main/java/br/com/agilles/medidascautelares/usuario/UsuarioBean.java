package br.com.agilles.medidascautelares.usuario;

import br.com.agilles.medidascautelares.endereco.Endereco;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 * Created by jille on 17/10/2016.
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioDao dao;
    
    @Inject
    Event<Usuario> eventoRegistro;

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
        eventoRegistro.fire(usuario);
        RequestContext contexto = RequestContext.getCurrentInstance();
        contexto.execute("swal('Sucesso!', 'Um email será enviado para o endereço cadastrado, para concluir, siga as instruções do email!', 'success')");
        return ""   ;
    }

    
       

    

}
