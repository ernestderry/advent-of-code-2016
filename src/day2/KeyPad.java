package day2;

public class KeyPad {

	static final int[][] PAD = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	int x = 1, y = 1;

	public KeyPad() {

	}

	public KeyPad(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int calcButton(String instructions) {

		char[] instructionLetters = instructions.toCharArray();

		for (char c : instructionLetters) {
			switch (c) {
			case 'U':
				if (y > 0) y -= 1;
				break;
			case 'L':
				if (x > 0) x -= 1;
				break;
			case 'R':
				if (x < 2) x += 1;
				break;
			default:
				if (y < 2) y += 1;
			}
		}

		return PAD[y][x];

	}

}
