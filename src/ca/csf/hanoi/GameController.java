package ca.csf.hanoi;

import com.sun.javafx.geom.Rectangle;
import ca.csf.stack.LinkedListStack;

public class GameController {
	private HanoiTowers hanoiTowersGame;
	
	public GameController() {
		try {
			hanoiTowersGame = new HanoiTowers();
			hanoiTowersGame.newGame(3); //TODO Don't hardcode like that.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
