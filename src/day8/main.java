package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("./src/day8/puzzle.txt"));
			String line = reader.readLine();
			List<String> commands = new ArrayList<String>();
			Screen screen = new Screen(50,6);
			CommandRunner commandRunner = new CommandRunner(screen);
			while (line != null) {
				System.out.println(line);
				commands.add(line);
				line = reader.readLine();
			}
			commandRunner.run(commands);
			
			String screenOutput = screen.print();
			
			System.out.println(screenOutput);
			
			int onCount = 0;
			for (Character c : screenOutput.toCharArray()) {
				if (c.equals('#')) {
					onCount++;
				}
			}
			
			System.out.println("answer "+onCount);
			

		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println("answer "+abbaCount);
	}
}