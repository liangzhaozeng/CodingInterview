package algorithm.lc;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 */
// O(1) space, O(n) time
public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {
		char[] Tset = new char[256];
		char[] Sset = new char[256];
		for (int i = 0; i < T.length(); i++)
			Tset[T.charAt(i)]++;
		int left = 0, count = 0, min = Integer.MAX_VALUE;
		String res = "";
		for (int i = 0; i < S.length(); i++) {
			if (Tset[S.charAt(i)] == 0)
				continue;
			Sset[S.charAt(i)]++;
			if (Sset[S.charAt(i)] <= Tset[S.charAt(i)])
				count++;
			if (count == T.length()) {
				while (Sset[S.charAt(left)] > Tset[S.charAt(left)] || Tset[S.charAt(left)] == 0) {
					if (Sset[S.charAt(left)] > Tset[S.charAt(left)])
						Sset[S.charAt(left)]--;
					left++;
				}
				if (min > i - left + 1) {
					min = i - left + 1;
					res = S.substring(left, i + 1);
				}
			}
		}
		return res;
	}

	public class Solution {
		public String minWindow(String S, String T) {
			// Start typing your Java solution below
			// DO NOT write main() function
			int[] has = new int[256];
			int[] needs = new int[256];
			for (int i = 0; i < T.length(); ++i) {
				++needs[(int) T.charAt(i)];
			}

			int minLen = Integer.MAX_VALUE;
			int bufSize = 0;
			int minStart = -1, minEnd = -1; // record the start and end position of result
										
			for (int start = 0, end = 0; end < S.length(); ++end) {
				int cur = (int) S.charAt(end);
				if (needs[cur] == 0) {
					continue; // skip useless char
				}
				++has[cur];
				if (has[cur] <= needs[cur]) {
					++bufSize;
				}
				if (bufSize == T.length()) { // when 'has' contains enough chars, try shrink
												
					while (needs[S.charAt(start)] == 0 ||  has[S.charAt(start)] > needs[S.charAt(start)]) {
						if (has[S.charAt(start)] > needs[S.charAt(start)]) { // shrink excess chars
																				
							--has[S.charAt(start)]; // update buffer
						}
						++start;
					}

					int len = end - start + 1;
					if (minLen > len) {
						minLen = len;
						minStart = start;
						minEnd = end;
					}
				}
			}

			if (minStart == -1) {
				return "";
			}
			return S.substring(minStart, minEnd + 1);
		}
	}
}
