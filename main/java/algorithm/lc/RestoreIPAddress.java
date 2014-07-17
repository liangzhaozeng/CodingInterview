package algorithm.lc;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 */
// O(3^4) space, O(3^4) time, actually both are constant
public class RestoreIPAddress {

	public class Solution {

		public ArrayList<String> restoreIpAddresses1(String s) {
			ArrayList<String> res = restoreIPAddresses(s, 4);
			if (res == null)
				res = new ArrayList<String>();
			return res;
		}

		public ArrayList<String> restoreIPAddresses(String s, int k) {
			assert (k <= 4 && k >= 1);
			if (s == null || s.length() < k || s.length() > 3 * k)
				return null;
			ArrayList<String> res = new ArrayList<String>();

			for (int i = 0; i < Math.min(s.length(), 3); i++) {
				String num = s.substring(0, i + 1);
				if ((i == 0 || num.charAt(0) > '0') && Integer.parseInt(num) <= 255) {
					if (k == 1) {
						if (i == s.length() - 1)
							res.add(num);
					} else {
						ArrayList<String> remain = restoreIPAddresses(s.substring(i + 1), k - 1);
						if (remain != null) {
							for (String r : remain) {
								String temp = num + '.' + r;
								res.add(temp);
							}
						}
					}
				} else
					break;
			}
			return res;
		}

		// use three levels of loop
		public ArrayList<String> restoreIpAddresses(String s) {
			// Start typing your Java solution below
			// DO NOT write main() function
			ArrayList<String> res = new ArrayList<String>();
			for (int first = 1; first < s.length(); ++first) {
				if (!isValid(s, 0, first))
					break;

				for (int second = first + 1; second < s.length(); ++second) {
					if (!isValid(s, first, second))
						break;

					for (int third = second + 1; third < s.length(); ++third) {
						if (!isValid(s, second, third))
							break;

						if (isValid(s, third, s.length())) {
							// IP is valid
							StringBuilder sb = new StringBuilder();
							sb.append(s.substring(0, first)).append('.');
							sb.append(s.substring(first, second)).append('.');
							sb.append(s.substring(second, third)).append('.');
							sb.append(s.substring(third));
							res.add(sb.toString());
						}
					}

				}
			}
			return res;
		}

		private boolean isValid(String s, int start, int end) {
			if (end - start > 3 || (end - start > 1 && s.charAt(start) == '0')) {
				return false;
			}
			int num = Integer.parseInt(s.substring(start, end));
			if (num < 256 && num >= 0) {
				return true;
			}
			return false;
		}
	}

}
