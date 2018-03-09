package day4;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Room {

	public static boolean isReal(String room) {

		if ("".equals(room)) {
			return false;
		}

		String checksum = extractChecksum(room);

		HashMap<Character, Integer> letterCounts = buildLetterCountsFromName(room);

		List<Map.Entry<Character, Integer>> letterList = createListOfSortedLetterCounts(letterCounts);

		String concatenatedLetters = concatenateFirst5MostPopularLettersTogether(letterList);

		return checksum.equals(concatenatedLetters);
	}

	private static String concatenateFirst5MostPopularLettersTogether(List<Map.Entry<Character, Integer>> letterList) {
		String concatenatedNames = "";

		for (Iterator<Map.Entry<Character, Integer>> it = letterList.iterator(); it.hasNext();) {
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
			Character letter = (Character) entry.getKey();
			if (letter != '-') {
				concatenatedNames += letter;
			}
			if (concatenatedNames.length() == 5) {
				break;
			}
		}
		return concatenatedNames;
	}

	private static List<Map.Entry<Character, Integer>> createListOfSortedLetterCounts(
			HashMap<Character, Integer> letterCounts) {
		List<Map.Entry<Character, Integer>> letterList = new LinkedList<Map.Entry<Character, Integer>>(
				letterCounts.entrySet());

		Collections.sort(letterList, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
                    return ((Comparable<Character>) ((Map.Entry<Character, Integer>) (o1)).getKey())
							.compareTo(((Map.Entry<Character, Integer>) (o2)).getKey());
				} else {
					return ((Comparable<Integer>) ((Map.Entry<Character, Integer>) (o2)).getValue())
							.compareTo(((Map.Entry<Character, Integer>) (o1)).getValue());
				}
			}
		});
		return letterList;
	}

	private static HashMap<Character, Integer> buildLetterCountsFromName(String room) {
		String nameParts = room.substring(0, room.lastIndexOf('-'));

		char[] nameLetters = nameParts.toCharArray();

		HashMap<Character, Integer> letterCounts = new HashMap<Character, Integer>();
		for (char letter : nameLetters) {
			if (letterCounts.containsKey(letter)) {
				int count = letterCounts.get(letter);
				letterCounts.put(letter, count + 1);
			} else {
				letterCounts.put(letter, 1);
			}
		}
		return letterCounts;
	}

	private static String extractChecksum(String room) {
		int checksumStartPos = room.indexOf('[');
		int checksumEndPos = room.indexOf(']');

		return room.substring(checksumStartPos + 1, checksumEndPos);		
	}

	public static int getSector(String nameSectorAndChecksum) {
		
		String nameAndSector = nameSectorAndChecksum.substring(0, nameSectorAndChecksum.lastIndexOf('['));
		String sector = nameAndSector.substring(nameAndSector.lastIndexOf('-')+1);
				
		return Integer.parseInt(sector);
	}

}
