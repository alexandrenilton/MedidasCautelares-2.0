package br.com.agilles.medidascautelares.medida;

import br.com.agilles.medidascautelares.tipoMedida.TipoMedida;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jille on 17/10/2016.
 */
@Named
@RequestScoped
public class MedidaCautelarBean implements Serializable {

    @Inject
    private MedidaCautelar medidaCautelar;
    @Inject
    private MedidaCautelarDao dao;

    private MedidaCautelar medidaSelecionada;

    private TipoMedida[] tipoMedidas;

    private boolean possuiVitima = true;

    /**
     * Getters and setters
     */
    public TipoMedida[] getTipoMedidas() {
        return TipoMedida.values();
    }

    public MedidaCautelar getMedidaCautelar() {
        return medidaCautelar;
    }

    public void setMedidaCautelar(MedidaCautelar medidaCautelar) {
        this.medidaCautelar = medidaCautelar;
    }

    public MedidaCautelarDao getDao() {
        return dao;
    }

    public void setDao(MedidaCautelarDao dao) {
        this.dao = dao;
    }

    public MedidaCautelar getMedidaSelecionada() {
        return medidaSelecionada;
    }

    public void setMedidaSelecionada(MedidaCautelar medidaSelecionada) {
        this.medidaSelecionada = medidaSelecionada;
    }

    public void setPossuiVitima(boolean possuiVitima) {
        this.possuiVitima = possuiVitima;
    }

    public boolean isPossuiVitima() {
        return possuiVitima;
    }

    public void gravarMedida() {
        if (dao.gravarMedida(medidaCautelar)) {
            System.out.println("Gravado");
        }
    }

    public void atualizarMedida() {


    }
}
