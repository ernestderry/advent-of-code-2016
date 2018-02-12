package day1;

public class TaxiCab {

	int x, y;
	direction direction;

	public TaxiCab() {
		x = 0;
		y = 0;
		direction = direction.North;
	}

	public void drive(String instruction) {
		char turn = instruction.charAt(0);
		int distance = Integer.parseInt(instruction.substring(1, instruction.length()));

		if (turn == 'R') {

			switch (direction) {
			case North:
				direction = direction.East;
				x += distance;
				break;

			case East:
				direction = direction.South;
				y += distance;
				break;

			case South:
				direction = direction.West;
				x -= distance;
				break;

			case West:
				direction = direction.North;
				y -= distance;
				break;
			}
			
		} else {
			switch (direction) {
			case North:
				direction = direction.West;
				x -= distance;
				break;
				
			case East:
				direction = direction.North;
				y -= distance;
				break;

			case South:
				direction = direction.East;
				x += distance;
				break;
				
			case West:
				direction = direction.South;
				y += distance;
				break;
			}
		}
	}

	public int distance() {
		return Math.abs(x) + Math.abs(y);
	}

}
