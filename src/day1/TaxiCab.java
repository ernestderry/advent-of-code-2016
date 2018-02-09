package day1;

public class TaxiCab {

	int x, y;
	char direction;

	public TaxiCab() {
		x = 0;
		y = 0;
		direction = 'N';
	}

	public void drive(String instruction) {
		char turn = instruction.charAt(0);
		int distance = Integer.parseInt(instruction.substring(1, instruction.length()));

		if (turn == 'R') {

			switch (direction) {
			case 'N':
				direction = 'E';
				x += distance;
				break;

			case 'E':
				direction = 'S';
				y += distance;
				break;

			case 'S':
				direction = 'W';
				x -= distance;
				break;

			case 'W':
				direction = 'N';
				y -= distance;
				break;
			}
			
		} else {
			switch (direction) {
			case 'N':
				direction = 'W';
				x -= distance;
				break;
				
			case 'E':
				direction = 'N';
				y -= distance;
				break;

			case 'S':
				direction = 'E';
				x += distance;
				break;
				
			case 'W':
				direction = 'S';
				y += distance;
				break;
			}
		}
	}

	public int distance() {
		return Math.abs(x) + Math.abs(y);
	}

}
