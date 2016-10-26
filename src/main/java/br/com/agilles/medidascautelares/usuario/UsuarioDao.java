package br.com.agilles.medidascautelares.usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by jille on 17/10/2016.
 */
public class UsuarioDao {
    @Inject
    EntityManager manager;

    public boolean existe(Usuario usuario) {
        Query q = manager.createQuery("SELECT u from Usuario u where u.funcional = :pFuncional and u.senha = :pSenha")
                .setParameter("pFuncional", usuario.getFuncional()).setParameter("pSenha", usuario.getSenha());
        boolean encontrado = !q.getResultList().isEmpty();
        return  encontrado;
    }

    public void registrarNovoUsuario(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
    }
}
