package ca.csf.hanoi.application;

import com.sun.javafx.geom.Rectangle;

import ca.csf.hanoi.Disk;
import ca.csf.hanoi.Tower;
import ca.csf.stack.LinkedListStack;

public class GameController {
	
	private Tower tower1;
	private Tower tower2;
	private Tower tower3;
	
	
	
	public void setupTowers(int numberOfDisks){
		tower1 = new Tower(new LinkedListStack());
		for (int i = 0; i < numberOfDisks; i++) {
			tower1.addDisk(new Disk(1));
		}
		tower2 = new Tower(new LinkedListStack());
		tower3 = new Tower(new LinkedListStack());
		
		for ()
	}
	
	public void updateTowers(Tower tower1, Tower tower2, Tower tower3){
		
	}
	
}
