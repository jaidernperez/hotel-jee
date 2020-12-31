package com.hotel.services;

import com.hotel.facades.RoomFacade;
import com.hotel.models.Habitacion;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "roomService")
public class RoomService implements Serializable {

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

    public RoomFacade getRoomFacade() {
        return roomFacade;
    }
}
