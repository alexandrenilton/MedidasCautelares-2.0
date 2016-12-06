package br.com.agilles.medidascautelares.relatorios;

import br.com.agilles.medidascautelares.endereco.Endereco;
import br.com.agilles.medidascautelares.endereco.EnderecoBean;
import br.com.agilles.medidascautelares.medida.MedidaCautelar;
import br.com.agilles.medidascautelares.medida.MedidaCautelarDao;
import br.com.agilles.medidascautelares.pessoa.Pessoa;
import br.com.agilles.medidascautelares.pessoa.PessoaDao;
import br.com.agilles.medidascautelares.tipoMedida.TipoMedida;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jille on 06/12/2016.
 */
@Named
@RequestScoped
public class Relatorios implements Serializable {
    @Inject
    private Pessoa pessoa;
    @Inject
    private MedidaCautelar medidaCautelar;

    private TipoMedida tipoMedida;
    @Inject
    private PessoaDao pessoaDao;
    @Inject
    private MedidaCautelarDao medidaCautelarDao;

    private List<Pessoa> pessoas = new ArrayList<>();

    private boolean porBairro = false;
    private boolean porTipo = false;
    private boolean porPessoa = false;


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public MedidaCautelar getMedidaCautelar() {
        return medidaCautelar;
    }

    public void setMedidaCautelar(MedidaCautelar medidaCautelar) {
        this.medidaCautelar = medidaCautelar;
    }

    public TipoMedida getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(TipoMedida tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    @PostConstruct
    public void gerarRelatorio() {
        this.pessoas = pessoaDao.pessoasPorBairro();
    }

    public PessoaDao getPessoaDao() {
        return pessoaDao;
    }

    public void setPessoaDao(PessoaDao pessoaDao) {
        this.pessoaDao = pessoaDao;
    }

    public MedidaCautelarDao getMedidaCautelarDao() {
        return medidaCautelarDao;
    }

    public void setMedidaCautelarDao(MedidaCautelarDao medidaCautelarDao) {
        this.medidaCautelarDao = medidaCautelarDao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public boolean isPorBairro() {
        return porBairro;
    }

    public void setPorBairro(boolean porBairro) {
        this.porBairro = porBairro;
    }

    public boolean isPorTipo() {
        return porTipo;
    }

    public void setPorTipo(boolean porTipo) {
        this.porTipo = porTipo;
    }

    public boolean isPorPessoa() {
        return porPessoa;
    }

    public void setPorPessoa(boolean porPessoa) {
        this.porPessoa = porPessoa;
    }
}
