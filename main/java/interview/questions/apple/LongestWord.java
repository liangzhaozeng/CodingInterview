package interview.questions.apple;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestWord());
	}

	private static Map<Character, Integer> copyCount(char[] chars) {
		Map<Character, Integer> charCounts = new HashMap<Character, Integer>(chars.length);
		for (char c : chars) {
			int value = 0;
			if (charCounts.containsKey(c)) {
				value = charCounts.get(c);
				charCounts.put(c, ++value);
			} else {
				charCounts.put(c, 1);
			}
		}
		return charCounts;
	}

	public static boolean isContained(Map<Character, Integer> toBeCompared, Map<Character, Integer> toCompare) {

		for (Character c : toBeCompared.keySet()) {
			if (!toCompare.containsKey(c)) {
				return false;
			}
			if (toBeCompared.get(c) > toCompare.get(c)) {
				return false;
			}
		}
		return true;
	}

	public static String longestWord() {
		String[] words = { "abc", "baa", "caan", "an", "banc", "tolosa" };
		char[] chars = { 'a', 'a', 'n', 'c', 'b' };

		PriorityQueue<String> values = new PriorityQueue<String>(words.length, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return 1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return -1;
			}
		});

		for (String word : words) {

			values.add(word);

		}
		Map<Character, Integer> toCompare = copyCount(chars);

		while (!values.isEmpty()) {
			String cur = values.poll();
			System.out.println("Trying " + cur);
			Map<Character, Integer> toBeCompare = copyCount(cur.toCharArray());
			if (isContained(toBeCompare, toCompare)) {
				return cur;
			}
		}
       return null;
	}

	public PriorityQueue<String> longestWords() {
		String[] words = { "abc", "baa", "caan", "an", "banc", "tolosa" };
		char[] chars = { 'a', 'a', 'n', 'c', 'b' };

		PriorityQueue<String> values = new PriorityQueue<String>(words.length, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() == o2.length()) {
					return 0;
				}
				return -1;
			}
		});
		Map<Character, Integer> toCompare = copyCount(chars);
		for (String word : words) {
			Map<Character, Integer> toBeCompare = copyCount(word.toCharArray());
			if (isContained(toBeCompare, toCompare)) {
				values.add(word);
			}

		}
		return values;
	}
}
