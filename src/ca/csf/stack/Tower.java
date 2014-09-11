package ca.csf.stack;

public class Tower {
	
	Stack disks;
	
	public Tower(Stack stack) {
		disks = new LinkedListStack();
	}

	public void addDisk(Disk disk){
		disks.push(disk);
	}

	public Disk removeDisk() {
		return (Disk)disks.pop();
	}

	public Disk getDiskOnTop() {
		return (Disk)disks.peek();
	}

	public Disk getDiskAt(int position) {
		return (Disk)disks.getAt(position);
	}

	public int getSize() {
		return disks.getSize();
	}

	public void clear() {
		disks.clear();
	}
	
}
