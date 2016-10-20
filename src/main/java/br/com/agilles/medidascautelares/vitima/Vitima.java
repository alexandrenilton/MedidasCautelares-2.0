package br.com.agilles.medidascautelares.vitima;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jille on 17/10/2016.
 */
@Entity
public class Vitima implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
}
