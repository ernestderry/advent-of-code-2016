package day2b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String args[]) {

		KeyPad kp = new KeyPad();
		
		BufferedReader reader;
		String answer = "";
		
		try {
			reader = new BufferedReader(new FileReader("./src/day2b/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {

				answer += kp.calcButton(line);
				line = reader.readLine();
			}
			reader.close();
			System.out.println("answer " + answer);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
