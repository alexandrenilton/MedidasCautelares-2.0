package br.com.agilles.medidascautelares.pessoa;

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
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Pessoa> q = builder.createQuery(Pessoa.class);
        Root<Pessoa> p = q.from(Pessoa.class);
        q.select(p);
        q.orderBy(builder.asc(p.get("nome")), builder.desc(p.get("nome")));
        TypedQuery<Pessoa> query = manager.createQuery(q);

        List<Pessoa> pessoas = query.getResultList();

        return pessoas;

    }
}

