package ca.csf.hanoi;

public class Disk {
	private final int size;
	private static final int DEFAULT_SIZE = 1;
	
	public Disk(int size){
		this.size = size;
	}

	public Disk() {
		this.size = DEFAULT_SIZE;
	}

	public int getSize() {
		return size;
	}

}
