package com.hotel.facades;

import com.hotel.models.Habitacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoomFacade extends AbstractFacade<Habitacion> {

    @PersistenceContext(name = "HotelPU")
   private EntityManager manager;

    public RoomFacade() {
        super(Habitacion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
