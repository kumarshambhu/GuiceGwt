package com.app.server.guice;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import com.app.server.GetUsersHandler;
import com.app.shared.GetUsers;

public class UserModule extends ActionHandlerModule {
	@Override
	protected void configureHandlers() {
		bindHandler(GetUsers.class,GetUsersHandler.class);
	}
}
