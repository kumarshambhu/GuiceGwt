package com.app.server.guice;

import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
public class MyGuiceServletConfig extends GuiceServletContextListener {
	@Override
	 protected Injector getInjector() {
		  return Guice.createInjector(new ServerDispatchModule(), new UserModule(), new DispatchServletModule());
		 }
}
