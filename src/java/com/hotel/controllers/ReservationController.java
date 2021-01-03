package com.hotel.controllers;

import com.hotel.models.Reservacion;
import com.hotel.services.ReservationService;
import com.hotel.utilities.MessageProperty;
import com.hotel.utilities.ShowMessage;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "reservationController")
public class ReservationController implements Serializable {

    @EJB
    private ReservationService service;

    private Reservacion reservationCurrent;
    private String searchString;

    private void initReservation() {
        reservationCurrent = new Reservacion();
    }

    public String redirectReservation(Reservacion reservation, String face) {
        this.reservationCurrent = reservation;
        return face;
    }

    public String createReservation(Reservacion reservation) {
        try {
            service.create(reservation);
            initReservation();
            messageSuccess("msg.success", "reservation.create.success");
            return "reservation-create";
        } catch (Exception e) {
            messageError("msg.fail", "create.fail");
        }
        return null;
    }

    public String updateReservation(Reservacion reservation) {
        try {
            service.update(reservation);
            messageSuccess("msg.success", "reservation.update.success");
            return "reservation-admin";
        } catch (Exception e) {
            messageError("msg.fail", "update.fail");
        }
        return null;
    }

    public String deleteReservation(Reservacion reservation) {
        try {
            service.delete(reservation);
            initReservation();
            messageSuccess("msg.success", "reservation.delete.success");
            return "reservation-admin";
        } catch (Exception e) {
            messageError("msg.fail", "delete.fail");
        }
        return null;
    }

    public List<Reservacion> listReservations() {
        return service.list();
    }

    public Reservacion findReservation(int id) {
        try {
            return service.find(id);
        } catch (Exception e) {
            messageError("msg.fail", "reservation.find.fail");
        }
        return null;
    }

    public Reservacion getSelected() {
        if (reservationCurrent == null) {
            initReservation();
        }
        return reservationCurrent;
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
