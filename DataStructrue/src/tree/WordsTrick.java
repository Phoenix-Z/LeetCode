package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsTrick {

	/**
	 * Computes a map in which the keys are words and values are Lists of words
	 * that differ in only one character from the corresponding key.
	 * Uses an efficient algorithm that is O(N log N) with a HashMap.
	 */
	public static Map<String, List<String>> computeAdjacentWords(List<String> words) {
		Map<String, List<String>> adjWords = new HashMap<>();
		Map<Integer, List<String>> wordsByLength = new HashMap<>();
		
		// Group the words by their length
		for(String word : words) {
			update(wordsByLength, word.length(), word);
		}
		
		// Work on each group separately
		for(Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
			List<String> groupWords = entry.getValue();
			int groupNum = entry.getKey();
			
			// Work on each position in each group
			for(int i = 0; i < groupNum; i++) {
				/*
				 * Remove one character in specified position, computing
				 * representative. Words with same representative are
				 * adjacent, so first populate a map
				 */
				Map<String, List<String>> repToWord = new HashMap<>();
				
				for(String string : groupWords) {
					String rep = string.substring(0, i) + string.substring(i + 1);
					update(repToWord, rep, string);
				}
				
				// and then look for map values with more than one string
				for(List<String> wordClique : repToWord.values()) {
					if(wordClique.size() >= 2) {
						for(String s1 : wordClique) {
							for(String s2 : wordClique) {
								if(s1 != s2)
									update(adjWords, s1, s2);
							}
						}
					}
				}
			}
		}
		
		return adjWords;
	}

	private static <KeyType> void update(Map<KeyType, List<String>> m, KeyType key, String value) {
		List<String> list = m.get(key);
		if(list == null) {
			list = new ArrayList<>();
			m.put(key, list);
		}
		list.add(value);
 	}
	
	public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
		for(Map.Entry<String, List<String>> entry : adjWords.entrySet()) {
			List<String> words = entry.getValue();
			
			if(words.size() > minWords) {
				System.out.print(entry.getKey() + " (");
				System.out.print(words.size() + "): ");
				for(String word : words)
					System.out.print(" " + word);
				System.out.println();
			}
		}
	}
	
}
