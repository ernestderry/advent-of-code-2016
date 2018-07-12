package day10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./src/day10/puzzle.txt"));

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

				for (Bot bot : bl.bots) {
					if (bot != null) {
						if (bot.getValue(0) == 17 && bot.getValue(1) == 61) {
							System.out.println("answer = bot " + bot.getNumber());
						}
						if (bot.getValue(0) == 61 && bot.getValue(1) == 17) {
							System.out.println("answer = bot " + bot.getNumber());
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
