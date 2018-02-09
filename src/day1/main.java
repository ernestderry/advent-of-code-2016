package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String args[]) {
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"./src/day1/puzzle.txt"));
			String line = reader.readLine();
			
			TaxiCab taxi = new TaxiCab();
			
			String[] commands = line.split(", ");
			for (String c : commands) {
				System.out.println(c);
				taxi.drive(c);
			}
			
			System.out.println("answer " + taxi.distance());
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
