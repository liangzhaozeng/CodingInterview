package algorithm.lc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 */
public class PalindromePartition {

	public ArrayList<ArrayList<String>> partition(String s) {
		int[][] dp = new int[s.length()][s.length()];

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> r = new ArrayList<String>();

		for (int i = s.length() - 1; i >= 0; i--) {

			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || dp[i + 1][j - 1] == 1)) {
					dp[i][j] = 1;

				}
			}
		}

		dfs(0, s, dp, r, result);

		return result;
	}

	void dfs(int i, String s, int[][] dp, ArrayList<String> r,
			ArrayList<ArrayList<String>> result) {
		if (i == s.length()) {
			ArrayList<String> t = new ArrayList<String>(r);
			Collections.reverse(t);
			result.add(t);
			return;
		}

		for (int j = i; j < s.length(); j++) {
			if (dp[i][j] == 1) {
				r.add(0, s.substring(i, j + 1));
				dfs(j + 1, s, dp, r, result);
				r.remove(0);
			}
		}
	}

	// use DFS
	public class Solution {
		public ArrayList<ArrayList<String>> partition(String s) {
			// Start typing your Java solution below
			// DO NOT write main() function
			ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
			ArrayList<String> cur = new ArrayList<String>();
			int start = 0;
			dfs(s, start, cur, res);
			return res;
		}

		private void dfs(String s, int start, ArrayList<String> cur,
				ArrayList<ArrayList<String>> res) {
			if (start == s.length()) {
				res.add(new ArrayList<String>(cur));
				return;
			}

			for (int end = start; end < s.length(); ++end) {
				if (isPalindrome(s, start, end)) {
					cur.add(s.substring(start, end + 1));
					dfs(s, end + 1, cur, res);
					cur.remove(cur.size() - 1);
				}
			}
		}

		private boolean isPalindrome(String s, int start, int end) {
			while (start < end) {
				if (s.charAt(start++) != s.charAt(end--)) {
					return false;
				}
			}
			return true;
		}
	}

}
