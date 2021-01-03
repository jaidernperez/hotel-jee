package com.hotel.services;

import com.hotel.facades.PersonFacade;
import com.hotel.models.Persona;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PersonService {

    @EJB
    private PersonFacade personFacade;

    public void create(Persona person){
        getPersonFacade().create(person);
    }

    public void update(Persona person){
        getPersonFacade().update(person);
    }

    public void delete(Persona person){
        if (person.hasRelations()) {
            getPersonFacade().delete(person);
        }
    }

    public List<Persona> list(){
        return getPersonFacade().list();
    }

    public Persona find(int id){
       return getPersonFacade().find(id);
    }

    private PersonFacade getPersonFacade() {
        return personFacade;
    }
}
