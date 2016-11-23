package com.packtpub.twaattin.presenter;

import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;

import com.packtpub.twaattin.authentication.AuthenticationException;
import com.packtpub.twaattin.authentication.SimpleUserPasswordAuthenticationStrategy;
import com.packtpub.twaattin.ui.TimelineScreen;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

import java.security.Principal;

public class LoginBehavior implements Button.ClickListener {

    private final TextField loginField;
    private final PasswordField passwordField;

    public LoginBehavior(TextField loginField, PasswordField passwordField) {
        this.loginField = loginField;
        this.passwordField = passwordField;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            String login = loginField.getValue();
            String password = passwordField.getValue();
            Principal user = new SimpleUserPasswordAuthenticationStrategy().authenticate(login, password);

            VaadinSession.getCurrent().setAttribute(Principal.class, user);
            UI.getCurrent().setContent(new TimelineScreen());
            Notification.show("You're authenticated into Twaattin");
        } catch (AuthenticationException e) {
            Notification.show(e.getMessage(), ERROR_MESSAGE);
        }
    }
}
