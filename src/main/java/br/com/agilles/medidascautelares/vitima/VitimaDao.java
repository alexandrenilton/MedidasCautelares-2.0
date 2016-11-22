package br.com.agilles.medidascautelares.vitima;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jille on 17/10/2016.
 */
public class VitimaDao {
    @Inject
    EntityManager manager;

    /**
     * Método para salvar a vitima no banco de dados
     *
     * @param vitima a ser inserida no banco de dados
     * @return booleano (salvou com sucesso ou nao)
     */
    public boolean gravarVitima(Vitima vitima) {
        boolean salvou = false;
        try {
            manager.getTransaction().begin();
            manager.persist(vitima);
            manager.getTransaction().commit();
            salvou = true;
        } catch (Exception e) {
            e.printStackTrace();
            salvou = false;
        } finally {
            manager.close();
        }

        return salvou;

    }

    public List<Vitima> listarTodasVitimas() {
        List<Vitima> vitimas = new ArrayList<>();
        try {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Vitima> q = builder.createQuery(Vitima.class);
            Root<Vitima> p = q.from(Vitima.class);
            q.select(p);
            q.orderBy(builder.asc(p.get("nome")), builder.desc(p.get("nome")));
            TypedQuery<Vitima> query = manager.createQuery(q);

            vitimas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return vitimas;
    }
}
