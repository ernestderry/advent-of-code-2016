package day1b;

import java.util.ArrayList;
import java.util.HashMap;

import day1b.Location;

public class TaxiCab {

	Location currentLocation;
	Direction direction;
	ArrayList<Location> locations;
	Location firstRepeatedLocation;
	HashMap<Direction, Direction> turnRight = new HashMap<Direction, Direction>();
	HashMap<Direction, Direction> turnLeft = new HashMap<Direction, Direction>();
		
	public TaxiCab() {
		currentLocation = new Location(0, 0);
		direction = Direction.North;
		locations = new ArrayList<Location>();
		
		turnRight.put(Direction.North, Direction.East);
		turnRight.put(Direction.East, Direction.South);
		turnRight.put(Direction.South, Direction.West);
		turnRight.put(Direction.West, Direction.North);	
		turnLeft.put(Direction.North, Direction.West);
		turnLeft.put(Direction.East, Direction.North);
		turnLeft.put(Direction.South, Direction.East);
		turnLeft.put(Direction.West, Direction.South);			
	}

	public void drive(String instruction) {
		char turn = instruction.charAt(0);
		int distance = Integer.parseInt(instruction.substring(1, instruction.length()));

		if (turn == 'R') {
			direction = turnRight.get(direction);
		} else {
			direction = turnLeft.get(direction);
		}

		move(distance, direction);

	}

	private void move(int distance, Direction direction) {
		int x = currentLocation.getX();
		int y = currentLocation.getY();

		while (distance > 0) {
			switch (direction) {
			case North:
				y -= 1;
				break;
			case East:
				x += 1;
				break;
			case South:
				y += 1;
				break;
			case West:
				x -= 1;
			}

			currentLocation.setLocation(x, y);

			checkIfVisitedLocationBefore();
			
			distance--;
		}
	}

	private void checkIfVisitedLocationBefore() {
		
		if (locations.contains(currentLocation)) {
			if (firstRepeatedLocation == null) {
				firstRepeatedLocation = new Location(currentLocation.getX(), currentLocation.getY());
			}
		} else {
			locations.add(new Location(currentLocation.getX(), currentLocation.getY()));
		}
	}

 	public int distance() {
		return distance(currentLocation);
	}

	private int distance(Location location) {
		return Math.abs(location.getX()) + Math.abs(location.getY());		
	}

	public int distanceToFirstLocationVisitedTwice() {
		if (firstRepeatedLocation == null) {
			return -1;
		}
		return distance(firstRepeatedLocation);
	}

}
