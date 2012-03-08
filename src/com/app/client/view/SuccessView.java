package com.app.client.view;

import com.app.client.presenter.SuccessPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
public class SuccessView extends Composite implements SuccessPresenter.Display {

	private static SuccessViewUiBinder uiBinder = GWT
			.create(SuccessViewUiBinder.class);

	interface SuccessViewUiBinder extends UiBinder<Widget, SuccessView> {
	}

	public SuccessView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button close;
	
	@UiField
	Label serverReply;

	public SuccessView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		serverReply.setText(firstName);
		close.setText("Close");
	}

	@Override
	public Button closeButton() {
		return close;
	}

}
