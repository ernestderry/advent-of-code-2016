package day1;

public class TaxiCab {

	int x, y;
	Direction direction;

	public TaxiCab() {
		x = 0;
		y = 0;
		direction = Direction.North;
	}

	public void drive(String instruction) {
		char turn = instruction.charAt(0);
		int distance = Integer.parseInt(instruction.substring(1, instruction.length()));

		if (turn == 'R') {

			switch (direction) {
			case North:
				direction = Direction.East;
				x += distance;
				break;

			case East:
				direction = Direction.South;
				y += distance;
				break;

			case South:
				direction = Direction.West;
				x -= distance;
				break;

			case West:
				direction = Direction.North;
				y -= distance;
				break;
			}
			
		} else {
			switch (direction) {
			case North:
				direction = Direction.West;
				x -= distance;
				break;
				
			case East:
				direction = Direction.North;
				y -= distance;
				break;

			case South:
				direction = Direction.East;
				x += distance;
				break;
				
			case West:
				direction = Direction.South;
				y += distance;
				break;
			}
		}
	}

	public int distance() {
		return Math.abs(x) + Math.abs(y);
	}

}
