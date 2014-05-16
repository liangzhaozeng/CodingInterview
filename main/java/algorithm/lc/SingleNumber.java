package algorithm.lc;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 */
public class SingleNumber {

	// O(1) space, O(n) time
	// use XOR, numbers appear twice will be cancelled
	public class Solution {
		public int singleNumber(int[] A) {
			// Note: The Solution object is instantiated only once and is reused
			// by
			// each test case.
			int val = A[0];
			for (int i = 1; i < A.length; ++i) {
				val ^= A[i];
			}
			return val;
		}
	}

}
