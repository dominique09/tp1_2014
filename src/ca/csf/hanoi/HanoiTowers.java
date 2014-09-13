package ca.csf.hanoi;

public class HanoiTowers {
	public Tower[] towers; // The three towers used in the game. Towers are listed from left to right.
	private int nbrOfDisks; // The number of disks set for this game.
	public Disk heldDisk; // The disk that is currently being held. (Used when picking up a disk from a tower)
	
	public HanoiTowers () { // When first created, uses the default 3-disk configuration.
		towers = new Tower[3];
	}
	
	public void newGame (int numberOfDisks) { // Begins a new game
		nbrOfDisks = numberOfDisks;
		heldDisk = null;
		for (int i = numberOfDisks; i > 0; i--){
			towers[0].addDisk(new Disk(i));
		}
	}
	
	public boolean canAcceptNewGame (int numberOfDisks){
		if (numberOfDisks > 0){ // This ensures that the requested amount of disks for a game is always a positive number.
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void pickUpDisk (int towerPosition){
		heldDisk = towers[towerPosition-1].getDiskOnTop();
		towers[towerPosition-1].removeDisk();
	}
	
	public boolean canPickUp (int towerPosition){
		if (heldDisk == null && towers[towerPosition-1].disks.isEmpty()){ // Not currently holding a disk, selected tower has disks.
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void dropDisk (int towerPosition){
		towers[towerPosition-1].addDisk(heldDisk); // Adds a disk to the tower, player is no longer holding a disk.
		heldDisk = null;
	}
	
	public boolean canDrop (int towerPosition){
		if (heldDisk != null && heldDisk.size < towers[towerPosition-1].getDiskOnTop().size){ // Currently holding a disk. Held disk is smaller than the disk on top of target tower.
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFinished () { // "Did we win?"
		if (towers[2].getSize() == nbrOfDisks){ // If the right tower has all the disks in the game.
			return true;
		}
		else {
			return false;
		}
	}
	
}
