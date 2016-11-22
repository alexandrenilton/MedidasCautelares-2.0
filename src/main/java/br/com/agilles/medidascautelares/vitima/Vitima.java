package br.com.agilles.medidascautelares.vitima;

import br.com.agilles.medidascautelares.endereco.Endereco;

import javax.persistence.*;
import java.io.Serializable;
import java.io.StringReader;

/**
 * Created by jille on 17/10/2016.
 */
@Entity
public class Vitima implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String mae;
    private String nascimento;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;
    private String documento;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
