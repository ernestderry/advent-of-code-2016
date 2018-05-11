package day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class main {

	public static void main (String[] args) {
		
		BufferedReader reader;
		int abbaCount = 0;
				
		try {
			reader = new BufferedReader(new FileReader("./src/day7/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {
				if (Abba.isAbba(line)) {
					System.out.println("yes");
					abbaCount++;
				}
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("answer "+abbaCount);
		
	}
}
