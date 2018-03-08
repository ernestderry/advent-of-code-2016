package day4;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Room {

	public static boolean isReal(String nameSectorAndChecksum) {

		if ("".equals(nameSectorAndChecksum)) {
			return false;
		}

		int checksumStartPos = nameSectorAndChecksum.indexOf('[');
		int checksumEndPos = nameSectorAndChecksum.indexOf(']');

		String checksum = nameSectorAndChecksum.substring(checksumStartPos + 1, checksumEndPos);

		String nameParts = nameSectorAndChecksum.substring(0, nameSectorAndChecksum.lastIndexOf('-'));

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

		return checksum.equals(concatenatedNames);
	}

	public static int getSector(String nameSectorAndChecksum) {
		
		String nameAndSector = nameSectorAndChecksum.substring(0, nameSectorAndChecksum.lastIndexOf('['));
		String sector = nameAndSector.substring(nameAndSector.lastIndexOf('-')+1);
				
		return Integer.parseInt(sector);
	}

}
