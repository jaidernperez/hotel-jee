package com.hotel.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JaiderPerez
 */
@Entity
@Table(name = "habitacion", catalog = "db_hotel", schema = "public")
public class Habitacion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_habitacion")
    private Integer roomId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre", unique = true)
    private String name;

    @Basic(optional = false)
    @NotNull
    @Min(10000) @Max(1000000)
    @Column(name = "precio")
    private double price;

    @Basic(optional = false)
    @NotNull
    @Column(name = "disponibilidad")
    private boolean availability;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Reservacion> reservationList;

    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoHabitacion type;

    public Habitacion() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Reservacion> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservacion> reservationList) {
        this.reservationList = reservationList;
    }

    public TipoHabitacion getType() {
        return type;
    }

    public void setType(TipoHabitacion type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return roomId.equals(that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }

    public boolean hasRelations(){
        return reservationList.size() == 0;
    }
}
