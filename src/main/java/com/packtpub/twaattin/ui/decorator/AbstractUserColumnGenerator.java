package com.packtpub.twaattin.ui.decorator;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.ui.Table;
import twitter4j.User;

public abstract class AbstractUserColumnGenerator  implements Table.ColumnGenerator {
    /**
     * @param source
     *            Table component
     * @param itemId
     *            Item ID
     * @return Tweet's underlying {@link User}
     */
    protected User getUser(Table source, Object itemId) {
        Item item = source.getItem(itemId);
        Property<User> property = item.getItemProperty("user");

        return property.getValue();
    }
}
