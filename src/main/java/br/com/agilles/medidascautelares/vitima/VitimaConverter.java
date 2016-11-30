package br.com.agilles.medidascautelares.vitima;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jille on 30/11/2016.
 */
@Named
@FacesConverter(value = "vitimaConverter")
@RequestScoped
public class VitimaConverter implements Converter {
    @Inject
    VitimaDao dao;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s!=null && !s.equals("")) {
            Vitima vitima = new Vitima();
            Long id = Long.valueOf(s);
            vitima = dao.buscarPorId(id);
            return vitima;

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Vitima) {
            if (((Vitima) o).getId() != null) {
                Vitima vitima = new Vitima();
                vitima= (Vitima) o;
                String id = String.valueOf(vitima.getId());
                return id;
            }
        }
        return "";
    }
}
