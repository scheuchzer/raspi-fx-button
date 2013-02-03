package de.javamagazin.raspifxbutton;

import javafx.beans.property.BooleanProperty;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class Pi4JController implements HwController {

	private BooleanProperty model;

	private GpioController gpio;

	public Pi4JController() {
		this.gpio = GpioFactory.getInstance();

		GpioPinDigitalInput input = gpio.provisionDigitalInputPin(
				RaspiPin.GPIO_00, PinPullResistance.PULL_DOWN);
		input.addListener(new GpioPinListenerDigital() {

			@Override
			public void handleGpioPinDigitalStateChangeEvent(
					GpioPinDigitalStateChangeEvent event) {
				if (PinState.HIGH.equals(event.getState())) {
					model.set(true);
				} else {
					model.set(false);
				}
			}
		});
	}

	@Override
	public void setModel(BooleanProperty model) {
		this.model = model;
	}
}
