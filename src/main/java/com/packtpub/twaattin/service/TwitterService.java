package com.packtpub.twaattin.service;

import com.vaadin.ui.UI;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class TwitterService {
    private ConfigurationBuilder builder = new ConfigurationBuilder();
    private TwitterStream twitter = null;

    private static TwitterService singleton = new TwitterService();

    private RequestToken requestToken;
    private AccessToken accessToken;

    public TwitterService() {
        builder.setDebugEnabled(true)
                .setOAuthConsumerKey("A4hS1wrQt1TJ81eZ9L9aoti3l")
                .setOAuthConsumerSecret("NPBEQxNikcOMjSGd8NroDIQpgWfpj2MgfN2h5upaXvDtBI5OWt")
                .setOAuthAccessToken("568429611-OU8LJpBHSLl9YbepJQsj9lkgta8olOflCi4p6Kpb")
                .setOAuthAccessTokenSecret("ds7qWiacTCLZBZTRCs2RNc61B5VcJhNl3Ejur0j2uNABf");

        TwitterStreamFactory factory = new TwitterStreamFactory(builder.build());
        twitter = factory.getInstance();

        twitter.addListener((UserStreamListener) UI.getCurrent());
    }

    public static TwitterService get() {
        return singleton;
    }

    public String getAuthenticationUrl() {
        twitter.setOAuthAccessToken(null);

        try {
            requestToken = twitter.getOAuthRequestToken();

            return requestToken.getAuthenticationURL();
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
    }

    public String authenticate(String pin) throws TwitterException {
        accessToken = twitter.getOAuthAccessToken(requestToken, pin);
        requestToken = null;

        twitter.setOAuthAccessToken(accessToken);
        twitter.user();

        return twitter.getScreenName();
    }

}
