package com.packtpub.twaattin.service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.util.List;

public class TwitterService {
    private Twitter twitter = TwitterFactory.getSingleton();

    private static TwitterService singleton = new TwitterService();

    private RequestToken requestToken;
    private AccessToken accessToken;

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

        return twitter.getScreenName();
    }

    public List<Status> getTweets() throws TwitterException {
        return twitter.getUserTimeline();
    }
}
