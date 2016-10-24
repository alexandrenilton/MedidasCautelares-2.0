package br.com.agilles.medidascautelares.usuario;

import br.com.agilles.medidascautelares.endereco.Endereco;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jille on 17/10/2016.
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Campo Nome está vazio")
    private String nome;

    @NotEmpty(message = "Campo SobreNome está vazio")
    private String sobreNome;

    @NotEmpty(message = "Campo Funcional está vazio")
    private String funcional;

    @OneToOne
    private Endereco endereco;

    private String senha;
    private String nomeGuerra;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getFuncional() {
        return funcional;
    }

    public void setFuncional(String funcional) {
        this.funcional = funcional;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
