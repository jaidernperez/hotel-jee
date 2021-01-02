package com.hotel.services;

import com.hotel.facades.RoleFacade;
import com.hotel.models.Rol;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RoleService {

    @EJB
    private RoleFacade roleFacade;

    public List<Rol> list(){
        return getRoleFacade().list();
    }

    public Rol find(int id){
        return getRoleFacade().find(id);
    }

    private RoleFacade getRoleFacade() {
        return roleFacade;
    }
}
