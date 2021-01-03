package com.hotel.utilities;

import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

public class MessageProperty {

    public static String getMessageProperty(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle properties = ResourceBundle.getBundle(
                "com.hotel.messages.messages",
                context.getViewRoot().getLocale());

        return properties.getString(key);
    }
}
