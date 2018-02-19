package day1b;

import java.util.ArrayList;

import day1b.Location;

public class TaxiCab {

	Location currentLocation;
	Direction direction;
	ArrayList<Location> locations;
	Location firstRepeatedLocation;
	
	public TaxiCab() {
		currentLocation = new Location(0, 0);
		direction = Direction.North;
		locations = new ArrayList<Location>();
	}

	public void drive(String instruction) {
		char turn = instruction.charAt(0);
		int distance = Integer.parseInt(instruction.substring(1, instruction.length()));

		if (turn == 'R') {

			switch (direction) {
			case North:
				direction = Direction.East;
				break;

			case East:
				direction = Direction.South;
				break;

			case South:
				direction = Direction.West;
				break;

			case West:
				direction = Direction.North;
				break;
			}

		} else {
			switch (direction) {
			case North:
				direction = Direction.West;
				break;

			case East:
				direction = Direction.North;
				break;

			case South:
				direction = Direction.East;
				break;

			case West:
				direction = Direction.South;
				break;
			}
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
