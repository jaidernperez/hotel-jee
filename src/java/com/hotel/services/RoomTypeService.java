package com.hotel.services;

import com.hotel.facades.RoomTypeFacade;
import com.hotel.models.TipoHabitacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RoomTypeService {

    @EJB
    private RoomTypeFacade roomTypeFacade;

    public List<TipoHabitacion> list(){
        return getRoomTypeFacade().list();
    }

    public TipoHabitacion find(int id){
        return getRoomTypeFacade().find(id);
    }

    private RoomTypeFacade getRoomTypeFacade() {
        return roomTypeFacade;
    }
}
