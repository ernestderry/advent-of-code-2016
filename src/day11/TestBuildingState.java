package day11;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestBuildingState {

	@Test
	public void createEmptyBuildingState() {
		BuildingState bs = new BuildingState(1);
		assertEquals(1, bs.getElevatorFloor());
		assertEquals(0, bs.getRTGFloorPairs().size());
	}

	@Test
	public void addOneRTGFloorPairToBuildingState() {
		BuildingState bs = new BuildingState(1);

		RTGFloorPair fp = new RTGFloorPair(1, 2);
		bs.addRTGFloorPair(fp);
		assertEquals(1, bs.getRTGFloorPairs().size());
		assertEquals(fp, bs.getRTGFloorPairs().get(0));
	}

	@Test
	public void addRTGFloorPairWithHigherGeneratorToBuildingState() {
		BuildingState bs = new BuildingState(1);

		RTGFloorPair fp = new RTGFloorPair(2, 2);
		bs.addRTGFloorPair(fp);
		RTGFloorPair fp2 = new RTGFloorPair(3, 2);
		bs.addRTGFloorPair(fp2);
		assertEquals(2, bs.getRTGFloorPairs().size());
		assertEquals(fp, bs.getRTGFloorPairs().get(0));
		assertEquals(fp2, bs.getRTGFloorPairs().get(1));
	}

	@Test
	public void addRTGFloorPairWithLowerGeneratorToBuildingState() {
		BuildingState bs = new BuildingState(1);

		RTGFloorPair fp = new RTGFloorPair(2, 2);
		bs.addRTGFloorPair(fp);
		RTGFloorPair fp2 = new RTGFloorPair(1, 2);
		bs.addRTGFloorPair(fp2);
		assertEquals(2, bs.getRTGFloorPairs().size());
		assertEquals(fp2, bs.getRTGFloorPairs().get(0));
		assertEquals(fp, bs.getRTGFloorPairs().get(1));
	}

	@Test
	public void addRTGFloorPairWithHigherMicrochipToBuildingState() {
		BuildingState bs = new BuildingState(1);

		RTGFloorPair fp = new RTGFloorPair(2, 2);
		bs.addRTGFloorPair(fp);
		RTGFloorPair fp2 = new RTGFloorPair(2, 3);
		bs.addRTGFloorPair(fp2);
		assertEquals(2, bs.getRTGFloorPairs().size());
		assertEquals(fp, bs.getRTGFloorPairs().get(0));
		assertEquals(fp2, bs.getRTGFloorPairs().get(1));
	}

	@Test
	public void addRTGFloorPairWithLowerMicrochipToBuildingState() {
		BuildingState bs = new BuildingState(1);

		RTGFloorPair fp = new RTGFloorPair(2, 2);
		bs.addRTGFloorPair(fp);
		RTGFloorPair fp2 = new RTGFloorPair(2, 1);
		bs.addRTGFloorPair(fp2);
		assertEquals(2, bs.getRTGFloorPairs().size());
		assertEquals(fp2, bs.getRTGFloorPairs().get(0));
		assertEquals(fp, bs.getRTGFloorPairs().get(1));
	}

	@Test
	public void addMultipleRTGFloorPairsToBuildingState() {
		BuildingState bs = new BuildingState(1);

		RTGFloorPair fp0 = new RTGFloorPair(2, 2);
		bs.addRTGFloorPair(fp0);
		RTGFloorPair fp1 = new RTGFloorPair(2, 1);
		bs.addRTGFloorPair(fp1);
		RTGFloorPair fp2 = new RTGFloorPair(1, 1);
		bs.addRTGFloorPair(fp2);
		RTGFloorPair fp3 = new RTGFloorPair(3, 3);
		bs.addRTGFloorPair(fp3);
		RTGFloorPair fp4 = new RTGFloorPair(3, 2);
		bs.addRTGFloorPair(fp4);
		RTGFloorPair fp5 = new RTGFloorPair(1, 1);
		bs.addRTGFloorPair(fp5);
		RTGFloorPair fp6 = new RTGFloorPair(3, 2);
		bs.addRTGFloorPair(fp6);
		RTGFloorPair fp7 = new RTGFloorPair(2, 0);
		bs.addRTGFloorPair(fp7);
		assertEquals(8, bs.getRTGFloorPairs().size());
		assertEquals(fp2, bs.getRTGFloorPairs().get(0));
		assertEquals(fp5, bs.getRTGFloorPairs().get(1));
		assertEquals(fp7, bs.getRTGFloorPairs().get(2));
		assertEquals(fp1, bs.getRTGFloorPairs().get(3));
		assertEquals(fp0, bs.getRTGFloorPairs().get(4));
		assertEquals(fp4, bs.getRTGFloorPairs().get(5));
		assertEquals(fp6, bs.getRTGFloorPairs().get(6));
		assertEquals(fp3, bs.getRTGFloorPairs().get(7));
	}

	@Test
	public void validStatesForPairOnFloor1() {
		BuildingState bs = new BuildingState(1);
		RTGFloorPair fp = new RTGFloorPair(1, 1);
		bs.addRTGFloorPair(fp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();

		BuildingState expectedState = new BuildingState(2);
		fp = new RTGFloorPair(2, 1);
		expectedState.addRTGFloorPair(fp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));

		expectedState = new BuildingState(2);
		fp = new RTGFloorPair(1, 2);
		expectedState.addRTGFloorPair(fp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));
	}
	
	@Test
	public void validStatesFor2PairsOnFloor1() {
		BuildingState bs = new BuildingState(1);
		RTGFloorPair fp = new RTGFloorPair(1, 1);
		bs.addRTGFloorPair(fp);
		
		fp = new RTGFloorPair(1, 1);
		bs.addRTGFloorPair(fp);
		ArrayList<BuildingState> nextStates = bs.getValidNextStates();		

		BuildingState expectedState = new BuildingState(2);
		fp = new RTGFloorPair(2, 1);
		expectedState.addRTGFloorPair(fp);
		fp = new RTGFloorPair(1, 1);
		expectedState.addRTGFloorPair(fp);
		assertTrue(nextStatesContainsState(nextStates, expectedState));

		expectedState = new BuildingState(2);
		fp = new RTGFloorPair(1, 2);
		expectedState.addRTGFloorPair(fp);
		fp = new RTGFloorPair(1, 1);
		expectedState.addRTGFloorPair(fp);
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
