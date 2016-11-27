package com.packtpub.twaattin.authentication;

import java.io.Serializable;
import java.security.Principal;

/**
 * Simplest implementation of a {@link Principal}.
 */
public class User implements Principal, Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;

    /**
     * Only {@link UserPasswordAuthenticationStrategy} may create new instances.
     *
     * @param name
     */
    User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
