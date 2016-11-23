package com.packtpub.twaattin.ui.decorator;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SourceColumnDecorator implements Table.ColumnGenerator {

    /**
     * @return Source of the tweet as a {@link Link} component.
     */
    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        Item item = source.getItem(itemId);
        Property<String> property = item.getItemProperty(columnId);
        Document document = Jsoup.parseBodyFragment(property.getValue());
        Elements elements = document.getElementsByTag("a");

        if(elements.size() > 0) {
            Element element = elements.get(0);
            String text = element.text();
            String url = element.absUrl("href");
            ExternalResource resource = new ExternalResource(url);
            Link link = new Link(text, resource);

            link.setTargetName("source");

            return link;
        }

        return null;
    }
}
