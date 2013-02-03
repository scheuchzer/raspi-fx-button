package de.javamagazin.raspifxbutton;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiOnlyApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BooleanProperty model = new SimpleBooleanProperty();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gui.fxml"));
		fxmlLoader.setController(new GuiController(model));
		Parent root = (Parent) fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}