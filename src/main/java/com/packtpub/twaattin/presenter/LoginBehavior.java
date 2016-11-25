package com.packtpub.twaattin.presenter;

import com.packtpub.twaattin.authentication.AuthenticationException;
import com.packtpub.twaattin.authentication.TwitterAuthenticationStrategy;
import com.packtpub.twaattin.ui.TimelineScreen;
import com.vaadin.server.SystemError;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

import java.security.Principal;

/**
 * Login behavior delegates to a predefined authentication strategy.
 */
public class LoginBehavior implements Button.ClickListener {

    private final TextField pinField;

    public LoginBehavior(TextField pinField) {
        this.pinField = pinField;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            String pin = pinField.getValue();
            Principal user = new TwitterAuthenticationStrategy().authenticate(pin);

            VaadinSession.getCurrent().setAttribute(Principal.class, user);
            UI.getCurrent().setContent(new TimelineScreen());
            Notification.show("You're authenticated into Twaattin");
        } catch (AuthenticationException e) {
            pinField.setComponentError(new SystemError(e));
        }
    }
}
