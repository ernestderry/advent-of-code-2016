package day7b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class main {

	public static void main (String[] args) {
		
		BufferedReader reader;
		int sslCount = 0;
				
		try {
			reader = new BufferedReader(new FileReader("./src/day7b/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {
				if (SSL.isSSL(line)) {
					System.out.println("yes");
					sslCount++;
				}
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("answer "+sslCount);
		
	}
}
