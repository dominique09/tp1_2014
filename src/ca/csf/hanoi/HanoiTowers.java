package ca.csf.hanoi;

import ca.csf.stack.ArrayStack;
import ca.csf.stack.LinkedListStack;

public class HanoiTowers {
	private Tower[] towers;
	private int nbrOfDisks;
	private Disk heldDisk;
	private final static int NBR_OF_TOWERS = 3;
	public final static int MIN_NBR_OF_DISKS = 3;
	public final static int MAX_NBR_OF_DISKS = 6;

	public void newGame(int numberOfDisks, boolean useArrayStack)
			throws Exception {
		if (numberOfDisks < 1)
			throw new Exception("Number of disks needs to be positive");
		else if (numberOfDisks > MAX_NBR_OF_DISKS
				&& numberOfDisks < MIN_NBR_OF_DISKS)
			throw new Exception("Number of disks is not respected");
		towers = new Tower[NBR_OF_TOWERS];
		for (int i = 0; i < NBR_OF_TOWERS; i++) {
			if (useArrayStack)
				towers[i] = new Tower(new ArrayStack(numberOfDisks));
			else
				towers[i] = new Tower(new LinkedListStack());
		}
		nbrOfDisks = numberOfDisks;
		heldDisk = null;
		for (int i = numberOfDisks; i > 0; i--) {
			towers[0].addDisk(new Disk(i));
		}
	}

	public boolean pickUpDisk(int towerPosition) {
		if (!canPickUp(towerPosition))
			return false;

		heldDisk = towers[towerPosition - 1].getDiskOnTop();
		towers[towerPosition - 1].removeDisk();
		return true;
	}

	public boolean canPickUp(int towerPosition) {
		return (heldDisk == null && towers[towerPosition - 1].getSize() > 0);
	}

	public boolean dropDisk(int towerPosition) {
		if (!canDrop(towerPosition))
			return false;

		towers[towerPosition - 1].addDisk(heldDisk);
		heldDisk = null;
		return true;
	}

	public boolean canDrop(int towerPosition) {
		return (heldDisk != null && (towers[towerPosition - 1].getSize() == 0 || heldDisk
				.getSize() < towers[towerPosition - 1].getDiskOnTop().getSize()));
	}

	public boolean isFinished() {
		return (towers[2].getSize() == nbrOfDisks);
	}

	public Tower getTower(int position) {
		return towers[position - 1];
	}

	public Disk getHeldDisk() {
		return heldDisk;
	}

}
