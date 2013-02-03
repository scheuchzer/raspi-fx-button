package de.javamagazin.raspifxbutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GuiController implements Initializable {

	private BooleanProperty model;

	@FXML
	private Button button;

	public GuiController(BooleanProperty model) {
		this.model = model;
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		model.addListener(new OnOffCssChangeListener(button));
	}

	public void onMousePressed(MouseEvent event) {
		model.set(true);
	}

	public void onMouseReleased(MouseEvent event) {
		model.set(false);
	}
}
