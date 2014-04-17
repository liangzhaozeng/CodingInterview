package algorithm.lc;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 */
public class DistinctSubsequences {

  public class Solution {
    // use 2D DP, 
    //           /  res[i][j - 1]   , if S.charAt(i - 1) != T.charAt(j - 1)
    // res[i][j]  
    //           \  res[i][j - 1] + res[i - 1][j - 1], if S.charAt(i - 1) == T.charAt(j - 1)
    public int numDistinct(String S, String T) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      if (T == null || S == null || T.length() > S.length()) {
        return 0;
      }

      int[][] distinct = new int[T.length() + 1][S.length() + 1];

      for (int i = 0; i < distinct.length; ++i) {
        for (int j = i; j < distinct[i].length; ++j) {
          if (i == 0 && j == 0) {
            distinct[i][j] = 1;
          } else if (i == 0) {
            distinct[i][j] = distinct[i][j - 1];
          } else {
            distinct[i][j] = distinct[i][j - 1];
            if (T.charAt(i - 1) == S.charAt(j - 1)) {
              distinct[i][j] += distinct[i - 1][j - 1];
            }
          }
        }
      }

      return distinct[T.length()][S.length()];
    }
  }

  /*
  
  从这个表可以看出，无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j - 1个字符，得到匹配个数为dp[i][j - 1].现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j - 1]。除此之外，当S[j]和T[i]相等时，我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配。所以递推关系为：
		  dp[0][0] = 1; // T和S都是空串.
		  dp[0][1 ... S.length() - 1] = 1; // T是空串，S只有一种子序列匹配。
		  dp[1 ... T.length() - 1][0] = 0; // S是空串，T不是空串，S没有子序列匹配。
		  dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0).1 <= i <= T.length(), 1 <= j <= S.length()
  */
  
  public int numDistinct1(String S, String T) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    int[][] dp = new int[T.length() + 1][S.length() + 1];
	    dp[0][0] = 1;
	    for (int i = 1; i <= T.length(); i++) {
	      dp[i][0] = 0;
	    }
	    for (int j = 1; j <= S.length(); j++) {
	      dp[0][j] = 1;
	    }
	    for (int i = 1; i <= T.length(); i++) {
	      for (int j = 1; j <= S.length(); j++) {
	        dp[i][j] = dp[i][j - 1];
	        if (T.charAt(i - 1) == S.charAt(j - 1)) {
	          dp[i][j] += dp[i - 1][j - 1];
	        }
	      }
	    }
	    return dp[T.length()][S.length()];
	      
	  }

}