package br.com.agilles.medidascautelares.pessoa;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jille on 29/11/2016.
 */
@Named
@FacesConverter("pessoaConverter")
@RequestScoped
public class PessoaConverter implements Converter{

    @Inject
    PessoaDao dao;
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s != null && !s.equals("")) {
            Pessoa pessoa = new Pessoa();
            Long id = Long.valueOf(s);
            pessoa = dao.buscarPorId(id);
            return pessoa;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Pessoa) {
            if (((Pessoa) o).getId() != null) {
                Pessoa pessoa = new Pessoa();
                pessoa = (Pessoa) o;
                String id = String.valueOf(pessoa.getId());
                    return id;
            }
        }
        return "";
    }
}
