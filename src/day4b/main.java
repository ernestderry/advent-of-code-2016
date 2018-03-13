package day4b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		BufferedReader reader;
				
		try {
			reader = new BufferedReader(new FileReader("./src/day4b/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {
				if (Room.isReal(line)) {
					System.out.println(Room.decriptRoom(line) + " " + Room.getSector(line));;
				}

				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
}
