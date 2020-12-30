package com.hotel.facades;

import com.hotel.models.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(name = "HotelPU")
    private EntityManager manager;

    public UserFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
