package br.com.agilles.medidascautelares.usuario;

import br.com.agilles.medidascautelares.endereco.Endereco;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    private boolean emailExistente = false;

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
        if (emailExistente) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção", "Esse email já existe em nosso sistema, entre em contato com o administrador!");
            context.addMessage(null, msg);
            return "";
        } else {
            dao.registrarNovoUsuario(usuario);
            eventoRegistro.fire(usuario);
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Sucesso!', 'Um email será enviado para o endereço cadastrado, para concluir, siga as instruções do email!', 'success')");
            usuario = new Usuario();
            return "";
        }

    }

    public void validarEmail() {

        if (usuario.getEmail().length() > 1) {
            this.emailExistente = dao.validarEmailExistente(usuario);

            if (emailExistente) {
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "E-mail já cadastrado no sistema");
                context.addMessage(null, msg);
            }
        }
    }
}
