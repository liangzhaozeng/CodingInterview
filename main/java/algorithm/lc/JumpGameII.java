package algorithm.lc;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 */
// O(1) space, O(n^2) time
public class JumpGameII {
   public int jump(int[] A){
	   int step = 0;
	   int left = 0;
	   int right = 0;
	   int n = A.length;
	   
	   if (n == 1) return 0;
	   
	   while (left <= right) {
		   step ++;
		   int oldRight = right;
		   for (int i = left; i <= oldRight; i ++) {
			   int newRight = i + A[i];
			   if (newRight >= n-1) return step;
			   if (newRight > right) right = newRight;
		   }
		   left = oldRight +1;
	   }
	   
	   
	   return 0;
   }
	
  public class Solution {
    // if A[i] cannot be visited, then for all j > i, A[j] cannot be visited
    // so we can safely use greedy algorithm, find the largest step each time
    // from end to start
    public int jump(int[] A) {
      // Start typing your Java solution below
      // DO NOT write main() function
      int end = A.length - 1;
      int step = 0;
      while (end > 0) { 
        // find the largest pos that can reach to end
        for (int pos = 0; pos < end; ++pos) {
          if (pos + A[pos] >= end) {
            end = pos;
            ++step;
          }
        }
      }

      return step;
    }
  }

  
  
}
