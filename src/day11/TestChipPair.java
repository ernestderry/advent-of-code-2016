package day11;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChipPair {

	@Test
	public void canRetrieveGeneratorAndMicrochipFromChipPair() {
		ChipPair pair = new ChipPair(1, 2);
		assertEquals(1, pair.getGeneratorFloor());
		assertEquals(2, pair.getMicrochipFloor());
	}
	
	@Test
	public void twoIdenticalChipPairsAreEqual() {
		ChipPair pair = new ChipPair(1, 2);
		ChipPair pair2 = new ChipPair(1, 2);
		assertEquals(pair, pair2);
	}

	@Test
	public void twoIdenticalChipPairsWithDifferentGeneratorFloorsAreNotEqual() {
		ChipPair pair = new ChipPair(1, 2);
		ChipPair pair2 = new ChipPair(3, 2);
		assertNotEquals(pair, pair2);
	}

	@Test
	public void twoIdenticalChipPairsWithDifferentMicrochipFloorsAreNotEqual() {
		ChipPair pair = new ChipPair(1, 2);
		ChipPair pair2 = new ChipPair(1, 3);
		assertNotEquals(pair, pair2);
	}
	
	
	

}
