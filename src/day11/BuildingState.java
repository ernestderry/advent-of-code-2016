package day11;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class BuildingState implements Cloneable{

	int elevatorFloor;
	ArrayList<RTGFloorPair> rtgFloorPairs = new ArrayList<RTGFloorPair>();

	public BuildingState(int elevatorFloor) {
		this.elevatorFloor = elevatorFloor;
	}

	public int getElevatorFloor() {
		return elevatorFloor;
	}

	public ArrayList<RTGFloorPair> getRTGFloorPairs() {
		return rtgFloorPairs;
	}

	public void addRTGFloorPair(RTGFloorPair fp) {
		int insertPos = -1;
		for (int i = 0; i < rtgFloorPairs.size(); i++) {
			if (fp.compareTo(rtgFloorPairs.get(i)) < 0 && insertPos == -1) {
				insertPos = i;
			}
		}

		if (insertPos == -1) {
			rtgFloorPairs.add(fp);
		} else {
			rtgFloorPairs.add(insertPos, fp);
		}
	}

	public ArrayList<BuildingState> getValidNextStates() {

		ArrayList<BuildingState> nextStates = new ArrayList<BuildingState>();
		
		BuildingState bs = (BuildingState) clone();
		RTGFloorPair fp = bs.getRTGFloorPairs().get(0);
		bs.getRTGFloorPairs().remove(0);
		
		RTGFloorPair newFp1 = new RTGFloorPair(fp.getGeneratorFloor()+1, fp.getMicrochipFloor());
		
		bs.addRTGFloorPair(newFp1);
		bs.elevatorFloor += 1;
		nextStates.add(bs);
		
		bs = (BuildingState) clone();
		fp = bs.getRTGFloorPairs().get(0);
		bs.getRTGFloorPairs().remove(0);
		
		RTGFloorPair newFp2 = new RTGFloorPair(fp.getGeneratorFloor(), fp.getMicrochipFloor()+1);
		
		bs.addRTGFloorPair(newFp2);		
		bs.elevatorFloor += 1;
		nextStates.add(bs);		
		
		return nextStates;
	}

	@Override
	public String toString() {
		String printString =  "{" + elevatorFloor + " ";
		
		for (RTGFloorPair fp : rtgFloorPairs) {
			printString += "(" + fp.getGeneratorFloor() + " " + fp.getMicrochipFloor() + ") ";
		}
		
		printString += "}";
		
		return printString;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof BuildingState)) {
			return false;
		}
		
		BuildingState bs2 = (BuildingState) o;
		
		return (bs2.getElevatorFloor() == getElevatorFloor()) && bs2.getRTGFloorPairs().equals(getRTGFloorPairs());		
	}

	@Override
	public Object clone() {
		BuildingState bs = new BuildingState(getElevatorFloor());
		for (RTGFloorPair fp : getRTGFloorPairs()) {
			bs.addRTGFloorPair((RTGFloorPair) fp.clone());
		}
		return bs;
	}

}
