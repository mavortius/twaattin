package com.packtpub.twaattin.ui;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class TimelineScreen extends VerticalLayout {

    public TimelineScreen() {
        setMargin(true);
        fillTweets();
    }

    public void fillTweets() {
        for (int i = 0; i < 10; i++) {
            Label label = new Label();

            label.setValue("Lorem ipsum dolor sit amet...");
            addComponent(label);
        }
    }
}
