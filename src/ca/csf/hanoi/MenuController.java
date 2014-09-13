package ca.csf.hanoi;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuController {

	@FXML Parent root;
	@FXML Button newGameButton;
	@FXML HBox bottom;
	@FXML ComboBox<Integer> nbDisksComboBox;
	@FXML ImageView towersImage;
	@FXML GridPane menuGridPane;
	@FXML Button startNewGameButton;
	
	@FXML public void startNewGame() {
		try {
			Stage gameStage = new Stage();
			GridPane root = (GridPane)FXMLLoader.load((getClass().getResource("Game.fxml")));
			Scene scene = new Scene(root, 800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			gameStage.setTitle(Hanoi.TITLE);
			gameStage.setScene(scene);
			gameStage.setResizable(false);
			gameStage.show();
			
			//Close the menu window
			/*Stage currentStage = (Stage) root.getScene().getWindow();
			currentStage.close();*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
