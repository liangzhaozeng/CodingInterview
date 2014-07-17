package interview.questions.linkedin;

import java.util.HashMap;
import java.util.Map;

public class WordDistance {

public static void main(String[] args) {
		
		String[] a = new String[] {"the", "quick", "brown", "fox", "quick"};
	
		
		System.out.println("Distance between words is: " + findShortestDistance(a, "fox", "the"));
		System.out.println("Distance between words is: " +  findShortestDistance(a, "quick", "fox"));
		System.out.println("Distance between words is: " +  findShortestDistance(a, "brown", "brown"));
		System.out.println("Distance between words is: " +  findShortestDistance(a, "apple", "mango"));

	}

	public static int findShortestDistance(String[] words, String a, String b) {
		Map<String, Integer> parityValueMap = new HashMap<String, Integer>();
		parityValueMap.put(a, 0);
		parityValueMap.put(b, 1);

		Map<String, Integer> posMap = new HashMap<String, Integer>();
		posMap.put(a, 0);
		posMap.put(b, 0);
		// int[] min = new int[words.length];

		int minDistance = Integer.MAX_VALUE;

		Integer parityValue = Integer.MAX_VALUE;

		int wordsLength = words.length;

		for (int i = 0; i < wordsLength; i++) {
			if (parityValueMap.containsKey(words[i])) {
				posMap.put(words[i], i);
				// First time we see a required word
				if (parityValue == Integer.MAX_VALUE) {
					parityValue = parityValueMap.get(words[i]);
					// we found the word other than the one found last time so
					// lets calculate distance
				} else if (!parityValue.equals(parityValueMap.get(words[i]))) {
					parityValue = parityValueMap.get(words[i]);
					int tempMin = posMap.get(words[i]) - posMap.get(words[i].equals(a) ? b : a);
					if (tempMin < minDistance) {
						minDistance = tempMin;
					}
				}
			}
		}
		return minDistance;
	}
}
