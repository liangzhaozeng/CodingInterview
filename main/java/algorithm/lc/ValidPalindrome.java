package algorithm.lc;


/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s.isEmpty()||s.length()==1)  return true;
       
       s=s.replaceAll("\\W+","");         //Note ?1
       s=s.toLowerCase();
       
       int i = 0, j = s.length()-1;
       while(i < j) {
           if(s.charAt(i)!=s.charAt(j))
               return false;
           else {
                 i++;
                 j--;
            }
       }
       return true;   
   }
	
	
  // O(1) space, O(n) time
  public class Solution {
    public boolean isPalindrome(String s) {
          // Start typing your Java solution below
          // DO NOT write main() function
      s = s.trim().toLowerCase();
      if (s.length() == 0) {
        return true;
      }
      int i = 0, j = s.length() - 1;
      while (i < j) {
        while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
          ++i;
        }
        while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
          --j;
        }
        if (i >= j) {
          return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
          return false;
        }
        ++i;
        --j;
      }
      return true;
    }
  }

}
