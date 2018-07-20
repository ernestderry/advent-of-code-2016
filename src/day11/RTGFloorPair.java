package day11;

import java.util.Objects;

public class RTGFloorPair implements Comparable<RTGFloorPair>, Cloneable {

	int generatorFloor;
	int microchipFloor;
	
	public RTGFloorPair(int g, int m) {
		this.generatorFloor = g;
		this.microchipFloor = m;
	}

	public int getGeneratorFloor() {
		return this.generatorFloor;
	}

	public int getMicrochipFloor() {
		return this.microchipFloor;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof RTGFloorPair)) {
			return false;
		}
		
		RTGFloorPair pair2 = (RTGFloorPair) o;
		
		return microchipFloor == pair2.getMicrochipFloor() && generatorFloor == pair2.getGeneratorFloor();		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(generatorFloor, microchipFloor);
	}

	@Override
	public int compareTo(RTGFloorPair pair2) {
		
		if (equals(pair2)) {
			return 0;
		}
		if (generatorFloor > pair2.getGeneratorFloor() || (generatorFloor == pair2.getGeneratorFloor() && microchipFloor > pair2.getMicrochipFloor())) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public Object clone() {
		return new RTGFloorPair(getGeneratorFloor(), getMicrochipFloor());
	}

}
