package com.packtpub.twaattin.ui;

import com.packtpub.twaattin.presenter.LoginBehavior;
import com.packtpub.twaattin.service.TwitterService;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;


public class LoginScreen extends VerticalLayout {

    private Link twitterLink = new Link();
    private TextField pinField = new TextField();
    private Button submitButton = new Button("Submit");

    public LoginScreen() {
        setMargin(true);
        setSpacing(true);

        twitterLink.setCaption("Get PIN");
        twitterLink.setTargetName("twitterauth");
        twitterLink.setResource(new ExternalResource(TwitterService.get().getAuthenticationUrl()));

        pinField.setInputPrompt("PIN");

        addComponent(twitterLink);
        addComponent(pinField);
        addComponent(submitButton);

        submitButton.addClickListener(new LoginBehavior(pinField));
    }
}
