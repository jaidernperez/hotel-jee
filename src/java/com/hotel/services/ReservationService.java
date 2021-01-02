package com.hotel.services;

import com.hotel.facades.ReservationFacade;
import com.hotel.models.Reservacion;
import com.hotel.utilities.UtilityDate;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "reservationService")
public class ReservationService implements Serializable {

    @EJB
    private ReservationFacade reservationFacade;

    public boolean create(Reservacion reservation) {
        if (reservation.getRoom().isAvailability()) {
            reservation = generateStartDate(reservation);
            getReservationFacade().create(reservation);
            return true;
        }
        return false;
    }

    public void update(Reservacion reservation) {
        if (reservation.getRoom().isAvailability()) {
            getReservationFacade().update(reservation);
        }
    }

    public void delete(Reservacion reservation) {
        getReservationFacade().delete(reservation);
    }

    public List<Reservacion> list() {
        return getReservationFacade().list();
    }

    public Reservacion find(int id) {
        return getReservationFacade().find(id);
    }

    public void changeState(Reservacion reservation, boolean state) {
        reservation.setState(state);
        update(reservation);
    }

    public ReservationFacade getReservationFacade() {
        return reservationFacade;
    }

    public Reservacion generateStartDate(Reservacion reservation){
        if (reservation.getStartDate() == null){
            reservation.setStartDate(UtilityDate.generateDate());
        }
        return reservation;
    }

    public void finalizeReservation(Reservacion reservation){
        reservation.calculateTotalPrice();
        RoomService roomService = new RoomService();
        roomService.changeAvailability(reservation.getRoom(), true);

        if (reservation.getEndDate() == null){
            reservation.setEndDate(UtilityDate.generateDate());
        }
        update(reservation);
    }
}
