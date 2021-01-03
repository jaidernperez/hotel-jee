package com.hotel.controllers;

import com.hotel.models.Habitacion;
import com.hotel.services.RoomService;
import com.hotel.utilities.MessageProperty;
import com.hotel.utilities.ShowMessage;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "roomController")
public class RoomController implements Serializable {

    @EJB
    private RoomService service;

    private Habitacion roomCurrent;
    private String searchString;

    public void initRoom() {
        roomCurrent = new Habitacion();
    }

    public String redirectRoom(Habitacion room, String face) {
        this.roomCurrent = room;
        return face;
    }

    public String createRoom(Habitacion room) {
        try {
            service.create(room);
            initRoom();
            messageSuccess("msg.success", "room.create.success");
            return "room-create";
        } catch (Exception e) {
            messageError("msg.fail", "create.fail");
        }
        return null;
    }

    public String updateRoom(Habitacion room) {
        try {
            service.update(room);
            messageSuccess("msg.success", "room.update.success");
            return "room-admin";
        } catch (Exception e) {
            messageError("msg.fail", "update.fail");
        }
        return null;
    }

    public String deleteRoom(Habitacion room) {
        try {
            service.delete(room);
            initRoom();
            messageSuccess("msg.success", "room.delete.success");
            return "room-admin";
        } catch (Exception e) {
            messageError("msg.fail", "delete.fail");
        }
        return null;
    }

    public List<Habitacion> listRooms() {
        return service.list();
    }

    public Habitacion finOneRoom(int id) {
        try {
            return service.find(id);
        } catch (Exception e) {
            messageError("msg.fail", "room.find.fail");
        }
        return null;
    }

    public Habitacion getSelected() {
        if (roomCurrent == null) {
            initRoom();
        }
        return roomCurrent;
    }

    public void messageSuccess(String msgTitle, String msgDetail) {
        String title = MessageProperty.getMessageProperty(msgTitle);
        String detail = MessageProperty.getMessageProperty(msgDetail);

        ShowMessage.successMessage(title, detail);
    }

    public void messageError(String msgTitle, String msgDetail) {
        String title = MessageProperty.getMessageProperty(msgTitle);
        String detail = MessageProperty.getMessageProperty(msgDetail);

        ShowMessage.errorMessage(title, detail);
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
