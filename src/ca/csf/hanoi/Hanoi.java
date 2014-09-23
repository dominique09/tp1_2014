package ca.csf.hanoi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hanoi extends Application {

	public static final String TITLE = "Hanoi - 1360025 - 1140776 - 1335162";

	@Override
	public void start(Stage primaryStage) {
		try { // Starts the JavaFX application

			Boolean useArrayStack = Boolean.valueOf((this.getParameters().getNamed().get("useArrayStack")));
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
			BorderPane root = (BorderPane)loader.load();
			((MenuController)loader.getController()).setArrayStack(useArrayStack);
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle(TITLE);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
