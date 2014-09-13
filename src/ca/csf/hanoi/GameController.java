package ca.csf.hanoi;

import com.sun.javafx.geom.Rectangle;

import ca.csf.stack.LinkedListStack;

public class GameController {
	private HanoiTowers hanoiTowers;
	
	public GameController() {
		try {
			hanoiTowers = new HanoiTowers();
			hanoiTowers.newGame(3); //TODO Don't hardcode like that.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
