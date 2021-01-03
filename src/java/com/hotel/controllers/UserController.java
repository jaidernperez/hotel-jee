package com.hotel.controllers;

import com.hotel.models.Usuario;
import com.hotel.services.UserService;
import com.hotel.utilities.MessageProperty;
import com.hotel.utilities.ShowMessage;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named(value = "userController")
public class UserController implements Serializable {

    @EJB
    private UserService service;

    private Usuario userCurrent;
    private String searchString;

    private void initUser() {
        userCurrent = new Usuario();
    }

    public String redirectUser(Usuario user, String face) {
        this.userCurrent = user;
        return face;
    }

    public String createUser(Usuario user) {
        try {
            service.create(user);
            initUser();
            messageSuccess("msg.success", "user.create.success");
            return "user-create";
        } catch (Exception e) {
            messageError("msg.fail", "create.fail");
        }
        return null;
    }

    public String updateUser(Usuario user) {
        try {
            service.update(user);
            messageSuccess("msg.success", "user.update.success");
            return "user-admin";
        } catch (Exception e) {
            messageError("msg.fail", "update.fail");
        }
        return null;
    }

    public String deleteUser(Usuario user) {
        try {
            service.delete(user);
            initUser();
            messageSuccess("msg.success", "user.delete.success");
            return "user-admin";
        } catch (Exception e) {
            messageError("msg.fail", "delete.fail");
        }
        return null;
    }

    public List<Usuario> listUsers() {
        return service.list();
    }

    public Usuario findUser(int id) {
        try {
            return service.find(id);
        } catch (Exception e) {
            messageError("msg.fail", "user.find.fail");
        }
        return null;
    }

    public Usuario getSelected() {
        if (userCurrent == null) {
            initUser();
        }
        return userCurrent;
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
