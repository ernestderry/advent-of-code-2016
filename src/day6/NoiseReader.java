package day6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NoiseReader {

	public static String errorCorrectMessage(List<String> messages) {

		int noOfColumns = messages.get(0).length();
		List<Map<String, Integer>> columns = new ArrayList<Map<String, Integer>>();

		for (int lpos = 0; lpos < noOfColumns; lpos++) {
			columns.add(new LinkedHashMap<String, Integer>());
		}

		for (String word : messages) {
			for (int cpos = 0; cpos < noOfColumns; cpos++) {
				LinkedHashMap<String, Integer> letterCounts = (LinkedHashMap<String, Integer>) columns.get(cpos);
				String letter = word.substring(cpos, cpos + 1);
				if (letterCounts.get(letter) == null) {
					letterCounts.put(letter, 1);
				} else {
					int count = letterCounts.get(letter);
					letterCounts.put(letter, count + 1);
				}
			}
		}

		String errorCorrectedWord = "";

		for (int cpos = 0; cpos < noOfColumns; cpos++) {
			int highest = 0;
			String mostPopularLetter = "";
			for (Map.Entry<String, Integer> entry : columns.get(cpos).entrySet()) {
				int count = entry.getValue();
				if (count > highest) {
					mostPopularLetter = entry.getKey();
					highest = count;
				}
			}
			
			errorCorrectedWord += mostPopularLetter;
		}

		return errorCorrectedWord;
	}

}
