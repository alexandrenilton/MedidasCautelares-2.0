package br.com.agilles.medidascautelares.pessoa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by jille on 04/11/2016.
 */
public class PessoaDao {
    @Inject
    EntityManager manager;

    public boolean gravarPessoa(Pessoa pessoa){
        boolean salvo = false;
        try{
            manager.getTransaction().begin();
            manager.persist(pessoa);
            manager.getTransaction().commit();
            salvo = true;
        }catch (Exception e){
            e.printStackTrace();
            salvo=false;
        }finally {
            manager.close();
        }

        return salvo;
    }

}

