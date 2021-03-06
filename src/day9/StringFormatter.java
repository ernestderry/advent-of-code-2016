package day9;

public class StringFormatter {

	public static String decompress(String unCompressedString) {

		String cleanString = unCompressedString.replace("\n", "");
		cleanString = cleanString.replace("\r", "");
		cleanString = cleanString.replace(" ", "");

		char[] characters = cleanString.toCharArray();

		StringBuilder decodedString = new StringBuilder("");

		int c = 0;
		while (c < characters.length) {
			char currentChar = characters[c];
			if (currentChar == '(') {
				c++;
				
				int numberLength = numberOfCharactersUntilChar(characters, c, 'x');
				int numberOfCompressedChars = Integer.parseInt(getNextChars(characters, c, numberLength));
				c += numberLength + 1;
				
				numberLength = numberOfCharactersUntilChar(characters, c, ')');
				int numberOfCompressions = Integer.parseInt(getNextChars(characters, c, numberLength));
				c += numberLength + 1;
				
				StringBuilder compressedChars = new StringBuilder();
				for (int compressedCharCount = 0; compressedCharCount < numberOfCompressedChars; compressedCharCount++) {
					compressedChars.append(characters[c]);
					c++;
				}
				decodedString.append(repeat(compressedChars, numberOfCompressions));
			} else {
				decodedString.append(currentChar);
				c++;
			}
		}

		return decodedString.toString();
	}

	private static String repeat(StringBuilder characters, int numberOfCompressions) {
		StringBuilder result = new StringBuilder();
		;
		for (int c = 0; c < numberOfCompressions; c++) {
			result.append(characters.toString());
		}

		return result.toString();

	}
	
	private static int numberOfCharactersUntilChar(char[] characters, int charPos, char terminatingChar) {
	
		int numberOfChars = 0;
		while (characters[charPos+numberOfChars] != terminatingChar) {
			numberOfChars++;
		}
		
		return numberOfChars;
	}
	
	private static String getNextChars(char[] characters, int charPos, int numberOfChars) {
		StringBuilder extractedChars = new StringBuilder();
		for (int charCount = 0; charCount < numberOfChars; charCount++) {
			extractedChars.append(characters[charPos + charCount]);
		}
		return extractedChars.toString();		
	}

}