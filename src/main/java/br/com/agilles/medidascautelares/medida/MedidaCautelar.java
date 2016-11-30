package br.com.agilles.medidascautelares.medida;

import br.com.agilles.medidascautelares.pessoa.Pessoa;
import br.com.agilles.medidascautelares.tipoMedida.TipoMedida;
import br.com.agilles.medidascautelares.vitima.Vitima;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jille on 17/10/2016.
 */
@Entity
public class MedidaCautelar implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String processo;
    private String local;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Pessoa pessoa;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Vitima vitima;

    @ElementCollection(targetClass = TipoMedida.class)
    @Enumerated(EnumType.STRING)
    private List<TipoMedida> tipoMedida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Vitima getVitima() {
        return vitima;
    }

    public void setVitima(Vitima vitima) {
        this.vitima = vitima;
    }

    public List<TipoMedida> getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(List<TipoMedida> tipoMedida) {
        this.tipoMedida = tipoMedida;
    }
}
