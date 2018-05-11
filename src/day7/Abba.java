package day7;

public class Abba {

	public static boolean isAbba(String ip) {

		if (ip == null || ip == "") {
			return false;
		}

		StringBuffer ipSB = new StringBuffer(ip);
		int pos = 0;
		boolean insideHypernet = false;		
		boolean isAbba = false;
		while (pos <= ipSB.length() - 4) {
			
			if ("[".equals(ipSB.substring(pos, pos+1))) {
				insideHypernet = true;
				pos++;
				continue;
			}

			if ("]".equals(ipSB.substring(pos, pos+1))) {
				insideHypernet = false;
				pos++;
				continue;
			}
			
			String candidateAbba = ipSB.substring(pos, pos + 4);
			
			if (isPallindromeString(candidateAbba) && firstTwoCharactersDifferent(candidateAbba)) {
				if (insideHypernet) {
					return false;
				} else {
					isAbba = true;
				}
			}

			pos++;
		}

		return isAbba;
	}

	private static boolean isPallindromeString(String candidatePallindrome) {
		return candidatePallindrome.equals(new StringBuffer(candidatePallindrome).reverse().toString());
	}
	
	private static boolean firstTwoCharactersDifferent(String word) {					
		return !word.substring(0, 1).equals(word.substring(1, 2));
	}

}
