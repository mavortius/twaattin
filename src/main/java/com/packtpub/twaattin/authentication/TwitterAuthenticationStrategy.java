package com.packtpub.twaattin.authentication;

import com.packtpub.twaattin.service.TwitterService;
import twitter4j.TwitterException;

import java.security.Principal;

public class TwitterAuthenticationStrategy implements PinAuthenticationStrategy {

    @Override
    public Principal authenticate(String pin) throws AuthenticationException {
        try {
            String screenName = TwitterService.get().authenticate(pin);

            return new User(screenName);
        } catch (TwitterException e) {
            throw new AuthenticationException(e);
        }
    }
}
