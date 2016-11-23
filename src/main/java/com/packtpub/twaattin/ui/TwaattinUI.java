package com.packtpub.twaattin.ui;

import static com.vaadin.server.Sizeable.Unit.PIXELS;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class TwaattinUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalSplitPanel panel = new HorizontalSplitPanel();

        panel.setFirstComponent(new LoginScreen());
        panel.setSecondComponent(new TimelineScreen());
        panel.setSplitPosition(400, PIXELS);

        setContent(panel);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = TwaattinUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
