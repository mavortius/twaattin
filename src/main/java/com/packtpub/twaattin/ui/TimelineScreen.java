package com.packtpub.twaattin.ui;

import com.packtpub.twaattin.presenter.LogoutBehavior;
import com.packtpub.twaattin.presenter.TweetRefresherBehavior;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.security.Principal;

import static com.vaadin.server.Sizeable.Unit.PERCENTAGE;
import static com.vaadin.ui.Alignment.MIDDLE_RIGHT;

public class TimelineScreen extends VerticalLayout {

    public TimelineScreen() {
        setMargin(true);

        Label label = new Label(VaadinSession.getCurrent().getAttribute(Principal.class).getName());
        Button button = new Button("Logout");

        button.addClickListener(new LogoutBehavior());

        HorizontalLayout menuBar = new HorizontalLayout(label, button);

        menuBar.setWidth(100, PERCENTAGE);
        menuBar.setComponentAlignment(button, MIDDLE_RIGHT);
        menuBar.setMargin(true);

        addComponent(menuBar);

        TweetRefresherBehavior behavior = TwaattinUI.getCurrent().getTweetRefresherBehavior();

        addComponentAttachListener(behavior);

        VerticalLayout timeline = new VerticalLayout();

        timeline.addStyleName("p-timeline");

        addComponent(timeline);
    }
}


