package com.packtpub.twaattin.ui;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.ui.Alignment.BOTTOM_RIGHT;

import com.packtpub.twaattin.presenter.LogoutBehavior;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.security.Principal;

public class TimelineScreen extends VerticalLayout {

    public TimelineScreen() {
        setMargin(true);
        fillTweets();

        Label label = new Label(VaadinSession.getCurrent().getAttribute(Principal.class).getName());
        Button button = new Button("Logout");

        button.addClickListener(new LogoutBehavior());

        HorizontalLayout menuBar = new HorizontalLayout(label, button);

        addComponent(menuBar);
    }

    public void fillTweets() {
        for (int i = 0; i < 10; i++) {
            Label label = new Label();

            label.setValue("Lorem ipsum dolor sit amet...");
            addComponent(label);
        }
    }
}
