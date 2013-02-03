package de.javamagazin.raspifxbutton;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javafx.beans.property.BooleanProperty;

public class FakedHwController implements HwController {

	private BooleanProperty model;

	public FakedHwController() {
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				if (model != null) {
					model.set(!model.get());
				}
			}
		}, 1, 1, TimeUnit.SECONDS);
	}

	@Override
	public void setModel(BooleanProperty model) {
		this.model = model;
	}

}
