package br.com.agilles.medidascautelares.medida;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jille on 17/10/2016.
 */
@Entity
public class MedidaCautelar implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
}
