package ca.csf.hanoi;

public class HanoiTowers {
	public Tower[] towers; // The three towers used in the game. Towers are listed from left to right.
	private int nbDisks; // The number of disks set for this game.
	// ***UNNEEDED*** public Disk heldDisk; // A reference to the disk that is currently being held. (Used when picking up a disk from a tower)
	
	public HanoiTowers (int numberOfDisks) throws Exception { // When first created, uses the default 3-disk configuration.
		
		if (numberOfDisks > 0) throw new Exception("Number of disks needs to be at least 1");
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
	
	
	
}
