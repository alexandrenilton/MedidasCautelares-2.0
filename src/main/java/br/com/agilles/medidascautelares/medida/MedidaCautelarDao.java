package br.com.agilles.medidascautelares.medida;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
        }finally {
            manager.close();

        }
        return gravado;
    }
}
