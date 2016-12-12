package br.com.agilles.medidascautelares.medida;

import br.com.agilles.medidascautelares.tipoMedida.TipoMedida;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
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

    private List<MedidaCautelar> todasMedidas = new ArrayList<>();

    private List<MedidaCautelar> ultimasMedidas = new ArrayList<>();

    private List<MedidaCautelar> relatorioMedidas = new ArrayList<>();



    /**
     * Getters and setters
     */
    public TipoMedida[] getTipoMedidas() {
        return TipoMedida.values();
    }

    public MedidaCautelar getMedidaCautelar() {
        return medidaCautelar;
    }


    public void setRelatorioMedidas(List<MedidaCautelar> relatorioMedidas) {
        this.relatorioMedidas = relatorioMedidas;
    }

    public void setMedidaCautelar(MedidaCautelar medidaCautelar) {
        this.medidaCautelar = medidaCautelar;
    }

    public List<MedidaCautelar> getTodasMedidas() {
        return todasMedidas;
    }

    public void setTipoMedidas(TipoMedida[] tipoMedidas) {
        this.tipoMedidas = tipoMedidas;
    }

    public void setTodasMedidas(List<MedidaCautelar> todasMedidas) {
        this.todasMedidas = todasMedidas;
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

    public List<MedidaCautelar> getUltimasMedidas() {
        return ultimasMedidas;
    }

    public void setUltimasMedidas(List<MedidaCautelar> ultimasMedidas) {
        this.ultimasMedidas = ultimasMedidas;
    }

    /**
     * Métodos para preencher a lista
     */

    @PostConstruct
    public void init() {
        this.todasMedidas = dao.listarTodasMedidas();
        this.ultimasMedidas = dao.listarMedidasParaPaginaInicial();
    }


    /**
     * Método que insere uma nova medida no sistema
     */
    public void gravarMedida() {
        if (dao.gravarMedida(medidaCautelar)) {
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Sucesso!', 'Nova Medida Cautelar inserida no sistema!', 'success')");
            this.medidaCautelar = new MedidaCautelar();
            init();
        } else {
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Erro!', 'Alguma coisa deu errado! Contate o administrador do sistema', 'error')");
        }
    }

    /**
     * Método que irá atualizar informações de uma nova medida no sistema
     */
    public void atualizarMedida() {
    }



}

