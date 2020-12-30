package com.hotel.facades;

import com.hotel.models.TipoHabitacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoomTypeFacade extends AbstractFacade<TipoHabitacion> {

   @PersistenceContext(name = "HotelPU")
   private EntityManager manager;

    public RoomTypeFacade() {
        super(TipoHabitacion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
}
