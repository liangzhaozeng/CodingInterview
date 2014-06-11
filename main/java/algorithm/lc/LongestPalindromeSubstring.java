package algorithm.lc;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 */
public class LongestPalindromeSubstring {

  public class Solution {
	  public String longestPalindromeDP(String s) {
	        if (s== null || s.length() == 0) return null;
	        int length = s.length();
	        if (length<=1) return s;
	        
	        boolean[][] dp = new boolean[length][length];
	        String result = null;
	        int left = 0;
	        int right = 0;
	        for (int i = 0; i < length; i ++) {
	            dp[i][i] = true;
	           
	        }
	        int max = 1;
	        for (int step = 1; step<length; step ++) {
	             for (int i = 0; i+step < length; i ++ ) {
	                 int j = i + step;
	                 if (s.charAt(i) == s.charAt(j)) {
	                     if (step == 1)  
	                     dp[i][j] = true;
	                     else 
	                     dp[i][j]= dp[i+1][j-1];
	                 } else {
	                     dp[i][j] = false;
	                 }
	                 if ((dp[i][j]) && (step+1) > max) {
	                     max = step +1;
	                     left = i;
	                     right = j;
	                 }
	             }
	         }
	         return s.substring(left, right +1);
	    }  
	  
	  
    // O(1) space, O(n^2) time
    // expand from each of the 2N - 1 centers
    public String longestPalindrome(String s) {
          // Start typing your Java solution below
          // DO NOT write main() function
      String res = "";
      for (int i = 0; i < s.length(); ++i) {
        String palindrome1 = expand(s, i, i); // center is between two characters
        res = res.length() >= palindrome1.length()? res : palindrome1;
        if (i < s.length() - 1) {
          String palindrome2 = expand(s, i, i + 1); // center is the middle two characters
          res = res.length() >= palindrome2.length()? res : palindrome2;
        }
      }
      return res;
    }
    
    private String expand(String s, int start, int end) {
      while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
        --start;
        ++end;
      }
      
      return s.substring(start + 1, end);
    }
  }
  
}
