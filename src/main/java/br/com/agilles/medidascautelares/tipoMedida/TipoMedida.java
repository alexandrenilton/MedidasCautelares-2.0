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
    COMPARECIMENTO_MENSAL, PROIBICAO_AUSENTAR, PROIBICAO_CONTATO, RECOLHIMENTO_DOMICILIAR;

    public String getDescricao() {
        switch (this) {
            case COMPARECIMENTO_MENSAL:
                return "Comparecimento Mensal em Juízo e na Central de Egressos";
            case PROIBICAO_AUSENTAR:
                return "Proibição de ausentar-se da comarca sem devida autorização";
            case PROIBICAO_CONTATO:
                return "Proibição contato com a vítima ou familiares";
            case RECOLHIMENTO_DOMICILIAR:
                return "Recolhimento domiciliar, inclusive aos sábados, domingos e feriados, a partir das 23:00h";
            default:
                return "";
        }
    }


}

