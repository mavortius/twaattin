package com.packtpub.twaattin.ui.decorator;

import com.vaadin.ui.Table;
import twitter4j.User;

public class NameColumnGenerator extends AbstractUserColumnGenerator {

    /**
     * @return User name of the underlying {@link User}
     */
    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        User user = getUser(source, itemId);

        return user.getScreenName();
    }
}
