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
	public void forHanoiTower_whenStartNewGameWithZeroDisk_thenCatchException(){
		try {
			hanoiTowers.newGame(0, false);
			assert false;
		} catch (Exception e) {
			assert true;
		}
	}
	
	@Test
	public void forHanoiTower_whenStartNewGameWithTwoDisks_thenCatchException(){
		try {
			hanoiTowers.newGame(2, false);
			assert false;
		} catch (Exception e) {
			assert true;
		}
	}
	
	@Test
	public void forHanoiTower_whenStartNewGameWithThreeDisks_thenNoException(){
		try {
			hanoiTowers.newGame(3, false);
			assert true;
		} catch (Exception e) {
			assert false;
		}
	}
	
	@Test
	public void forHanoiTower_whenStartNewGameWithSixDisks_thenReturnTrue(){
		try {
			hanoiTowers.newGame(6, false);
			assert true;
		} catch (Exception e) {
			assert false;
		}
	}
	
	@Test
	public void forHanoiTower_whenStartNewGameWithSevenDisks_thenReturnFalse(){
		try {
			hanoiTowers.newGame(7, false);
			assert false;
		} catch (Exception e) {
			assert true;
		}
	}
	
	@Test
	public void forHanoiTower_whenPickUpDiskOneTime_thenReturnTrue(){
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		assertTrue(hanoiTowers.pickUpDisk(1));
	}
	
	@Test
	public void forHanoiTower_whenPickUpDiskTwoTimes_thenReturnFalse(){
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		hanoiTowers.pickUpDisk(1);
		assertFalse(hanoiTowers.pickUpDisk(1));
	}
	
	@Test
	public void forHanoiTowers_whenPickingUpSingleDisk_thenHeldDiskSizeIsOne() {
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		hanoiTowers.pickUpDisk(1);	
		assertEquals(1, hanoiTowers.getHeldDisk().getSize());
	}
	
	@Test
	public void forHanoiTower_whenPickUpDiskDropDiskPickupDiskSecondTime_thenHeldDiskSizeIsTwo(){
		try {
			hanoiTowers.newGame(4, false);
		} catch (Exception e) {
			assert false;
		}
		
		hanoiTowers.pickUpDisk(1);
		hanoiTowers.dropDisk(3);
		hanoiTowers.pickUpDisk(1);
		assertEquals(2, hanoiTowers.getHeldDisk().getSize());
	}
	
	@Test
	public void forHanoiTowers_whenDoingClassicThreeDiskGameAndSolvingIt_isFinishedReturnsTrue() {
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
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
	public void forHanoiTower_whenGameStart_isFinishedReturnFalse(){
		try {
			hanoiTowers.newGame(5, false);
		} catch (Exception e) {
			assert false;
		}
		assertFalse(hanoiTowers.isFinished());
	}
	
	@Test
	public void forHanoiTowers_whenTryingToPickUpFromEmptyTower_canPickUpReturnsFalse() {
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		assertFalse(hanoiTowers.canPickUp(3));
		assertFalse(hanoiTowers.canPickUp(2));
		
	}
	
	@Test
	public void forHanoiTowers_afterPickingUpADisk_canPickUpReturnsFalse() {
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		hanoiTowers.pickUpDisk(1);
		
		assertFalse(hanoiTowers.canPickUp(1));
		
	}
	
	@Test
	public void forHanoiTowers_whenTryingToDropADiskOnTopOfASmallerOne_canDropReturnsFalse() {
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		hanoiTowers.pickUpDisk(1);
		hanoiTowers.dropDisk(3);
		hanoiTowers.pickUpDisk(1);
		
		assertFalse(hanoiTowers.canDrop(3));
	}
	
	@Test
	public void forHanoiTowers_whenNotHoldingDisk_canDropReturnsFalse() {
		try {
			hanoiTowers.newGame(3, false);
		} catch (Exception e) {
			assert false;
		}
		
		assertFalse(hanoiTowers.canDrop(1));
		assertFalse(hanoiTowers.canDrop(2));
		assertFalse(hanoiTowers.canDrop(3));
	}

}
