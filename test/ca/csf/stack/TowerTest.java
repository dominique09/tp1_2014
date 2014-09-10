package ca.csf.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TowerTest {

	private Tower tower;
	
	@Before
	public void setUp() throws Exception {
		tower = new Tower(new LinkedListStack());
	}
	
	@Test
	public void whenTowerCreated_thenTowerIsEmpty() {
		assertEquals(0,tower.getSize());
	}
	
	@Test
	public void whenAddDiskToTower_thenTowerIsNotEmpty() {
		tower.addDisk(new Disk());
		assertNotEquals(0,tower.getSize());
	}
	
	@Test
	public void whenAddDiskToTower_thenDiskOnTopIsLastSendedDisk() {
		Disk disk = new Disk();
		tower.addDisk(disk);
		assertSame(disk,tower.getDiskOnTop());
	}
	
	@Test
	public void whenAddDiskToTower_thenDiskIsNotRemoved() {
		Disk disk = new Disk();
		tower.addDisk(disk);
		assertEquals(1,tower.getSize());
	}
	
	@Test
	public void whenGetDiskOnTopOfEmptyTower_thenNullIsReturned() {
		assertNull(tower.getDiskOnTop());
	}
	
	@Test
	public void whenAddDiskToTowerAndRemoveIt_thenDiskIsReturned() {
		Disk disk = new Disk();
		tower.addDisk(disk);
		
		Disk returnedDisk = tower.removeDisk();
		
		assertSame(disk, returnedDisk);
	}
	
	@Test
	public void whenAddDiskToTowerAndRemoveIt_thenTowerIsEmpty() {
		tower.addDisk(new Disk());
		
		tower.removeDisk();
		
		assertEquals(0, tower.getSize());
	}
	
	@Test
	public void whenAddElementInTowerAndGet_thenDiskIsReturned() {
		Disk disk = new Disk();
		
		tower.addDisk(disk);
		Disk returnedDisk = tower.getDiskAt(0);
		
		assertSame(disk, returnedDisk);
	}
	
	@Test
	public void whenAddTwoElementsInStackAndGet_thenElementIsReturned() {
		Disk disk1 = new Disk();
		Disk disk2 = new Disk();
		
		tower.addDisk(disk1);
		tower.addDisk(disk2);
		Disk returnedDisk1 = tower.getDiskAt(0);
		Disk returnedDisk2 = tower.getDiskAt(1);
		
		assertSame(disk2, returnedDisk1);
		assertSame(disk1, returnedDisk2);
	}
	
	
	@Test
	public void whenClearTowerThatContainsDisk_thenTowerSizeBecomeZero() {
		tower.addDisk(new Disk());
		
		tower.clear();
		
		assertEquals(0, tower.getSize());
	}

}
