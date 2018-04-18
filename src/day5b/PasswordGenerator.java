package day5b;

import java.util.HashMap;

public class PasswordGenerator {

	HashGenerator hashGenerator;

	public PasswordGenerator() {
		hashGenerator = new HashGenerator();
	}

	public PasswordGenerator(HashGenerator hg) {
		this.hashGenerator = hg;
	}

	public String generatePassword(String doorId, int passwordLength) {

		boolean isComplete = false;
		HashMap<Integer, Character> passwordMap = new HashMap<Integer, Character>();
		int i = 0;

		while (!isComplete) {
			String hash = hashGenerator.genHash(doorId + i);
			if (hash.startsWith("00000")) {
				char indexChar = hash.charAt(5);
				if (Character.isDigit(indexChar)) {
					int passwordCharIndex = Character.getNumericValue(indexChar);
					if (passwordCharIndex < passwordLength) {
						char passwordCharacter = hash.charAt(6);
						if (!passwordMap.containsKey(passwordCharIndex)) {
							passwordMap.put(passwordCharIndex, passwordCharacter);
							System.out.println("adding " + passwordCharacter + " to position " + passwordCharIndex);
						}
					}
				}
			}

			isComplete = passwordMap.size() == passwordLength;

			i++;
		}

		return buildPassword(passwordLength, passwordMap);
	}

	private String buildPassword(int passwordLength, HashMap<Integer, Character> passwordMap) {
		String result = "";

		for (int p = 0; p < passwordLength; p++) {
			result += passwordMap.get(p);
		}
		
		return result;
	}
}
