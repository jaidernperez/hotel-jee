package com.hotel.facades;

import com.hotel.models.Reservacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationFacade extends AbstractFacade<Reservacion> {

    @PersistenceContext(name = "HotelPU")
    private EntityManager manager;

    public ReservationFacade() {
        super(Reservacion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
