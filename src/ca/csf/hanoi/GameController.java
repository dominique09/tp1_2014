package ca.csf.hanoi;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import ca.csf.stack.LinkedListStack;

public class GameController {
	private HanoiTowers hanoiTowersGame;
	private GridPane mainGridPane;
	
	private static final int DISK_HEIGHT = 25;
	private static final int TOWERS_ROW = 1;
	
	public GameController() {
		try {
			hanoiTowersGame = new HanoiTowers();
			hanoiTowersGame.newGame(3); //TODO Don't hardcode like that.
			for (Tower tower : hanoiTowersGame.towers) { // Pour chaque tour
				for (int i = 0; i < tower.getSize(); i++){ // ... et pour chaque disque
					Rectangle rectangle = new Rectangle(24,24);
					rectangle.setFill(Color.PINK);
					mainGridPane.add(rectangle, 0, 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateRectangles(){
		
	}
}