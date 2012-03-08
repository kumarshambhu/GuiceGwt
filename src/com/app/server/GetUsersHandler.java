package com.app.server;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.app.shared.GetUsers;
import com.app.shared.GetUsersResponse;

public class GetUsersHandler implements ActionHandler<GetUsers, GetUsersResponse> {
	public GetUsersResponse execute(GetUsers arg0, ExecutionContext arg1)
			throws ActionException {
		return new GetUsersResponse(arg0.getName(), "Server Communication is successful !");
	}
	
	public Class<GetUsers> getActionType() {
		return GetUsers.class;
	}

	public void rollback(GetUsers arg0, GetUsersResponse rg1,
			ExecutionContext arg2) throws ActionException {
	}

}
