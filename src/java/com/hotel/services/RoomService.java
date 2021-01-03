package com.hotel.services;

import com.hotel.facades.RoomFacade;
import com.hotel.models.Habitacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RoomService {

    @EJB
    private RoomFacade roomFacade;

    public void create(Habitacion room) {
        getRoomFacade().create(room);
    }

    public void update(Habitacion room) {
        getRoomFacade().update(room);
    }

    public boolean delete(Habitacion room) {
        if (!room.hasRelations()) {
            getRoomFacade().delete(room);
            return true;
        }
        return false;
    }

    public List<Habitacion> list() {
        return getRoomFacade().list();
    }

    public Habitacion find(int id) {
        return getRoomFacade().find(id);
    }

    public void changeAvailability(Habitacion room, boolean availability) {
        room.setAvailability(availability);
        update(room);
    }

    private RoomFacade getRoomFacade() {
        return roomFacade;
    }
}
