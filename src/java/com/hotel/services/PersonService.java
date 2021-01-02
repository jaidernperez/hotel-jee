package com.hotel.services;

import com.hotel.facades.PersonFacade;
import com.hotel.models.Persona;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "personService")
public class PersonService implements Serializable {

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
        return personFacade.list();
    }

    public Persona find(int id){
       return getPersonFacade().find(id);
    }

    public PersonFacade getPersonFacade() {
        return personFacade;
    }
}
