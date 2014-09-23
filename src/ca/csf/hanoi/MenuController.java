package ca.csf.hanoi;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;

public class MenuController {

	@FXML Parent root;
	@FXML Button newGameButton;
	@FXML HBox bottom;
	@FXML ImageView towersImage;
	@FXML GridPane menuGridPane;
	@FXML Button startNewGameButton;
	@FXML ToggleGroup nbDisksGroup;
	
	private Boolean useArrayStack;
	
	@FXML public void startNewGame() {
		try {
			
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
			gameController.initialize(Character.getNumericValue(selectedRadioButton.getId().charAt(0)));
			
			gameStage.show();
			//Close the menu window
			//Stage currentStage = (Stage) root.getScene().getWindow();
			//currentStage.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setArrayStack(Boolean useArrayStack){
		this.useArrayStack = useArrayStack;
	}

}
