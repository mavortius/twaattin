package com.packtpub.twaattin.ui;

import com.packtpub.twaattin.presenter.TweetRefresherBehavior;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.SystemError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.ui.UI;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Push
public class TwaattinUI extends UI implements UserStreamListener {

    private TweetRefresherBehavior tweetRefresherBehavior = new TweetRefresherBehavior();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new LoginScreen());
    }

    public static TwaattinUI getCurrent() {
        return (TwaattinUI) UI.getCurrent();
    }

    public TweetRefresherBehavior getTweetRefresherBehavior() {
        return tweetRefresherBehavior;
    }

    @Override
    public void onException(Exception e) {
        setComponentError(new SystemError(e));
    }

    @Override
    public void onStatus(Status status) {
        access(() -> tweetRefresherBehavior.updatedStatus(status));
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onDeletionNotice(long l, long l1) {

    }

    @Override
    public void onFriendList(long[] longs) {

    }

    @Override
    public void onFavorite(User user, User user1, Status status) {

    }

    @Override
    public void onUnfavorite(User user, User user1, Status status) {

    }

    @Override
    public void onFollow(User user, User user1) {

    }

    @Override
    public void onUnfollow(User user, User user1) {

    }

    @Override
    public void onDirectMessage(DirectMessage directMessage) {

    }

    @Override
    public void onUserListMemberAddition(User user, User user1, UserList userList) {

    }

    @Override
    public void onUserListMemberDeletion(User user, User user1, UserList userList) {

    }

    @Override
    public void onUserListSubscription(User user, User user1, UserList userList) {

    }

    @Override
    public void onUserListUnsubscription(User user, User user1, UserList userList) {

    }

    @Override
    public void onUserListCreation(User user, UserList userList) {

    }

    @Override
    public void onUserListUpdate(User user, UserList userList) {

    }

    @Override
    public void onUserListDeletion(User user, UserList userList) {

    }

    @Override
    public void onUserProfileUpdate(User user) {

    }

    @Override
    public void onUserSuspension(long l) {

    }

    @Override
    public void onUserDeletion(long l) {

    }

    @Override
    public void onBlock(User user, User user1) {

    }

    @Override
    public void onUnblock(User user, User user1) {

    }

    @Override
    public void onRetweetedRetweet(User user, User user1, Status status) {

    }

    @Override
    public void onFavoritedRetweet(User user, User user1, Status status) {

    }

    @Override
    public void onQuotedTweet(User user, User user1, Status status) {

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = TwaattinUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {   }
}
