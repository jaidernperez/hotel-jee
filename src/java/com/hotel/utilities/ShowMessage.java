package com.hotel.utilities;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ShowMessage {

    public static void errorMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext faces = FacesContext.getCurrentInstance();
        faces.addMessage(null, message);
    }

    public static void successMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext faces = FacesContext.getCurrentInstance();
        faces.addMessage("successInfo", message);
    }
}
