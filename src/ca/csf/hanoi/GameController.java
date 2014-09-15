package ca.csf.hanoi;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import com.sun.javafx.geom.Rectangle;

import ca.csf.stack.LinkedListStack;

public class GameController {
	private HanoiTowers hanoiTowersGame;
	private GridPane mainGridPane;
	
	private static final int DISK_HEIGHT = 25;
	private static final int TOWERS_ROW = 2;
	
	public GameController() {
		try {
			hanoiTowersGame = new HanoiTowers();
			hanoiTowersGame.newGame(3); //TODO Don't hardcode like that.
			for (Tower tower : hanoiTowersGame.towers) { // Pour chaque tour
				for (int i = 0; i < tower.getSize(); i++){ // ... et pour chaque disque
					Rectangle rectangle = new Rectangle(24,24);
					mainGridPane.add(rectangle, 0, TOWERS_ROW);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateRectangles(){
		
	}
}