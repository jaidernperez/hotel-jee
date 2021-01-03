package com.hotel.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author JaiderPerez
 */
@Entity
@Table(name = "usuario", catalog = "db_hotel", schema = "public")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer userId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_usuario", unique = true)
    private String userName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "clave")
    private String clave;

    @Size(max = 800)
    @Column(name = "imagen")
    private String image;

    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona person;

    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol role;

    public Usuario() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return userId.equals(usuario.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public void login(){
    }
}
