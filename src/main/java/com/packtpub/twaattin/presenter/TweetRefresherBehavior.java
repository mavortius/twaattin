package com.packtpub.twaattin.presenter;

import com.packtpub.twaattin.service.TwitterService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.Table;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

public class TweetRefresherBehavior implements HasComponents.ComponentAttachListener {

    @Override
    public void componentAttachedToContainer(HasComponents.ComponentAttachEvent event) {
        Component component = event.getAttachedComponent();

        if(component instanceof Table) {
            Table table = (Table) component;

            try {
                List<Status> statuses = TwitterService.get().getTweets();
                BeanItemContainer<Status> container = new BeanItemContainer<>(Status.class);

                container.addAll(statuses);
                table.setContainerDataSource(container);
            } catch (TwitterException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
