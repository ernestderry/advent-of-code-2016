package day11;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class BuildingState implements Cloneable {

	int elevatorFloor;
	ArrayList<ChipPair> chipPairs = new ArrayList<ChipPair>();

	public BuildingState(int elevatorFloor) {
		this.elevatorFloor = elevatorFloor;
	}

	public int getElevatorFloor() {
		return elevatorFloor;
	}

	public ArrayList<ChipPair> getChipPairs() {
		return chipPairs;
	}

	public void addChipPair(ChipPair cp) {
		int insertPos = -1;
		for (int i = 0; i < chipPairs.size(); i++) {
			if (cp.compareTo(chipPairs.get(i)) < 0 && insertPos == -1) {
				insertPos = i;
			}
		}

		if (insertPos == -1) {
			chipPairs.add(cp);
		} else {
			chipPairs.add(insertPos, cp);
		}
	}

	public ArrayList<BuildingState> getValidNextStates() {

		ArrayList<BuildingState> nextStates = new ArrayList<BuildingState>();
		BuildingState bs;
		ArrayList<ChipPair> processedChipPairs = new ArrayList<ChipPair>();

		for (int cpIdx = 0; cpIdx < chipPairs.size(); cpIdx++) {
			ChipPair cp = chipPairs.get(cpIdx);
			if (!processedChipPairs.contains(cp)) {

				if (elevatorFloor == cp.getGeneratorFloor() || elevatorFloor == cp.getMicrochipFloor()) {
					if (elevatorFloor > 1) {

						if (elevatorFloor == cp.getGeneratorFloor()) {

							bs = (BuildingState) clone();
							bs.getChipPairs().remove(cpIdx);

							if (!microchipWouldBeLeftOnFloorWithAnotherGenerator(bs, cp)) {
								ChipPair newFp1 = new ChipPair(cp.getGeneratorFloor() - 1, cp.getMicrochipFloor());

								bs.addChipPair(newFp1);
								bs.elevatorFloor -= 1;
								nextStates.add(bs);
							}
						}

						if (elevatorFloor == cp.getMicrochipFloor()) {
							bs = (BuildingState) clone();
							bs.getChipPairs().remove(cpIdx);

							if (!floorContainsGenerator(bs, elevatorFloor - 1) || cp.getGeneratorFloor() == elevatorFloor - 1) {
								ChipPair newFp2 = new ChipPair(cp.getGeneratorFloor(), cp.getMicrochipFloor() - 1);

								bs.addChipPair(newFp2);
								bs.elevatorFloor -= 1;
								nextStates.add(bs);

							}
						}

					}

					if (elevatorFloor < 4) {

						if (elevatorFloor == cp.getGeneratorFloor()) {
							bs = (BuildingState) clone();
							bs.getChipPairs().remove(cpIdx);

							if (!microchipWouldBeLeftOnFloorWithAnotherGenerator(bs, cp)) {
								ChipPair newFp1 = new ChipPair(cp.getGeneratorFloor() + 1, cp.getMicrochipFloor());

								bs.addChipPair(newFp1);
								bs.elevatorFloor += 1;

								nextStates.add(bs);
							}
						}

						if (elevatorFloor == cp.getMicrochipFloor()) {
							bs = (BuildingState) clone();
							bs.getChipPairs().remove(cpIdx);

							if (!floorContainsGenerator(bs, elevatorFloor + 1) || cp.getGeneratorFloor() == elevatorFloor + 1) {
								ChipPair newFp2 = new ChipPair(cp.getGeneratorFloor(), cp.getMicrochipFloor() + 1);

								bs.addChipPair(newFp2);
								bs.elevatorFloor += 1;
								nextStates.add(bs);
							}
						}
					}
				}
				processedChipPairs.add(cp);
			}
		}

		return nextStates;
	}

	private boolean microchipWouldBeLeftOnFloorWithAnotherGenerator(BuildingState bs, ChipPair cp) {
		return floorContainsGenerator(bs, elevatorFloor) && (elevatorFloor == cp.getMicrochipFloor());
	}

	private ArrayList<ChipPair> getUniqueChipPairs() {
		ArrayList<ChipPair> uniqueChipPairs = new ArrayList<ChipPair>();

		for (ChipPair cp : getChipPairs()) {
			if (!uniqueChipPairs.contains(cp)) {
				uniqueChipPairs.add(cp);
			}
		}

		return uniqueChipPairs;
	}

	private boolean floorContainsGenerator(BuildingState bs, int elevatorFloor) {
		for (ChipPair cp : bs.getChipPairs()) {
			if (cp.getGeneratorFloor() == elevatorFloor) {
				return true;
			}
		}
		return false;
	}

	private boolean floorContainsDifferentGenerator(BuildingState bs, ChipPair cpBeingMoved, int elevatorFloor) {
		for (ChipPair cp : bs.getChipPairs()) {
			if (cp.getGeneratorFloor() == elevatorFloor) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String printString = "{" + elevatorFloor + " ";

		for (ChipPair cp : chipPairs) {
			printString += "(" + cp.getGeneratorFloor() + " " + cp.getMicrochipFloor() + ") ";
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

		return (bs2.getElevatorFloor() == getElevatorFloor()) && bs2.getChipPairs().equals(getChipPairs());
	}

	@Override
	public Object clone() {
		BuildingState bs = new BuildingState(getElevatorFloor());
		for (ChipPair cp : getChipPairs()) {
			bs.addChipPair((ChipPair) cp.clone());
		}
		return bs;
	}

}
