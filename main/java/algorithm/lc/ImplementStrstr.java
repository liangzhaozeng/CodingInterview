package algorithm.lc;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 */
public class ImplementStrstr {

  // O(nm) time, brute force
  public class Solution {
    public String strStr(String haystack, String needle) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (haystack.length() < needle.length()) {
        return "";
      }
      for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
        int j = 0;
        for (; j < needle.length(); ++j) {
          if (haystack.charAt(i + j) == needle.charAt(j)) {
            break;
          }
        }
        if (j == needle.length()) {
          return haystack.substring(i);
        }
      }
      return null;
    }
  }

  // O(m) space, O(n + mR) time, where m is the length o needle, n is the length
  // of haystack, and R is the distinct number of characters
  public class SolutionKMP {
    public String strStr(String haystack, String needle) {
      // Start typing your Java solution below
      // DO NOT write main() function
      if (needle.length() == 0) {
        return haystack;
      }
      int[][] dfa = build(needle);
      int j = 0, i = 0;
      for (; i < haystack.length() && j < needle.length(); ++i) {
        j = dfa[haystack.charAt(i)][j];
      }
      if (j == needle.length()) {
        return haystack.substring(i - j);
      } else {
        return null;
      }
    }
    
    private int[][] build(String needle) {
      int R = 256;
      int[][] dfa = new int[R][needle.length()];
      int S = 0;
      dfa[needle.charAt(0)][S] = 1;
      for (int i = 1; i < needle.length(); ++i) {
        for (int c = 0; c < R; ++c) {
          dfa[c][i] = dfa[c][S]; // mismatch transition
        }
        dfa[needle.charAt(i)][i] = i + 1; // update match transition
        S = dfa[needle.charAt(i)][S]; // move to next state
      }
      return dfa;
    }
  }

  
  public String strStr(String haystack, String needle) {
      int lenh = haystack.length();
      int lenn = needle.length();
      if (lenn > lenh) return null;
      if (lenn == 0) return haystack;
      int[] overlay = getOverlay(needle);
      int i =0;
      while (i <= lenh-lenn) { // the length difference
          boolean success = true;
          for (int j =0; j < lenn; j ++) {
              if (needle.charAt(j) != haystack.charAt(i+j)) { // compare chart one by one
                success = false;
                 if (j ==0)  i ++;
                 else i = i +j - overlay[j-1];
                break;
              }
          }
          if (success)
          return haystack.substring(i);
      }
      return null;
  }
  public int[] getOverlay(String needle) {
      int[] overlay = new int[needle.length()];
      overlay[0] = 0;
      for (int i = 1; i < needle.length(); i ++) {
          int index = overlay[i-1];
          while (index >0 && needle.charAt(index) != needle.charAt(i)){
             index = overlay[index-1];
          }
          if (needle.charAt(index) == needle.charAt(i)) {
              overlay[i] = overlay[i-1] +1;
          } else overlay[i] =0;
      }
      
      return overlay;
  }
  
}
