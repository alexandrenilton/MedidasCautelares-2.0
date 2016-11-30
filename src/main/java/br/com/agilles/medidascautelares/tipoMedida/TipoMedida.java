package br.com.agilles.medidascautelares.tipoMedida;


/**
 * Created by jille on 23/11/2016.
 */

public enum TipoMedida {
    COMPARECIMENTO_MENSAL("Comparecimento Mensal em Juízo e na Central de Egressos"),
    PROIBICAO_AUSENTAR("Proibição de ausentar-se da comarca sem autorização"),
    PROIBICAO_CONTATO("Proibido contato com a vítima ou familiares"),
    RECOLHIMENTO_DOMICILIAR("Recolhimento domiciliar, inclusive aos sábados, domingos e feriados, após as 23:00h");

    private String descricao;

    TipoMedida(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}

