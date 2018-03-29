package day5;

public class PasswordGenerator {

	HashGenerator hashGenerator;
	
	public PasswordGenerator() {
		hashGenerator = new HashGenerator();
	}

	public PasswordGenerator(HashGenerator hg) {
		this.hashGenerator = hg;
	}

	public String generatePassword(String doorId, int passwordLength) {

		boolean hashFound;
		int counter = 0;
		String password = "";
		String hash;

		for (int i = 0; i < passwordLength; i++) {
			hashFound = false;
			hash = "";
			while (!hashFound) {
				hash = hashGenerator.genHash(doorId + counter);
				counter += 1;
				if ("00000".equals(hash.substring(0, 5))) {
					hashFound = true;
				}
			}

			password += hash.substring(5, 6);
		}


		return password;
	}

}
