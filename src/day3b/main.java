package day3b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) {

		BufferedReader reader;

		int validTriangles = 0;
		Triangle t = new Triangle();

		String dimensions;
		
		try {
			reader = new BufferedReader(new FileReader("./src/day3b/puzzle.txt"));
			
			String[] lines = getLines(reader, 3);
			
			while (lines[0] != null) {
				
				printLines(lines);
				
				String[] line0Strings = lines[0].trim().split("\\s+");
				String[] line1Strings = lines[1].trim().split("\\s+");
				String[] line2Strings = lines[2].trim().split("\\s+");

				for (int column = 0; column < 3; column++) {
					dimensions = line0Strings[column] + " " + line1Strings[column] + " " + line2Strings[column];

					if (t.isTriangle(dimensions)) {
						validTriangles++;
					}
				}

				lines = getLines(reader, 3);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("answer " + validTriangles);

	}

	private static void printLines(String[] lines) {
		for (String line : lines) {
			System.out.println(line);
		}
	}

	private static String[] getLines(BufferedReader reader, int noOfLines) throws IOException {
	
		String[] lines = new String[noOfLines];
		for (int i = 0; i < noOfLines; i++) {
			lines[i] = reader.readLine();
		}
		
		return lines;
	}

}
