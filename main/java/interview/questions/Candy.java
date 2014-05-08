package interview.questions;

import java.util.Arrays;

public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int candy(int[] ratings) {
	     if (ratings == null || ratings.length == 0) return 0; 
	     
	     int[] results = new int[ratings.length];
	     
	     Arrays.fill(results, 1);
	     
	     for (int i=1; i < ratings.length; i ++) {
	    	 if (ratings[i]>ratings[i-1]) {
	    		 results[i] = results[i-1] +1;
	    	 }
	     }
	     int total = 0;
	     for (int i = ratings.length - 2; i >= 0; --i) {
	         if (ratings[i] > ratings[i + 1]) {
	        	 results[i] = Math.max(results[i + 1] + 1, results[i]);
	         }
	         total += results[i];
	       }
	     return total;
	     
	   }
}
