package com.packtpub.twaattin.ui.decorator;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import twitter4j.Status;
import twitter4j.URLEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.vaadin.shared.ui.label.ContentMode.HTML;

public class TweetColumnDecorator implements Table.ColumnGenerator {
    private static final String TWITTER_SEARCH_URL = "http://twitter.com/search/";
    private static final String TWITTER_USER_URL = "https://twitter.com/";

    private List<TweetFragment> fragments;

    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        fragments = new ArrayList<>();
        Item item = source.getItem(itemId);
        BeanItem<Status> beanItem = (BeanItem) item;
        Status status = beanItem.getBean();

        createFragmentsWithUrl(status.getURLEntities());
        createFragmentsWithTag(status.getHashtagEntities());
        createFragmentsWithMention(status.getUserMentionEntities());

        Collections.sort(fragments);

        StringBuilder builder = new StringBuilder(status.getText());
        int offset = 0;

        for (TweetFragment fragment : fragments) {
            builder.replace(fragment.getStart() + offset, fragment.getEnd()
                    + offset, fragment.getReplacement());
            offset += fragment.getOffset();
        }

        return new Label(builder.toString(), HTML);
    }

    void createFragmentsWithUrl(URLEntity[] urls) {
        if(urls != null) {
            for(URLEntity url : urls) {
                String expandedUrl = url.getExpandedURL();
                int start = url.getStart();
                int end = url.getEnd();
                String href = "<a href='" + expandedUrl
            }
        }
    }

    class TweetFragment implements Comparable<TweetFragment> {
        private final int start;
        private final int end;
        private final String replacement;

        TweetFragment(int start, int end, String replacement) {
            this.start = start;
            this.end = end;
            this.replacement = replacement;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public String getReplacement() {
            return replacement;
        }

        public int getOffset() {
            return replacement.length() - end + start;
        }

        @Override
        public int compareTo(TweetFragment o) {
            return start - o.start;
        }
    }
}
