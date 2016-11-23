package com.packtpub.twaattin.presenter;

import com.packtpub.twaattin.ui.LoginScreen;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import java.security.Principal;

public class LogoutBehavior implements Button.ClickListener {

    @Override
    public void buttonClick(Button.ClickEvent event) {
        VaadinSession.getCurrent().setAttribute(Principal.class,null);
        UI.getCurrent().setContent(new LoginScreen());
        Notification.show("You've been logged out");
    }
}
