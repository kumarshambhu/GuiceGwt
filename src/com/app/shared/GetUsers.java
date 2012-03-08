package com.app.shared;

import net.customware.gwt.dispatch.shared.Action;
@SuppressWarnings("serial")
public class GetUsers implements Action<GetUsersResponse> {
	private String name;
	@Deprecated
	public GetUsers() {}
	public GetUsers(String name) {
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
