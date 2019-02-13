package day11;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

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

		ArrayList<ChipPair> processedChipPairs = new ArrayList<ChipPair>();

		for (int cpIdx = 0; cpIdx < chipPairs.size(); cpIdx++) {

			ChipPair cp = chipPairs.get(cpIdx);
			BuildingState newBs;
			ChipPair newCp;

			if (!processedChipPairs.contains(cp)) {

				// move up
				if (elevatorFloor < 4) {
					if (cp.getGeneratorFloor() == elevatorFloor) {

						if (cp.getMicrochipFloor() == elevatorFloor) {
							// move GN and MC
							newBs = (BuildingState) clone();
							newCp = newBs.getChipPairs().get(cpIdx);
							newCp.setGeneratorFloor(elevatorFloor + 1);
							newCp.setMicrochipFloor(elevatorFloor + 1);
							newBs.elevatorFloor += 1;
							if (validBuildingState(newBs)) {
								nextStates.add(newBs);
							}
						}

						// move GN on own
						newBs = (BuildingState) clone();
						newCp = newBs.getChipPairs().get(cpIdx);
						newCp.setGeneratorFloor(elevatorFloor + 1);
						newBs.elevatorFloor += 1;
						if (validBuildingState(newBs)) {
							nextStates.add(newBs);
						}

						ArrayList<ChipPair> otherPairsProcessed = new ArrayList<ChipPair>();
						
						for (int cpIdx2 = cpIdx + 1; cpIdx2 < chipPairs.size(); cpIdx2++) {

							ChipPair cp2 = chipPairs.get(cpIdx2);

							if (!otherPairsProcessed.contains(cp2)) {

								if (cp2.getGeneratorFloor() == elevatorFloor) {
									// move GN with another pair's GN
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setGeneratorFloor(elevatorFloor + 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setGeneratorFloor(elevatorFloor + 1);
									newBs.elevatorFloor += 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								if (cp2.getMicrochipFloor() == elevatorFloor) {
									// move GN with another pair's MC
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setGeneratorFloor(elevatorFloor + 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setMicrochipFloor(elevatorFloor + 1);
									newBs.elevatorFloor += 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								otherPairsProcessed.add(cp2);

							}
						}
					}

					if (cp.getMicrochipFloor() == elevatorFloor) {

						// move MC on own
						newBs = (BuildingState) clone();
						newCp = newBs.getChipPairs().get(cpIdx);
						newCp.setMicrochipFloor(elevatorFloor + 1);
						newBs.elevatorFloor += 1;
						if (validBuildingState(newBs)) {
							nextStates.add(newBs);
						}

						ArrayList<ChipPair> otherPairsProcessed = new ArrayList<ChipPair>();
						for (int cpIdx2 = cpIdx + 1; cpIdx2 < chipPairs.size(); cpIdx2++) {

							ChipPair cp2 = chipPairs.get(cpIdx2);

							if (!otherPairsProcessed.contains(cp2)) {

								if (cp2.getGeneratorFloor() == elevatorFloor) {
									// move MC with another pair's GN
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setMicrochipFloor(elevatorFloor + 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setGeneratorFloor(elevatorFloor + 1);
									newBs.elevatorFloor += 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								if (cp2.getMicrochipFloor() == elevatorFloor) {
									// move MC with another pair's MC
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setMicrochipFloor(elevatorFloor + 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setMicrochipFloor(elevatorFloor + 1);
									newBs.elevatorFloor += 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								otherPairsProcessed.add(cp2);
							}
						}
					}
				}
				
				
				//move down
				if (elevatorFloor > 1) {
					if (cp.getGeneratorFloor() == elevatorFloor) {

						if (cp.getMicrochipFloor() == elevatorFloor) {
							// move GN and MC
							newBs = (BuildingState) clone();
							newCp = newBs.getChipPairs().get(cpIdx);
							newCp.setGeneratorFloor(elevatorFloor - 1);
							newCp.setMicrochipFloor(elevatorFloor - 1);
							newBs.elevatorFloor -= 1;
							if (validBuildingState(newBs)) {
								nextStates.add(newBs);
							}
						}

						// move GN on own
						newBs = (BuildingState) clone();
						newCp = newBs.getChipPairs().get(cpIdx);
						newCp.setGeneratorFloor(elevatorFloor - 1);
						newBs.elevatorFloor -= 1;
						if (validBuildingState(newBs)) {
							nextStates.add(newBs);
						}

						ArrayList<ChipPair> otherPairsProcessed = new ArrayList<ChipPair>();						
						for (int cpIdx2 = cpIdx + 1; cpIdx2 < chipPairs.size(); cpIdx2++) {

							ChipPair cp2 = chipPairs.get(cpIdx2);

							if (!otherPairsProcessed.contains(cp2)) {

								if (cp2.getGeneratorFloor() == elevatorFloor) {
									// move GN with another pair's GN
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setGeneratorFloor(elevatorFloor - 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setGeneratorFloor(elevatorFloor - 1);
									newBs.elevatorFloor -= 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								if (cp2.getMicrochipFloor() == elevatorFloor) {
									// move GN with another pair's MC
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setGeneratorFloor(elevatorFloor - 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setMicrochipFloor(elevatorFloor - 1);
									newBs.elevatorFloor -= 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								otherPairsProcessed.add(cp2);

							}
						}
					}

					if (cp.getMicrochipFloor() == elevatorFloor) {

						// move MC on own
						newBs = (BuildingState) clone();
						newCp = newBs.getChipPairs().get(cpIdx);
						newCp.setMicrochipFloor(elevatorFloor - 1);
						newBs.elevatorFloor -= 1;
						if (validBuildingState(newBs)) {
							nextStates.add(newBs);
						}

						ArrayList<ChipPair> otherPairsProcessed = new ArrayList<ChipPair>();
						for (int cpIdx2 = cpIdx + 1; cpIdx2 < chipPairs.size(); cpIdx2++) {

							ChipPair cp2 = chipPairs.get(cpIdx2);

							if (!otherPairsProcessed.contains(cp2)) {

								if (cp2.getGeneratorFloor() == elevatorFloor) {
									// move MC with another pair's GN
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setMicrochipFloor(elevatorFloor - 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setGeneratorFloor(elevatorFloor - 1);
									newBs.elevatorFloor -= 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								if (cp2.getMicrochipFloor() == elevatorFloor) {
									// move MC with another pair's MC
									newBs = (BuildingState) clone();
									newCp = newBs.getChipPairs().get(cpIdx);
									newCp.setMicrochipFloor(elevatorFloor - 1);
									newCp = newBs.getChipPairs().get(cpIdx2);
									newCp.setMicrochipFloor(elevatorFloor - 1);
									newBs.elevatorFloor -= 1;
									if (validBuildingState(newBs)) {
										nextStates.add(newBs);
									}
								}

								otherPairsProcessed.add(cp2);
							}
						}
					}
				}				

				processedChipPairs.add(cp);
				
			}
		}

		//return chip pairs in states in sorted order.
		for (BuildingState bs : nextStates) {
			Collections.sort(bs.getChipPairs());
		}
		
		return nextStates;
	}

	private boolean validBuildingState(BuildingState newBs) {

		ArrayList<ChipPair> pairsToCheck = newBs.getChipPairs();
		for (ChipPair cp : pairsToCheck) {

			if (!microchipAndGeneratorBalanced(cp)) {

				for (ChipPair cp2 : newBs.getChipPairs()) {
					if (cp != cp2 && cp2.getGeneratorFloor() == cp.getMicrochipFloor()) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean microchipAndGeneratorBalanced(ChipPair cp) {
		return cp.getGeneratorFloor() == cp.getMicrochipFloor();
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
