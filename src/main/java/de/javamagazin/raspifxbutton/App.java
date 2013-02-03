package de.javamagazin.raspifxbutton;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		BooleanProperty model = new SimpleBooleanProperty();

		HwController hwController = createHwController();
		hwController.setModel(model);

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"Gui.fxml"));
		fxmlLoader.setController(new GuiController(model));
		Parent root = (Parent) fxmlLoader.load();
		
		Scene scene = new Scene(root);
		stage.setTitle("Raspi-Fx-Button");
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}

	private HwController createHwController() {
		try {
			String controllerClass = getParameters().getNamed().get(
					"hw-controller");
			if (controllerClass != null) {
				return (HwController) Class.forName(controllerClass)
						.newInstance();
			} else {
				return new Pi4JController();
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to initialize HwController.", e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
