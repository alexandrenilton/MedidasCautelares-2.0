package br.com.agilles.medidascautelares.vitima;

import br.com.agilles.medidascautelares.endereco.Endereco;
import br.com.agilles.medidascautelares.endereco.WebServiceEndereco;
import org.primefaces.context.RequestContext;

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
public class VitimaBean implements Serializable {

    @Inject
    private Vitima vitima;
    @Inject
    private VitimaDao dao;
    @Inject
    private Endereco endereco;
    private Vitima vitimaSelecionada;
    private List<Vitima> todasVitimas = new ArrayList<>();

    /**
     * Getter and Setters
     **/
    public Vitima getVitima() {
        return vitima;
    }

    public void setVitima(Vitima vitima) {
        this.vitima = vitima;
    }

    public VitimaDao getDao() {
        return dao;
    }

    public void setDao(VitimaDao dao) {
        this.dao = dao;
    }

    public Vitima getVitimaSelecionada() {
        return vitimaSelecionada;
    }

    public void setVitimaSelecionada(Vitima vitimaSelecionada) {
        this.vitimaSelecionada = vitimaSelecionada;
    }

    public List<Vitima> getTodasVitimas() {
        return todasVitimas;
    }

    public void setTodasVitimas(List<Vitima> todasVitimas) {
        this.todasVitimas = todasVitimas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    /**
     * Todos os métodos da classe //**
     */

    /**
     * @return Método que direciona usuário para a página de edição das vítimas
     */
    public String goEditarVitima() {
        return "edicaoVitimas";
    }

    /**
     * Método que chama o dao para gravar uma vítima no banco de dados
     */
    public void gravarVitima() {
        vitima.setEndereco(endereco);
        if (dao.gravarVitima(vitima)) {
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Sucesso!', 'Nova vítima inserida no sistema!', 'success')");
        } else {
            RequestContext contexto = RequestContext.getCurrentInstance();
            contexto.execute("swal('Erro!', 'Algo aconteceu errado, tente novamente ou entre em contato com o Administrador do sistema!', 'error')");
        }

    }

    /**
     * @return Retorna objeto do tipo Endereco
     * Usado para completar campos de endereço após usuario digitar o cep
     */
    public Endereco preencherCep() {
        String cep = endereco.getCep().replace("-", "");
        this.endereco = WebServiceEndereco.getEnderecoPorCep(cep);
        return this.endereco;

    }
}
