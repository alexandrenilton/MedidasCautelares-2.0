package br.com.agilles.medidascautelares.endereco;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jille on 17/10/2016.
 */

public class EnderecoDao implements Serializable {

    @Inject
    private EntityManager manager;



}
