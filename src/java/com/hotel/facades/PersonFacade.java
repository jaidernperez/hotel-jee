package com.hotel.facades;

import com.hotel.models.Persona;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonFacade extends AbstractFacade<Persona> {

    @PersistenceContext(name = "HotelPU")
    private EntityManager manager;

    public PersonFacade() {
        super(Persona.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
