package day9b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("./src/day9b/puzzle.txt"));
			
			String line = reader.readLine();
			System.out.println("before");
			System.out.println(line.length());
			System.out.println("after");
			double decompressedStringLength = StringFormatter.decompressedLength(line);
			System.out.println(decompressedStringLength);					
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
