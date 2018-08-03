package day11;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestBuildingState {

	@Test
	public void createEmptyBuildingState() {
		BuildingState bs = new BuildingState(1);
		assertEquals(1, bs.getElevatorFloor());
		assertEquals(0, bs.getChipPairs().size());
	}

	@Test
	public void addOneChipPairToBuildingState() {
		BuildingState bs = new BuildingState(1);

		ChipPair cp = new ChipPair(1, 2);
		bs.addChipPair(cp);
		assertEquals(1, bs.getChipPairs().size());
		assertEquals(cp, bs.getChipPairs().get(0));
	}

	@Test
	public void addChipPairWithHigherGeneratorToBuildingState() {
		BuildingState bs = new BuildingState(1);

		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ChipPair cp2 = new ChipPair(3, 2);
		bs.addChipPair(cp2);
		assertEquals(2, bs.getChipPairs().size());
		assertEquals(cp, bs.getChipPairs().get(0));
		assertEquals(cp2, bs.getChipPairs().get(1));
	}

	@Test
	public void addChipPairWithLowerGeneratorToBuildingState() {
		BuildingState bs = new BuildingState(1);

		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ChipPair cp2 = new ChipPair(1, 2);
		bs.addChipPair(cp2);
		assertEquals(2, bs.getChipPairs().size());
		assertEquals(cp2, bs.getChipPairs().get(0));
		assertEquals(cp, bs.getChipPairs().get(1));
	}

	@Test
	public void addChipPairWithHigherMicrochipToBuildingState() {
		BuildingState bs = new BuildingState(1);

		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ChipPair cp2 = new ChipPair(2, 3);
		bs.addChipPair(cp2);
		assertEquals(2, bs.getChipPairs().size());
		assertEquals(cp, bs.getChipPairs().get(0));
		assertEquals(cp2, bs.getChipPairs().get(1));
	}

	@Test
	public void addChipPairWithLowerMicrochipToBuildingState() {
		BuildingState bs = new BuildingState(1);

		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ChipPair cp2 = new ChipPair(2, 1);
		bs.addChipPair(cp2);
		assertEquals(2, bs.getChipPairs().size());
		assertEquals(cp2, bs.getChipPairs().get(0));
		assertEquals(cp, bs.getChipPairs().get(1));
	}

	@Test
	public void addMultipleChipPairsToBuildingState() {
		BuildingState bs = new BuildingState(1);

		ChipPair cp0 = new ChipPair(2, 2);
		bs.addChipPair(cp0);
		ChipPair cp1 = new ChipPair(2, 1);
		bs.addChipPair(cp1);
		ChipPair cp2 = new ChipPair(1, 1);
		bs.addChipPair(cp2);
		ChipPair cp3 = new ChipPair(3, 3);
		bs.addChipPair(cp3);
		ChipPair cp4 = new ChipPair(3, 2);
		bs.addChipPair(cp4);
		ChipPair cp5 = new ChipPair(1, 1);
		bs.addChipPair(cp5);
		ChipPair cp6 = new ChipPair(3, 2);
		bs.addChipPair(cp6);
		ChipPair cp7 = new ChipPair(2, 0);
		bs.addChipPair(cp7);
		assertEquals(8, bs.getChipPairs().size());
		assertEquals(cp2, bs.getChipPairs().get(0));
		assertEquals(cp5, bs.getChipPairs().get(1));
		assertEquals(cp7, bs.getChipPairs().get(2));
		assertEquals(cp1, bs.getChipPairs().get(3));
		assertEquals(cp0, bs.getChipPairs().get(4));
		assertEquals(cp4, bs.getChipPairs().get(5));
		assertEquals(cp6, bs.getChipPairs().get(6));
		assertEquals(cp3, bs.getChipPairs().get(7));
	}

	@Test
	public void validStatesForPairOnFloor1() {
		BuildingState bs = new BuildingState(1);
		ChipPair cp = new ChipPair(1, 1);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();

		assertEquals(nextStates.size(), 2);
		
		BuildingState expectedState = new BuildingState(2);
		cp = new ChipPair(2, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));

		expectedState = new BuildingState(2);
		cp = new ChipPair(1, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
	}
	
	@Test
	public void validStatesForPairOnFloor2() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();

		assertEquals(4, nextStates.size());
		
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(3, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));

		expectedState = new BuildingState(3);
		cp = new ChipPair(2, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));

		expectedState = new BuildingState(1);
		cp = new ChipPair(1, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));

		expectedState = new BuildingState(1);
		cp = new ChipPair(2, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}



	@Test
	public void validStatesForPairOnFloor3() {		
		BuildingState bs = new BuildingState(3);
		ChipPair cp = new ChipPair(3, 3);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(4, nextStates.size());
		
		BuildingState expectedState = new BuildingState(4);
		cp = new ChipPair(4, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(4);
		cp = new ChipPair(3, 4);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(2);
		cp = new ChipPair(2, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(2);
		cp = new ChipPair(3, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}
	
	@Test
	public void validStatesForPairOnFloor4() {		
		BuildingState bs = new BuildingState(4);
		ChipPair cp = new ChipPair(4, 4);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(2, nextStates.size());
		
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(3, 4);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(3);
		cp = new ChipPair(4, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}

	@Test
	public void validStatesForPairWhereOnlyGeneratorOnFloor1() {		
		BuildingState bs = new BuildingState(1);
		ChipPair cp = new ChipPair(1, 3);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(1, nextStates.size());
		
		BuildingState expectedState = new BuildingState(2);
		cp = new ChipPair(2, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}

	@Test
	public void validStatesForPairWhereOnlyMicroChipOnFloor1() {		
		BuildingState bs = new BuildingState(1);
		ChipPair cp = new ChipPair(3, 1);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(1, nextStates.size());
		
		BuildingState expectedState = new BuildingState(2);
		cp = new ChipPair(3, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}
	
	@Test
	public void validStatesForPairWhereOnlyGeneratorOnFloor2() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(2, 3);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(2, nextStates.size());
		
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(1);
		cp = new ChipPair(1, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
	}

	@Test
	public void validStatesForPairWhereOnlyMicrochipOnFloor2() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(3, 2);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(2, nextStates.size());
		
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(1);
		cp = new ChipPair(3, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
	}
	
	@Test
	public void cannotMoveGeneratorAwayFromMicrochipIfAnotherGeneratorOnFloor1() {
		BuildingState bs = new BuildingState(1);
		ChipPair cp = new ChipPair(1, 1);
		bs.addChipPair(cp);
		
		cp = new ChipPair(1, 1);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();	
		
		System.out.println(nextStates.toString());
		assertEquals(nextStates.size(), 1);

		BuildingState expectedState = new BuildingState(2);
		cp = new ChipPair(1, 2);
		expectedState.addChipPair(cp);
		cp = new ChipPair(1, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
	}

	@Test
	public void cannotMoveGeneratorAwayFromMicrochipIfAnotherGeneratorOnFloor2() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		assertEquals(2, nextStates.size());
				
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(2, 3);
		expectedState.addChipPair(cp);
		cp = new ChipPair(2, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
				
		expectedState = new BuildingState(1);
		cp = new ChipPair(2, 1);
		expectedState.addChipPair(cp);
		cp = new ChipPair(2, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}
	
	@Test
	public void cannotMoveMicrochipToFloorWithAnotherGeneratorFromFloor1() {
		BuildingState bs = new BuildingState(1);
		ChipPair cp = new ChipPair(1, 1);
		bs.addChipPair(cp);
		
		cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();	
		
		assertEquals(nextStates.size(), 1);

		BuildingState expectedState = new BuildingState(2);
		cp = new ChipPair(2, 1);
		expectedState.addChipPair(cp);
		cp = new ChipPair(2, 2);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
	}
	
	@Test
	public void cannotMoveMicrochipToFloorWithAnotherGeneratorFromFloor2() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(2, 2);
		bs.addChipPair(cp);
		cp = new ChipPair(3, 3);
		bs.addChipPair(cp);
		cp = new ChipPair(1, 1);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		assertEquals(2, nextStates.size());
				
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(3, 2);
		expectedState.addChipPair(cp);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		cp = new ChipPair(1, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
				
		expectedState = new BuildingState(1);
		cp = new ChipPair(1, 2);
		expectedState.addChipPair(cp);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		cp = new ChipPair(1, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}
	
	@Test
	public void canMoveMicrochipUpToFloorContainingMicrochipGenerator() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(3, 2);
		bs.addChipPair(cp);
		cp = new ChipPair(3, 3);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();

		System.out.println(nextStates.toString());
		assertEquals(2, nextStates.size());
				
		BuildingState expectedState = new BuildingState(3);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
				
		expectedState = new BuildingState(1);
		cp = new ChipPair(3, 1);
		expectedState.addChipPair(cp);
		cp = new ChipPair(3, 3);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}

	@Test
	public void canMoveMicrochipDownToFloorContainingMicrochipGenerator() {		
		BuildingState bs = new BuildingState(2);
		ChipPair cp = new ChipPair(1, 2);
		bs.addChipPair(cp);
		cp = new ChipPair(1, 1);
		bs.addChipPair(cp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();
		
		System.out.println(nextStates.toString());
		assertEquals(2, nextStates.size());
		
		BuildingState expectedState = new BuildingState(1);
		cp = new ChipPair(1, 1);
		expectedState.addChipPair(cp);
		cp = new ChipPair(1, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
		
		expectedState = new BuildingState(3);
		cp = new ChipPair(1, 3);
		expectedState.addChipPair(cp);
		cp = new ChipPair(1, 1);
		expectedState.addChipPair(cp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));		
	}
	
	private boolean nextStatesContainsState(ArrayList<BuildingState> nextStates, BuildingState expectedState) {
		
		System.out.println("looking for " + expectedState.toString() + " in states " + nextStates.toString());
		
		
		boolean found = false;
		for (BuildingState bs : nextStates) {
			if (bs.equals(expectedState)) {
				found = true;
			}
		}
		
		return found;
	}

}
