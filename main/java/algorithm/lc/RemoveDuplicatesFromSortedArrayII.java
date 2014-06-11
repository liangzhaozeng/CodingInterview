package algorithm.lc;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 */
public class RemoveDuplicatesFromSortedArrayII {

	// O(n) space, O(n) time

		// check the previous two elements that are already in the partial
		// results
		public int removeDuplicates(int[] A) {
			// Start typing your Java solution below
			// DO NOT write main() function
			if (A.length < 3) {
				return A.length;
			}
			int len = 2;
			for (int i = 2; i < A.length; ++i) {
				if (!(A[i] == A[len - 1] && A[i] == A[len - 2])) {
					A[len++] = A[i];
				}
			}
			return len;
		}

		static public int removeDuplicates(int[] A, int occur) {

			int length = A.length;
			if (length <= occur)
				return length;

			int len = occur;
			for (int i = occur; i < A.length; ++i) {
				if (A[len - occur] != A[i]) {
					A[len++] = A[i];
				}
			}
			return len;
		}

		
		public static void main(String[] args) {
			
			int[] A = {1,1,1,1,2,2,2,3,4,5,6,6,6,6};
			
			System.out.println(A.length +"  " + removeDuplicates(A, 3));
			
			
		}
		
	

}
