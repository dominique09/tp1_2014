package ca.csf.hanoi;

import ca.csf.stack.LinkedListStack;

public class HanoiTowers {
	private Tower[] towers;
	// The three towers used in the game. Towers are listed from left to right.
	private int nbrOfDisks; // The number of disks set for this game.
	public Disk heldDisk; // The disk that is currently being held. (Used when picking up a disk from a tower
	private final static int NBR_OF_TOWERS = 3;
	
	public void newGame (int numberOfDisks) throws Exception { // Begins a new game
		towers = new Tower[NBR_OF_TOWERS];
		for (int i = 0; i < NBR_OF_TOWERS; i++) {
			towers[i] = new Tower(new LinkedListStack());
		}
		nbrOfDisks = numberOfDisks;
		heldDisk = null;
		if (numberOfDisks < 1) throw new Exception("Number of disks needs to be greater than 0");
		for (int i = numberOfDisks; i > 0; i--){
			towers[0].addDisk(new Disk(i));
		}
	}
 
	public void pickUpDisk (int towerPosition){
		heldDisk = towers[towerPosition-1].getDiskOnTop();
		towers[towerPosition-1].removeDisk();
	}
	
	public boolean canPickUp (int towerPosition){
		return (heldDisk == null && towers[towerPosition-1].getSize() > 0); // Not currently holding a disk, selected tower has disks.
	}
	
	public void dropDisk (int towerPosition){
		towers[towerPosition-1].addDisk(heldDisk); // Adds a disk to the tower, player is no longer holding a disk.
		heldDisk = null;
	}
	
	public boolean canDrop (int towerPosition){
		return (heldDisk != null && heldDisk.getSize() < towers[towerPosition-1].getDiskOnTop().getSize()); // Currently holding a disk. Held disk is smaller than the disk on top of target tower.
	}
	
	public boolean isFinished () { // "Did we win?"
		return (towers[2].getSize() == nbrOfDisks); // If the right tower has all the disks in the game.
	}
	
	public Tower getTower(int position){
		return towers[position-1];
	}
	
}
