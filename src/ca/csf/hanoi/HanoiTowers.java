package ca.csf.hanoi;

public class HanoiTowers {
	public Tower[] towers; // The three towers used in the game. Towers are listed from left to right.
	private int nbrOfDisks; // The number of disks set for this game.
	public Disk heldDisk; // The disk that is currently being held. (Used when picking up a disk from a tower)
	
	public HanoiTowers () { // When first created, uses the default 3-disk configuration.
		towers = new Tower[3];
		newGame(3);
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
	
	
	
}
