package com.packtpub.twaattin.ui;

import com.packtpub.twaattin.presenter.LogoutBehavior;
import com.packtpub.twaattin.presenter.TweetRefresherBehavior;
import com.packtpub.twaattin.ui.decorator.*;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

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

        addComponent(menuBar);
        addComponentAttachListener(new TweetRefresherBehavior());

        Table table = new Table();

        addComponent(table);

        table.addGeneratedColumn("source", new SourceColumnDecorator());
        table.addGeneratedColumn("screeName", new ScreenNameColumnGenerator());
        table.addGeneratedColumn("name", new NameColumnGenerator());
        table.addGeneratedColumn("profileImage", new ProfileImageColumnGenerator());
        table.addGeneratedColumn("text", new TweetColumnDecorator());
        table.setColumnHeader("source", "via");
        table.setColumnHeader("screenName", "Screen name");
        table.setColumnHeader("profileImage", "");
        table.setColumnHeader("text", "Tweet");
        table.setVisibleColumns(new Object[] {
                "text", "name", "screenName", "profileImage", "createdAt", "source"
        });
    }

    public void fillTweets() {
        for (int i = 0; i < 10; i++) {
            Label label = new Label();

            label.setValue("Lorem ipsum dolor sit amet, consectetur "
                    + "adipisicing elit, sed do eiusmod tempor incididunt "
                    + "ut labore et dolore magna aliqua. Ut enim ad minim "
                    + "veniam, quis nostrud exercitation ullamco laboris "
                    + "nisi ut aliquip ex ea commodo consequat.");
            addComponent(label);
        }
    }
}
