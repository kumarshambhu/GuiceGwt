package com.app.server.guice;

import net.customware.gwt.dispatch.server.guice.GuiceStandardDispatchServlet;

import com.google.inject.servlet.ServletModule;
public class DispatchServletModule extends ServletModule {
    @Override
    public void configureServlets() {
        serve( "/guicegwt/dispatch" ).with( GuiceStandardDispatchServlet.class );
    }
}
