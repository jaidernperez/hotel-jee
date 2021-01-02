package com.hotel.services;

import com.hotel.facades.UserFacade;
import com.hotel.models.Usuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserService {

    @EJB
    private UserFacade userFacade;

    public void create(Usuario user){
        getUserFacade().create(user);
    }

    public void update(Usuario user){
        getUserFacade().update(user);
    }

    public void delete(Usuario user){
        getUserFacade().delete(user);
    }

    public List<Usuario> list(){
        return getUserFacade().list();
    }

    public Usuario find(int id){
        return getUserFacade().find(id);
    }

    private UserFacade getUserFacade() {
        return userFacade;
    }
}
