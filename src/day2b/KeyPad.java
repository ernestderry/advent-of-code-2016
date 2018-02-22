package day2b;

public class KeyPad {

	static final char[][] PAD = { 
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, 
			{ ' ', ' ', ' ', '1', ' ', ' ', ' ' },
			{ ' ', ' ', '2', '3', '4', ' ', ' ' }, 
			{ ' ', '5', '6', '7', '8', '9', ' ' },
			{ ' ', ' ', 'A', 'B', 'C', ' ', ' ' }, 
			{ ' ', ' ', ' ', 'D', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };
	
	int x = 1, y = 3;
	
	public KeyPad() {
		
	}

	public KeyPad(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public char calcButton(String instructions) {

		char[] instructionLetters = instructions.toCharArray();

		int newY = y, newX = x;

		for (char c : instructionLetters) {
			switch (c) {
			case 'U':
				newY -= 1;
				break;
			case 'L':
				newX -= 1;
				break;
			case 'R':
				newX += 1;
				break;
			default:
				newY += 1;
			}

			if (PAD[newY][newX] == ' ') {
				newY = y;
				newX = x;
			} else {
				y = newY;
				x = newX;
			}
		}

		return PAD[y][x];
	}
}
