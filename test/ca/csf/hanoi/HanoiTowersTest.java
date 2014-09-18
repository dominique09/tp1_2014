package ca.csf.hanoi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HanoiTowersTest {
	
	private HanoiTowers hanoiTowers;

	@Before
	public void setUp() throws Exception {
		hanoiTowers = new HanoiTowers();
	}

	@Test
	public void forHanoiTowers_whenTryingNewGameWithZeroDisks_cantAcceptNewGame() {
		// I have no idea
	}
	
	@Test
	public void forHanoiTowers_whenPickingUpSingleDisk_heldDiskSizeIsOne() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hanoiTowers.pickUpDisk(1);
		
		assertTrue(hanoiTowers.heldDisk.getSize() == 1);
		
	}
	
	@Test
	public void forHanoiTowers_whenPickingUpSingleDiskDroppingItElsewhereThenPickingUpSecondDisk_heldDiskSizeIsTwo() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hanoiTowers.pickUpDisk(1);
		
		hanoiTowers.dropDisk(3);
		
		hanoiTowers.pickUpDisk(1);
		
		assertTrue(hanoiTowers.heldDisk.getSize() == 2);
		
	}
	
	@Test
	public void forHanoiTowers_whenDoingClassicThreeDiskGameAndSolvingIt_isFinishedReturnsTrue() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hanoiTowers.pickUpDisk(1);// 123 0 0 (Memory aid for positions)
		hanoiTowers.dropDisk(3); // 23 0 1
		hanoiTowers.pickUpDisk(1);
		hanoiTowers.dropDisk(2); // 3 2 1
		hanoiTowers.pickUpDisk(3); 
		hanoiTowers.dropDisk(2); // 3 12 0
		hanoiTowers.pickUpDisk(1);
		hanoiTowers.dropDisk(3); // 0 12 3
		hanoiTowers.pickUpDisk(2);
		hanoiTowers.dropDisk(1); // 1 2 3
		hanoiTowers.pickUpDisk(2);
		hanoiTowers.dropDisk(3); // 1 0 23
		hanoiTowers.pickUpDisk(1);
		hanoiTowers.dropDisk(3); // 0 0 123
		
		assertTrue(hanoiTowers.isFinished());
		
	}
	
	@Test
	public void forHanoiTowers_whenTryingToPickUpFromEmptyTower_canPickUpReturnsFalse() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(hanoiTowers.canPickUp(3));
		assertFalse(hanoiTowers.canPickUp(2));
		
	}
	
	@Test
	public void forHanoiTowers_afterPickingUpADisk_canPickUpReturnsFalse() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hanoiTowers.pickUpDisk(1);
		
		assertFalse(hanoiTowers.canPickUp(1));
		
	}
	
	@Test
	public void forHanoiTowers_whenTryingToDropADiskOnTopOfASmallerOne_canDropReturnsFalse() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hanoiTowers.pickUpDisk(1);
		hanoiTowers.dropDisk(3);
		hanoiTowers.pickUpDisk(1);
		
		assertFalse(hanoiTowers.canDrop(3));
	}
	
	@Test
	public void forHanoiTowers_whenNotHoldingDisk_canDropReturnsFalse() {
		try {
			hanoiTowers.newGame(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(hanoiTowers.canDrop(1));
		assertFalse(hanoiTowers.canDrop(2));
		assertFalse(hanoiTowers.canDrop(3));
	}
	

}
