package algorithm.lc;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 */
public class SingleNumberII {

	 // O(1) space, O(n) time
	
	   static public int singleNumber(int[] A) {
	    	
	      int[] result = new int[32];
	      
	      for (int i = 0; i < A.length; i ++) {
	    	  String a = Integer.toBinaryString(A[i]);
	    	  System.out.println(a);
	    	  char[] array = a.toCharArray();
	    	  for (int j = 0; j < array.length; j ++) {
	    		result[j] = (result[j] + (array[j]-'0') ) %3;
	    	  }
	    	  
	      }
	      
	      
	     int r = 0;
	   
         for (int i = 0; i < 32; i ++) {
        	r +=(result[i]<<i);
         }
         
         return r;
      
	    }
	

		public static void main(String[] args) {
			int[] A = {23,23, 23, 4,4,4, -3};
			
			String a = Integer.toBinaryString(-3);
			System.out.println(a);
			int j = (new BigInteger(a, 2).intValue());
			System.out.println(j);
			
			System.out.println(singleNumber(A));
		}
	
  // O(1) space, O(n) time
  public class Solution2 {
    public int singleNumber(int[] A) {
      // Note: The Solution object is instantiated only once and is reused by
      // each test case.
      int once = 0, twice = 0, threeTimes = 0;
      for (int val : A) {
        twice |= once & val; // record the bits that the val appears twice, is 0 for the first iteration
        once ^= val; // record the bits that the val appears once

        threeTimes = once & twice; // records the bits that val appear three times
        once &= ~threeTimes; // remove the bits that val appears three times
        twice &= ~threeTimes; // remove the bits that val appears three times
      }
      return once;
    }
  }

}
