package com.app.client.presenter;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.app.client.view.SuccessView;
import com.app.shared.GetUsers;
import com.app.shared.GetUsersResponse;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class MainPresenter extends Presenter {
	private final DispatchAsync dispatch;
	private final Display display;
	private HandlerManager eventBus;
	
	
	public interface Display {
		Widget asWidget();

		TextBox getName();
		Button userbutton();
	}

	public MainPresenter(DispatchAsync dispatch, Display display,
			HandlerManager eventBus) {
		this.display = display;
		this.dispatch = dispatch;
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		display.userbutton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				//Window.alert(display.getName().getText());
				sendToserver(display.getName().getText());
			}

			private void sendToserver(String string) {
				display.userbutton().setEnabled(false);
				
				if(display.getName().getValue().equals("")){
					Window.alert("Username is required");
					display.userbutton().setEnabled(true);
					return;
				}
				
				dispatch.execute(new GetUsers(), new AsyncCallback<GetUsersResponse>() {	
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
						Window.alert("error");
						display.userbutton().setEnabled(true);
						
					}

					public void onSuccess(GetUsersResponse result) {
						Presenter presenter=new SuccessPresenter(dispatch, new SuccessView(result.getMessage()), eventBus);
						presenter.go(RootPanel.get());
					}
				});
				
			}
		});
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}
