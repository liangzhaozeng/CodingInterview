package algorithm.lc;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 */
// O(1) space, O(lgn) time
public class SearchForARange {

	public static class Solution {
		
		public int[] searchRangeI(int[] A, int target) {
			int[] res = { Integer.MAX_VALUE, Integer.MIN_VALUE };
		    int left = 0;
		    int right = A.length;
		    int found = -1;
		    while (left <= right) {
		    	int mid = left + (right - left)/2;
		    	if (A[mid]== target) {
		    		found = mid;
		    	}
		    	if (A[mid] > target)
		    	right = mid -1;
		    	else 
		    		left = mid +1;
		    }
		
		    if (found == -1) {
		    	return res;
		    } else {
		    	res[0]= found;
		    	for (int i = found; i >=0; i--) {
		    		res[0] = (A[i]==target)? i: res[0];
		    		if (A[i] != target) break;
		    	}
		    	res[1] = found;
		    	for (int i = found; i < A.length; i++) {
		    		res[0] = (A[i]==target)? i: res[0];
		    		if (A[i] != target) break;
		    	}
		    }
			
			return  res;
		}
		
		
		
		public int[] searchRange(int[] A, int target) {
			int[] res = { Integer.MAX_VALUE, Integer.MIN_VALUE };
			rec(A, target, res, 0, A.length - 1);
			if (res[0] == Integer.MAX_VALUE) {
				res[0] = -1;
			}
			if (res[1] == Integer.MIN_VALUE) {
				res[1] = -1;
			}
			return res;
		}

		public static void rec(int[] A, int target, int[] res, int low, int high) {
			if (low > high) {
				return;
			}
			int mid = low + (high - low) / 2;
			if (target == A[mid]) {
				res[0] = Math.min(res[0], mid);
				res[1] = Math.max(res[1], mid);
				rec(A, target, res, low, mid - 1);
				rec(A, target, res, mid + 1, high);
			} else if (target < A[mid]) {
				rec(A, target, res, low, mid - 1);
			} else {
				rec(A, target, res, mid + 1, high);
			}
		}

		// use binary search twice
		public int[] searchRange2(int[] A, int target) {
			// Start typing your Java solution below
			// DO NOT write main() function
			int start = -1, end = -1;
			int left = 0, right = A.length - 1;

			// search for start
			while (left <= right) {
				int mid = (left + right) / 2;
				if (target == A[mid]) {
					start = (start == -1 ? mid : Math.min(start, mid));
					right = mid - 1; // continue search left part
				} else if (target > A[mid]) {
					left = mid + 1;
				} else { // if target < A[mid]
					right = mid - 1;
				}
			}

			left = 0;
			right = A.length - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (target == A[mid]) {
					end = (end == -1 ? mid : Math.max(mid, end));
					left = mid + 1; // continue search right
				} else if (target > A[mid]) {
					left = mid + 1;
				} else { // target < A[mid]
					right = mid - 1;
				}
			}

			int[] res = { start, end };
			return res;
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = { 1 };
		int target = 1;
		int[] res = s.searchRange(A, target);
		System.out.println(Arrays.toString(res));
	}

}
