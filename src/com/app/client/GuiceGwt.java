package com.app.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;

import com.app.client.presenter.MainPresenter;
import com.app.client.presenter.Presenter;
import com.app.client.view.MainView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class GuiceGwt implements EntryPoint {
	
	private final DispatchAsync dispatch = new StandardDispatchAsync(new DefaultExceptionHandler());

	public void onModuleLoad() {
		HandlerManager eventBus = new HandlerManager(null);
		Presenter loginPresenter = new MainPresenter(dispatch, new MainView(), eventBus);
		loginPresenter.go(RootPanel.get());
		
	}
}
