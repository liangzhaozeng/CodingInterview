package algorithm.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordBreakII {

	// O(1) space (cache not used yet), O(2^n) time, Time Limited Exceed
	// Recursive solution
	public static class Solution {

		public ArrayList<String> wordBreakII(String s, Set<String> dict) {
			int len = s.length();

			boolean f[] = new boolean[len + 1]; // indicate whether there is a
												// break point

			ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

			for (int i = 0; i <= len; i++) {
				prev.add(new ArrayList<Integer>());
			}

			f[0] = true;

			for (int i = 1; i <= len; i++) {

				for (int j = i - 1; j >= 0; j--) {

					if (f[j] && dict.contains(s.substring(j, i))) {

						prev.get(i).add(j); // start with j, to i, there is a
											// world

						f[i] = true; // position i is break point
					}
				}
			}

			ArrayList<String> result = new ArrayList<String>();

			buildResult(s, prev, len, result, "");

			return result;
		}

		private void buildResult(String s, ArrayList<ArrayList<Integer>> prev,
				int end, ArrayList<String> result, String current) {

			ArrayList<Integer> prevs = prev.get(end);
			for (int i = 0; i < prevs.size(); i++) {
				int n = prevs.get(i);
				String sub = s.substring(n, end);
				String r = sub;
				if (!current.equals("")) {
					r = r + " " + current;
				}
				if (n == 0) {
					result.add(r);
				} else {
					buildResult(s, prev, n, result, r);
				}
			}
		}

		public ArrayList<String> wordBreak(String s, Set<String> dict) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			ArrayList<String> res = new ArrayList<String>();
			Stack<String> cur = new Stack<String>();
		
			found(s, dict, cur, res);
			return res;
		}

		private void found(String s, Set<String> dict, Stack<String> cur,
				ArrayList<String> res) {
			if (s.length() == 0) { // find a solution
				res.add(concatenate(cur));
				return;
			}

			// check concatenatable
			for (int i = 1; i <= s.length(); ++i) {
				String prefix = s.substring(0, i);
				String suffix = "";
				if (i < s.length()) {
					suffix = s.substring(i);
				}

				if (dict.contains(prefix)) { // continue try the remaining part
					cur.push(prefix);
					found(suffix, dict, cur, res);
					cur.pop();
				}
			}
		}

		private String concatenate(Stack<String> cur) {
			StringBuilder sb = new StringBuilder();
			if (cur.size() == 0) {
				return sb.toString();
			}
			Iterator<String> itr = cur.iterator();
			sb.append(itr.next());
			while (itr.hasNext()) {
				sb.append(" ");
				sb.append(itr.next());
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		ArrayList<String> res = sol.wordBreak(s, dict);
		for (String str : res) {
			System.out.println(str);
		}
	}

}
