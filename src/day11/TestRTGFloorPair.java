package day11;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRTGFloorPair {

	@Test
	public void canRetrieveGeneratorAndMicrochipFromRTGPair() {
		RTGFloorPair pair = new RTGFloorPair(1, 2);
		assertEquals(1, pair.getGeneratorFloor());
		assertEquals(2, pair.getMicrochipFloor());
	}
	
	@Test
	public void twoIdenticalRTGFloorPairsAreEqual() {
		RTGFloorPair pair = new RTGFloorPair(1, 2);
		RTGFloorPair pair2 = new RTGFloorPair(1, 2);
		assertEquals(pair, pair2);
	}

	@Test
	public void twoIdenticalRTGFloorPairsWithDifferentGeneratorFloorsAreNotEqual() {
		RTGFloorPair pair = new RTGFloorPair(1, 2);
		RTGFloorPair pair2 = new RTGFloorPair(3, 2);
		assertNotEquals(pair, pair2);
	}

	@Test
	public void twoIdenticalRTGFloorPairsWithDifferentMicrochipFloorsAreNotEqual() {
		RTGFloorPair pair = new RTGFloorPair(1, 2);
		RTGFloorPair pair2 = new RTGFloorPair(1, 3);
		assertNotEquals(pair, pair2);
	}
	
	
	

}
