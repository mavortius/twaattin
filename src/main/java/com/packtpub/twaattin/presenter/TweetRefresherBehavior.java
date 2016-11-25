package com.packtpub.twaattin.presenter;

import com.packtpub.twaattin.ui.StatusComponent;
import com.packtpub.twaattin.ui.convert.StatusConverter;
import com.packtpub.twaattin.ui.convert.StatusDto;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.Layout;
import twitter4j.Status;

public class TweetRefresherBehavior implements HasComponents.ComponentAttachListener {
    private Layout layout;

    public void updatedStatus(Status status) {
        if(layout != null) {
            StatusConverter converter = new StatusConverter();
            StatusDto dto = converter.convert(status);
            StatusComponent component = new StatusComponent(dto);

            layout.addComponent(component);
        }
    }

    @Override
    public void componentAttachedToContainer(HasComponents.ComponentAttachEvent event) {
        Component component = event.getAttachedComponent();

        if(component instanceof Layout) {
            layout = (Layout) component;
        }
    }
}
