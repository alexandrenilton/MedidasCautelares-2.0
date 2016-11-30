package br.com.agilles.medidascautelares.pessoa;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by jille on 04/11/2016.
 */
public class PessoaDao {

    @Inject
    EntityManager manager;

    public boolean gravarPessoa(Pessoa pessoa) {
        boolean salvo = false;
        try {
            manager.getTransaction().begin();
            manager.persist(pessoa);
            manager.getTransaction().commit();
            salvo = true;
        } catch (Exception e) {
            e.printStackTrace();
            salvo = false;
        } finally {
            manager.close();
        }

        return salvo;
    }

    public List<Pessoa> listarTodasPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Pessoa> q = builder.createQuery(Pessoa.class);
            Root<Pessoa> p = q.from(Pessoa.class);
            q.select(p);
            q.orderBy(builder.asc(p.get("nome")), builder.desc(p.get("nome")));
            TypedQuery<Pessoa> query = manager.createQuery(q);

            pessoas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return pessoas;

    }

    public boolean atualizarPessoa(Pessoa pessoaSelecionada) {
        boolean atualizado = false;
        try {
            manager.getTransaction().begin();
            manager.merge(pessoaSelecionada);
            manager.getTransaction().commit();
            atualizado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return atualizado;
    }

    public Pessoa buscarPorId(Long id) {
        Pessoa pessoa = manager.find(Pessoa.class, id);
        return pessoa;
    }
}
