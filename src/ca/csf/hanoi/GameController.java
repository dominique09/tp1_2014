package ca.csf.hanoi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class GameController implements EventHandler<WindowEvent> {
	private HanoiTowers hanoiTowersGame;
	@FXML GridPane mainGridPane;
	
	private static final int DISK_HEIGHT = 25;
	private static final int DISK_WIDTH_MULTIPLIER = 30;
	
	private int nbOfDisks;
	
	private Button[] pickupButtons;
	private Button[] dropButtons;
	private VBox[] towerVBoxes;
	
	private String[] rectangleColors;
	
	private MenuController parentReference;
	
	private Stage myStage;
	
	@FXML VBox leftVBox;
	@FXML VBox centerVBox;
	@FXML VBox rightVBox;
	
	@FXML Button drop1;
	@FXML Button drop2;
	@FXML Button drop3;
	@FXML Button pickup1;
	@FXML Button pickup2;
	@FXML Button pickup3;
	
	
	public void initialize(int nbDisks, boolean useArrayStack) {
		try {
			myStage = (Stage) mainGridPane.getScene().getWindow();
			myStage.setOnCloseRequest(this);
			
			nbOfDisks = nbDisks;
			hanoiTowersGame = new HanoiTowers();
			hanoiTowersGame.newGame(nbOfDisks, useArrayStack);
			
			pickupButtons = new Button[3];
			pickupButtons[0] = pickup1;
			pickupButtons[1] = pickup2;
			pickupButtons[2] = pickup3;
			
			dropButtons = new Button[3];
			dropButtons[0] = drop1;
			dropButtons[1] = drop2;
			dropButtons[2] = drop3;
			
			towerVBoxes = new VBox[3];
			towerVBoxes[0] = leftVBox;
			towerVBoxes[1] = centerVBox;
			towerVBoxes[2] = rightVBox;
			
			rectangleColors = new String[6];
			
			for (String element : rectangleColors){
				element = "000000"; // Reset all colors to black
			}
			// Hex codes for disks' colors
			rectangleColors[0] = "aaaaaa";
			rectangleColors[1] = "888888";
			rectangleColors[2] = "666666";
			rectangleColors[3] = "444444";
			rectangleColors[4] = "222222";
			rectangleColors[5] = "000000";
			
			updateRectangles();
			updateButtons();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void updateRectangles() {
		for (int i = 1; i <= towerVBoxes.length; ++i){ // For each VBox ...
			towerVBoxes[i-1].getChildren().clear();
			for (int j=1; j <= hanoiTowersGame.getTower(i).getSize(); ++j){ // For each disk
				int diskSize = hanoiTowersGame.getTower(i).getDiskAt(j-1).getSize();
				Rectangle rectangle = new Rectangle(diskSize*DISK_WIDTH_MULTIPLIER, DISK_HEIGHT, Color.web(rectangleColors[diskSize-1]));
				towerVBoxes[i-1].getChildren().add(rectangle);
			}
		}
	}
	
	private void updateButtons() {
		for (int i = 1; i <= towerVBoxes.length; ++i) {
			pickupButtons[i-1].setDisable(!hanoiTowersGame.canPickUp(i));
			dropButtons[i-1].setDisable(!hanoiTowersGame.canDrop(i));
		}
	}

	@FXML public void drop(ActionEvent event) {
		Button sender = (Button)event.getSource();
		// DEBUG
		System.out.println(sender.toString());
		int towerNumber = Integer.parseInt(sender.getId().substring(sender.getId().length()-1));
		hanoiTowersGame.dropDisk(towerNumber);
		updateRectangles();
		updateButtons();
		checkIfFinished();
	}

	private void checkIfFinished() {
		if (hanoiTowersGame.isFinished()){
			
			try {
				Stage stage = new Stage(StageStyle.UTILITY);
				stage.initOwner(mainGridPane.getScene().getWindow());
				stage.initModality(Modality.WINDOW_MODAL);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EndGame.fxml"));
				Parent parent = (Parent) fxmlLoader.load();
				EndGameController endGameController = fxmlLoader.getController();
				endGameController.setMessage("Vous avez gagné ! Voulez-vous rejouer une partie ?");
				endGameController.setParentReference(this);
				Scene scene = new Scene(parent,400,200);
				stage.setScene(scene);
				stage.showAndWait();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	@FXML public void pickUp(ActionEvent event) {
		Button sender = (Button)event.getSource();
		// DEBUG
		System.out.println(sender.toString());
		int towerNumber = Integer.parseInt(sender.getId().substring(sender.getId().length()-1));
		hanoiTowersGame.pickUpDisk(towerNumber);
		updateRectangles();
		updateButtons();
	}

	public MenuController getParentReference() {
		return parentReference;
	}

	public void setParentReference(MenuController parentReference) {
		this.parentReference = parentReference;
	}
	
	public void close(){
		myStage.close();
	}

	@Override
	public void handle(WindowEvent arg0) {
		parentReference.close();
	}
	
	
}