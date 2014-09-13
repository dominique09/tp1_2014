package ca.csf.hanoi;

public class HanoiTowers {
	public Tower[] towers; // The three towers used in the game. Towers are listed from left to right.
	private int nbDisks; // The number of disks set for this game.
	// ***UNNEEDED*** public Disk heldDisk; // A reference to the disk that is currently being held. (Used when picking up a disk from a tower)
	
	public HanoiTowers (int numberOfDisks) throws Exception { // When first created, uses the default 3-disk configuration.
		
		if (numberOfDisks < 1) throw new Exception("Number of disks needs to be at least 1");
		towers = new Tower[3];
		nbDisks = numberOfDisks;
		
		for (int i = numberOfDisks; i > 0; i--){
			towers[0].addDisk(new Disk(i));
		}
	}
	
	public boolean switchDisk (int initialTower, int finalTower) {
		if (towers[initialTower-1].getDiskOnTop().getSize() > towers[finalTower].getDiskOnTop().getSize()){
			towers[finalTower].addDisk(towers[initialTower].getDiskOnTop());
			towers[initialTower].removeDisk();
			return true;
		}
		return false;
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
