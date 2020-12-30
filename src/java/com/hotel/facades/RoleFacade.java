package com.hotel.facades;

import com.hotel.models.Rol;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoleFacade extends AbstractFacade<Rol> {

    @PersistenceContext(name = "HotelPU")
    private EntityManager manager;

    public RoleFacade() {
        super(Rol.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
