package br.com.agilles.medidascautelares.vitima;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by jille on 17/10/2016.
 */
public class VitimaDao {
    @Inject
    EntityManager manager;

    /**
     * Método para salvar a vitima no banco de dados
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
}
