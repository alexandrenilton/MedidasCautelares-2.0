package br.com.agilles.medidascautelares.tipoMedida;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 * Created by jille on 30/11/2016.
 */
@Named
@FacesConverter(value = "tipoMedidaConverter")
public class TipoMedidaConverter extends EnumConverter {

    public TipoMedidaConverter() {
        super(TipoMedida.class);
    }
}
