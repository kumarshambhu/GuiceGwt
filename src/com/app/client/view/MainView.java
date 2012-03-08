package com.app.client.view;

import com.app.client.presenter.MainPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
public class MainView extends Composite implements MainPresenter.Display {

	private static MainViewUiBinder uiBinder = GWT
			.create(MainViewUiBinder.class);

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	
	@UiField
	Button button;
	
	@UiField
	TextBox username;

	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText("Get Name");
	}

	/*@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}*/

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@Override
	public TextBox getName() {
		return username;
	}

	@Override
	public Button userbutton() {
		return button;
	}

}
