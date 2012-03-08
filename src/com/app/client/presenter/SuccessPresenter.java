package com.app.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.app.client.presenter.MainPresenter.Display;
import com.app.client.view.MainView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SuccessPresenter extends Presenter {
	private final DispatchAsync dispatch;
	private final Display display;
	private HandlerManager eventBus;

	public interface Display {
		Widget asWidget();

		Button closeButton();
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public SuccessPresenter(DispatchAsync dispatch, Display display,
			HandlerManager eventBus) {
		this.display = display;
		this.dispatch = dispatch;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		display.closeButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				Presenter loginPresenter = new MainPresenter(dispatch, new MainView(), eventBus);
				loginPresenter.go(RootPanel.get());
			}

		});
	}
}
