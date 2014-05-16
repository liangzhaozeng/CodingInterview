package algorithm.lc;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 */
// O(1) space, O(n) time
public class JumpGame {

	public class Solution {
		// update the upper bound of reachable
		public boolean canJump(int[] A) {
			// Start typing your Java solution below
			// DO NOT write main() function
			int pos = 0;
			int reachable = 0;
			while (pos <= reachable) {
				reachable = Math.max(reachable, pos + A[pos]);
				if (reachable >= A.length - 1) {
					return true;
				}
				++pos;
			}
			return false;
		}

		public boolean canJump2(int[] A) {
			// Start typing your Java solution below
			// DO NOT write main() function
			int[] dp = new int[A.length];
			dp[0] = 0;
			for (int i = 1; i < A.length; i++) {
				dp[i] = Math.max(dp[i - 1], A[i - 1]) - 1;
			}
			return dp[A.length - 1] >= 0;
		}
	}

}
