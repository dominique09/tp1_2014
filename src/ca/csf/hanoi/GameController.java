package ca.csf.hanoi;

import com.sun.javafx.geom.Rectangle;

import ca.csf.stack.LinkedListStack;

public class GameController {
	private HanoiTowers hanoiTowers;
	
	public GameController() {
		try {
			hanoiTowers = new HanoiTowers(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
