package day7b;

import java.util.ArrayList;
import java.util.List;

public class SSL {

	public static boolean isSSL(String ip) {

		if (ip == null || ip.equals("")) {
			return false;
		}

		StringBuffer ipSB = new StringBuffer(ip);
		int pos = 0;

		boolean insideHypernet = false;
		String hypernetString = "";
		String nonHypernetString = "";
		List<String> hypernets = new ArrayList<String>();
		List<String> nonHypernets = new ArrayList<String>();
		while (pos < ipSB.length()) {

			String currentChar = ip.substring(pos, pos + 1);
			if ("[".equals(currentChar)) {
				insideHypernet = true;
				hypernetString = "";
				nonHypernets.add(nonHypernetString);
				nonHypernetString = "";
				pos++;
				continue;
			}

			if ("]".equals(currentChar)) {
				insideHypernet = false;
				pos++;
				hypernets.add(hypernetString);
				continue;
			}

			if (insideHypernet) {
				hypernetString += currentChar;
			} else {
				nonHypernetString += currentChar;
			}

			pos++;
		}

		nonHypernets.add(nonHypernetString);
		
		for (String nonHypernet : nonHypernets) {

			pos = 0;
			while (pos <= nonHypernet.length() - 3) {

				String candidateAba = nonHypernet.substring(pos, pos + 3);

				if (isAba(candidateAba)) {
					String bab = candidateAba.substring(1, 3) + candidateAba.substring(1, 2);
					for (String hypernet : hypernets) {
						if (babInHypernet(bab, hypernet)) {
							return true;
						}
					}
				}

				pos++;
			}

		}

		return false;
	}

	public static boolean isAba(String candidateAba) {
		String reversedCandidate = new StringBuffer(candidateAba).reverse().toString();
		return candidateAba.equals(reversedCandidate) && firstTwoCharactersDifferent(candidateAba);
	}

	private static boolean firstTwoCharactersDifferent(String candidateAba) {
		return !(candidateAba.substring(1, 2).equals(candidateAba.substring(2, 3)));
	}

	public static boolean babInHypernet(String bab, String hypernet) {
		return hypernet.contains(bab);
	}

}
