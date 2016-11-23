package com.packtpub.twaattin.ui.decorator;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Table;
import twitter4j.User;

public class ProfileImageColumnGenerator extends AbstractUserColumnGenerator {

    /**
     * @return Profile image of the underlying {@link User} as an {@link Image}
     *         component
     */
    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        User user = getUser(source, itemId);
        String url = user.getMiniProfileImageURL();

        if(url != null) {
            ExternalResource resource = new ExternalResource(url);

            return new Image("", resource);
        }

        return null;
    }
}
