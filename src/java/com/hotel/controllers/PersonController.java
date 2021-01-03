package com.hotel.controllers;

import com.hotel.models.Persona;
import com.hotel.services.PersonService;
import com.hotel.utilities.MessageProperty;
import com.hotel.utilities.ShowMessage;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "personController")
public class PersonController implements Serializable {

    @EJB
    private PersonService service;

    private Persona personCurrent;
    private String searchString;

    private void initPerson() {
        personCurrent = new Persona();
    }

    public String redirectPerson(Persona person, String face) {
        this.personCurrent = person;
        return face;
    }

    public String createPerson(Persona person) {
        try {
            service.create(person);
            initPerson();
            messageSuccess("msg.success", "person.create.success");
            return "person-create";
        } catch (Exception e) {
            messageError("msg.fail", "create.fail");
        }
        return null;
    }

    public String updatePerson(Persona person) {
        try {
            service.update(person);
            messageSuccess("msg.success", "person.update.success");
            return "person-admin";
        } catch (Exception e) {
            messageError("msg.fail", "update.fail");
        }
        return null;
    }

    public String deletePerson(Persona person) {
        try {
            service.delete(person);
            initPerson();
            messageSuccess("msg.success", "person.delete.success");
            return "person-admin";
        } catch (Exception e) {
            messageError("msg.fail", "delete.fail");
        }
        return null;
    }

    public List<Persona> listPersons() {
        return service.list();
    }

    public Persona findPerson(int id) {
        try {
            return service.find(id);
        } catch (Exception e) {
            messageError("msg.fail", "person.find.fail");
        }
        return null;
    }

    public Persona getSelected() {
        if (personCurrent == null) {
            initPerson();
        }
        return personCurrent;
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
