package de.javamagazin.raspifxbutton;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CliApp {

	public static void main(String[] args) throws InterruptedException {
		BooleanProperty model = new SimpleBooleanProperty();

		HwController hwController = new Pi4JController();
		hwController.setModel(model);

		model.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				System.out
						.println("Der Knopf ist " + (newValue ? "an" : "aus"));

			}
		});
		
		while(true) {
			Thread.sleep(2000);
		}
	}
}
