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
		
		// hanoiTowers.pickUpDisk(1);
		
	}
	

}
