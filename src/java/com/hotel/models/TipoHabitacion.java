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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JaiderPerez
 */
@Entity
@Table(name = "tipo_habitacion", catalog = "db_hotel", schema = "public")
public class TipoHabitacion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo")
    private Integer roomTypeId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<Habitacion> roomList;

    public TipoHabitacion() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Habitacion> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Habitacion> roomList) {
        this.roomList = roomList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoHabitacion that = (TipoHabitacion) o;
        return roomTypeId.equals(that.roomTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomTypeId);
    }
}
