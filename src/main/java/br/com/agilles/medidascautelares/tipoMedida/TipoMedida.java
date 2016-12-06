package br.com.agilles.medidascautelares.tipoMedida;


import javax.persistence.Transient;

/**
 * Created by jille on 23/11/2016.
 */

public enum TipoMedida {
    COMPARECIMENTO_MENSAL("Comparecimento Periódico em Juízo"),
    PROIBICAO_ACESSO("Proibição de Acesso ou Frequência à determinados lugares"),
    PROIBICAO_AUSENTAR("Proibição de ausentar-se da comarca"),
    PROIBICAO_CONTATO("Proibição de Manter contato com Pessoa Determinada"),
    RECOLHIMENTO_DOMICILIAR("Recolhimento domiciliar no período noturno e nos dias de folga");


    private String descricao;

    TipoMedida(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}

