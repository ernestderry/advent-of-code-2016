package day10b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./src/day10b/puzzle.txt"));

			String line;
			try {
				line = reader.readLine();

				BotLoader bl = new BotLoader();

				while (line != null) {
					System.out.println(line);
					bl.loadInstruction(line);
					line = reader.readLine();
				}

				bl.iterate();

				int answer = 1;
				for (int o = 0; o < 3; o++) {
					answer *= bl.outputs[o].getValue();
				}

				System.out.println("answer " + answer);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
