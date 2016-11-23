package br.com.agilles.medidascautelares.tipoMedida;

import br.com.agilles.medidascautelares.medida.MedidaCautelar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;

/**
 * Created by jille on 23/11/2016.
 */

public enum TipoMedida {
    COMPARECIMENTO_MENSAL("Comparecimento Mensal em Juízo e na Central de Egressos"),
    PROIBICAO_AUSENTAR("Proibição de ausentar-se da comarca sem autorização"),
    PROIBICAO_CONTATO("Proibido contato com a vítima ou familiares"),
    RECOLHIMENTO_DOMICILIAR("Recolhimento domiciliar, inclusive aos sábados, domingos e feriados, após as 23:00h");

    private final  String descricao;

    TipoMedida(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

