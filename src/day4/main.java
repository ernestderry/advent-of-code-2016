package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		BufferedReader reader;
		int sectorTotal = 0;
				
		try {
			reader = new BufferedReader(new FileReader("./src/day4/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				if (Room.isReal(line)) {
					sectorTotal += Room.getSector(line);
				}

				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("answer " + sectorTotal);
		
	}
}
