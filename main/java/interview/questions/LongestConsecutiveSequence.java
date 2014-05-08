package interview.questions;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int longestConsecutive(int[] num) {
	 
		 if (num == null) return 0;
		 if (num.length <2) return num.length;
		 HashSet<Integer> set = new HashSet<Integer>();
		 for (int i = 0; i < num.length; i ++) {
			 
			 set.add(num[i]);
		 }
	     int count = 0;
	     
	     for (int i = 0; i < num.length; i ++ ) {
	    	 int currentCount = 1;
	    	
	    	 int cur = num[i];
	    	 set.remove(cur);
	    	 while (set.contains(cur+1)) {
	    		 set.remove(cur+1);
	    		 currentCount ++;
	    		 cur ++;
	    	 }
	    	 cur = num[i];
	    	 while (set.contains(cur-1)) {
	    	     currentCount ++;
	    	     set.remove(cur-1);
	    	     cur --;
	         }
	    	 count = Math.max(count, currentCount);
	     }
	     return count;
	 }
	
	
}
