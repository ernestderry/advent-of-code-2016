package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		BufferedReader reader;
		List<String> messages = new ArrayList<String>();
				
		try {
			reader = new BufferedReader(new FileReader("./src/day6/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {
				messages.add(line);
				System.out.println(line);
				line = reader.readLine();
			}

			System.out.println("answer "+ NoiseReader.errorCorrectMessage(messages));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
