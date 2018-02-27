package day3b;

import java.util.Arrays;

public class Triangle {

	public boolean isTriangle(String dimensions) {
		String[] sidesStrings = dimensions.split("\\s+");
		int[] sides = new int[sidesStrings.length]; 
		for (int i = 0; i < sidesStrings.length; i++) {
			sides[i] = Integer.parseInt(sidesStrings[i]);
		}		
		
		Arrays.sort(sides);
		
		return (sides[0] + sides[1] > sides[2]);
		
	}
}
