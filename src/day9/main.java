package day9;

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
			BufferedReader reader = new BufferedReader(new FileReader("./src/day9/puzzle.txt"));
			
			String line = reader.readLine();
			System.out.println("before");
			System.out.println(line.length());
			System.out.println("after");
			String decompressedString = StringFormatter.decompress(line);
			System.out.println(decompressedString.length());
					
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
