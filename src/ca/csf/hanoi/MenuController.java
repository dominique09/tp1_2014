package ca.csf.hanoi;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuController {

	@FXML Parent root;
	@FXML Button newGameButton;
	@FXML HBox bottom;
	@FXML ImageView towersImage;
	@FXML BorderPane menuBorderPane;
	@FXML Button startNewGameButton;
	@FXML ToggleGroup nbDisksGroup;
	private Stage myStage;
	
	private Boolean useArrayStack;
	
	@FXML public void startNewGame() {
		try {
			myStage = (Stage) menuBorderPane.getScene().getWindow();
			
			Stage gameStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
			GridPane root = (GridPane)loader.load();
			Scene scene = new Scene(root, 800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			gameStage.setTitle(Hanoi.TITLE);
			gameStage.setScene(scene);
			gameStage.setResizable(false);
			
			RadioButton selectedRadioButton = (RadioButton)nbDisksGroup.getSelectedToggle();
			GameController gameController = loader.getController();
			gameController.setParentReference(this);
			gameController.initialize(Character.getNumericValue(selectedRadioButton.getId().charAt(0)), useArrayStack);
			
			gameStage.show();
			
			//Hide the menu window 
			myStage.hide();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setArrayStack(Boolean useArrayStack){
		this.useArrayStack = useArrayStack;
	}
	
	public void close() {
		myStage.close();
	}
	
	public Stage getStage(){
		return myStage;
	}

}
