package br.com.agilles.medidascautelares.medida;

import br.com.agilles.medidascautelares.endereco.Endereco;
import br.com.agilles.medidascautelares.pessoa.Pessoa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jille on 17/10/2016.
 */
public class MedidaCautelarDao {

    @Inject
    EntityManager manager;

    public boolean gravarMedida(MedidaCautelar medidaCautelar) {
        boolean gravado = false;
        try {
            manager.getTransaction().begin();
            manager.persist(medidaCautelar);
            manager.getTransaction().commit();
            gravado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();

        }
        return gravado;
    }

    public List<MedidaCautelar> listarTodasMedidas() {
        List<MedidaCautelar> medidas = new ArrayList<>();
        try {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<MedidaCautelar> q = builder.createQuery(MedidaCautelar.class);
            Root<MedidaCautelar> p = q.from(MedidaCautelar.class);
            q.select(p);
            TypedQuery<MedidaCautelar> query = manager.createQuery(q);
            medidas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return medidas;

    }

    public List<MedidaCautelar> listarMedidasParaPaginaInicial() {
        List<MedidaCautelar> medidas = new ArrayList<>();
        try {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<MedidaCautelar> q = builder.createQuery(MedidaCautelar.class);
            Root<MedidaCautelar> m = q.from(MedidaCautelar.class);
            q.select(m);
            q.orderBy(builder.desc(m.get("id")), builder.asc(m.get("id")));
            TypedQuery<MedidaCautelar> query = manager.createQuery(q);
            medidas = query.setMaxResults(4).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medidas;

    }

    public List<MedidaCautelar> relatorios() {
        List<MedidaCautelar> medidas = new ArrayList<>();
        try {
           Query query = manager.createQuery("select m from MedidaCautelar m join fetch m.pessoa p join fetch p.endereco e " +
                   "where m.pessoa.id = p.id and p.endereco.id = e.id order by e.bairro");
           medidas = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return medidas;
    }

    public boolean atualizar(MedidaCautelar medidaSelecionada) {
        boolean atualizado = false;
        try {
            manager.getTransaction().begin();
            manager.merge(medidaSelecionada);
            manager.getTransaction().commit();
            atualizado = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return atualizado;
    }
}
