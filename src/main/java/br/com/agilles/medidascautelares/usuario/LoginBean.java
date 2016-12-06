package br.com.agilles.medidascautelares.usuario;

import org.primefaces.context.RequestContext;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class LoginBean implements Serializable {

    @Inject
    private Usuario usuario;
    @Inject
    private UsuarioDao dao;
    @Inject
    private UsuarioBean bean;

    public String efetuarLogin() {
        boolean usuarioExiste = dao.existe(usuario);
        if (usuarioExiste) {
            usuario = dao.completarUsuarioNoLogin(usuario);
            if (usuario.isAtivo()) {
                bean.logar(usuario);
                return "home?faces-redirect=true";

            } else {
                RequestContext contexto = RequestContext.getCurrentInstance();
                contexto.execute("swal('Quase lá!', 'Você iniciou seu registro, mas ainda não foi liberado seu acesso', 'warning')");
            }

        } else {
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Erro', 'Funcional ou senha não confere', 'error')");

        }
        return "";

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
