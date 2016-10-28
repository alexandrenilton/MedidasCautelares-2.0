package br.com.agilles.medidascautelares.usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;

/**
 * Created by jille on 17/10/2016.
 */
public class UsuarioDao implements Serializable {

    @Inject
    EntityManager manager;

    public boolean existe(Usuario usuario) {
        Query q = manager.createQuery("SELECT u from Usuario u where u.funcional = :pFuncional and u.senha = :pSenha")
                .setParameter("pFuncional", usuario.getFuncional()).setParameter("pSenha", usuario.getSenha());
        boolean encontrado = !q.getResultList().isEmpty();
        return encontrado;
    }

    public void registrarNovoUsuario(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
    }

    public Usuario completarUsuarioNoLogin(Usuario usuario) {
        TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM  Usuario u WHERE u.funcional = :funcional AND u.senha = :senha", Usuario.class);
        query.setParameter("funcional", usuario.getFuncional());
        query.setParameter("senha", usuario.getSenha());

        Usuario u = query.getSingleResult();
        return u;
    }

    public boolean validarEmailExistente(Usuario usuario) {
        boolean emailExistente = false;
        TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM  Usuario u WHERE u.email = :email", Usuario.class);
        query.setParameter("email", usuario.getEmail());
        
        return !query.getResultList().isEmpty();

    }
}
