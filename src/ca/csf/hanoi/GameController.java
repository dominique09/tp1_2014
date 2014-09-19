package ca.csf.hanoi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameController {
	private HanoiTowers hanoiTowersGame;
	@FXML GridPane mainGridPane;
	
	private static final int DISK_HEIGHT = 25;
	private static final int TOWERS_ROW = 1;
	private static final int DISK_WIDTH_MULTIPLIER = 30;
	
	private Button[] pickupButtons;
	private Button[] dropButtons;
	private VBox[] towerVBoxes;
	
	@FXML VBox leftVBox;
	@FXML VBox centerVBox;
	@FXML VBox rightVBox;
	
	@FXML Button drop1;
	@FXML Button drop2;
	@FXML Button drop3;
	@FXML Button pickup1;
	@FXML Button pickup2;
	@FXML Button pickup3;
	
	@FXML
	public void initialize() {
		try {
			hanoiTowersGame = new HanoiTowers();
			hanoiTowersGame.newGame(3);
			
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
			
			updateRectangles();
			updateButtons();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void updateRectangles() {
		for (int i = 0; i < towerVBoxes.length; ++i){ // For each VBox ...
			towerVBoxes[i].getChildren().clear();
			for (int j=0; j < hanoiTowersGame.towers[i].getSize(); ++j){ // For each disk
				Rectangle rectangle = new Rectangle(hanoiTowersGame.towers[i].getDiskAt(j).getSize()*DISK_WIDTH_MULTIPLIER,DISK_HEIGHT);
				towerVBoxes[i].getChildren().add(rectangle);
			}
		}
	}
	
	private void updateButtons() {
		for (int i = 0; i < towerVBoxes.length; ++i) {
			pickupButtons[i].setDisable(!hanoiTowersGame.canPickUp(i+1));
			dropButtons[i].setDisable(!hanoiTowersGame.canDrop(i));
		}
	}
	
	private enum rectangleColors{
		COLOR1, COLOR2, COLOR3, COLOR4, COLOR5, COLOR6
	}

	@FXML public void drop(ActionEvent event) {
		Button sender = (Button)event.getSource();
		// DEBUG
		System.out.println(sender.toString());
		int towerNumber = Integer.parseInt(sender.getId().substring(sender.getId().length()-1));
		hanoiTowersGame.dropDisk(towerNumber);
		updateRectangles();
		updateButtons();
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
}