package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		BufferedReader reader;
		
		int validTriangles = 0;
		Triangle t = new Triangle();
		
		try {
			reader = new BufferedReader(new FileReader("./src/day3/puzzle.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				if (t.isTriangle(line.trim())) {
					validTriangles++;
				}
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("answer " + validTriangles);
		
	}
}
