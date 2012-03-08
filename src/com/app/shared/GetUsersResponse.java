package com.app.shared;

import net.customware.gwt.dispatch.shared.Result;
@SuppressWarnings("serial")
public class GetUsersResponse implements Result{
	public GetUsersResponse(){}
	public GetUsersResponse(String name, String message) {
		this.name=name;
		this.message=message;
	}
	private  String name;
	private  String message;
	public String getName() {
		return name;
	}
	public String getMessage() {
		return message;
	}
}