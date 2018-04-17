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

		String hash;
		boolean isComplete = false;

		HashMap<Integer, Character> passwordMap = new HashMap<Integer, Character>();
		int i = 0;
		while (!isComplete) {

			hash = hashGenerator.genHash(doorId + i);
			if (hash.startsWith("00000")) {
				try {
					int passwordCharIndex = Integer.parseInt(hash.substring(5, 6));

					if (passwordCharIndex < passwordLength) {
						char passwordCharacter = hash.charAt(6);
						if (!passwordMap.containsKey(passwordCharIndex)) {
							passwordMap.put(passwordCharIndex, passwordCharacter);
							System.out.println("adding " + passwordCharacter + " to position " + passwordCharIndex);
						}
					}
				} catch (NumberFormatException e) {
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
