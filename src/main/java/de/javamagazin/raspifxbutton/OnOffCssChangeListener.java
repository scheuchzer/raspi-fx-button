package de.javamagazin.raspifxbutton;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class OnOffCssChangeListener implements ChangeListener<Boolean> {

	private static final String ON_CLASS = "On";
	private static final String OFF_CLASS = "Off";
	private Node node;

	public OnOffCssChangeListener(Node node) {
		this.node = node;
	}

	@Override
	public void changed(final ObservableValue<? extends Boolean> observable,
			final Boolean oldValue, final Boolean newValue) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ObservableList<String> styleClass = node.getStyleClass();
				styleClass.remove(ON_CLASS);
				styleClass.remove(OFF_CLASS);
				styleClass.add(newValue ? ON_CLASS : OFF_CLASS);
			}
		});
	}
}
