package com.packtpub.twaattin.ui;

import com.packtpub.twaattin.ui.convert.StatusConverter;
import com.packtpub.twaattin.ui.convert.StatusDto;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;

import static com.vaadin.server.Sizeable.Unit.PIXELS;
import static com.vaadin.shared.ui.label.ContentMode.HTML;

public class StatusComponent extends CustomComponent {
    public StatusComponent(StatusDto dto) {
        addStyleName("p-status-component");
        ExternalResource userPage = new ExternalResource(StatusConverter.TWITTER_USER_URL +
                                            dto.getScreenName());
        Link name = new Link(dto.getName(), userPage);

        name.setStyleName("p-user-name");

        Label screenName = new Label('@' + dto.getScreenName());

        screenName.setStyleName("p-screen-name");

        HorizontalLayout names = new HorizontalLayout(name, screenName);

        names.setSpacing(true);

        Label tweet = new Label(dto.getTweet(), HTML);

        tweet.addStyleName("p-tweet");

        HorizontalLayout actionsBar = new HorizontalLayout(new Button("Reply"), new Button("Retweet"), new Button("Favorite"));

        actionsBar.setSpacing(true);

        String retweetedBy = dto.getRetweetedBy();

        VerticalLayout rightSide;

        if (retweetedBy == null) {
            rightSide = new VerticalLayout(names, tweet, actionsBar);
        } else {
            Label label = new Label("Retweeted by " + retweetedBy, HTML);

            label.addStyleName("p-retweeted-by");

            rightSide = new VerticalLayout(names, tweet, label, actionsBar);
        }

        rightSide.setSpacing(true);
        rightSide.setWidth(450, PIXELS);

        Resource pictureRes = new ExternalResource(dto.getProfileImage());
        Image picture = new Image(null, pictureRes);

        picture.setHeight(50, PIXELS);
        picture.setWidth(50, PIXELS);

        HorizontalLayout mainLayout = new HorizontalLayout(picture, rightSide);

        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        setCompositionRoot(mainLayout);
    }
}
