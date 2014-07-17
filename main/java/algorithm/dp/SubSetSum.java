package algorithm.dp;

public class SubSetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean isSubsetSumR(int[] set, int sum)
	{
		int n = set.length;
	   // Base Cases
	   if (sum == 0)
	     return true;
	   if (n == 0 && sum != 0)
	     return false;
	 
	   // If last element is greater than sum, then ignore it
	   if (set[n-1] > sum)
	     return isSubsetSumR(set,  sum);
	 
	   /* else, check if sum can be obtained by any of the following
	      (a) including the last element
	      (b) excluding the last element   */
	   return isSubsetSumR(set, sum) || isSubsetSumR(set, sum-set[n-1]);
	}

	boolean isSubsetSum(int[] set, int sum) {
		int n = set.length;
		// The value of subset[i][j] will be true if there is a subset of
		// set[0..j-1]
		// with sum equal to i
		boolean[][] subset = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}

		/*
		 * // uncomment this code to print table for (int i = 0; i <= sum; i++)
		 * { for (int j = 0; j <= n; j++) printf ("%4d", subset[i][j]);
		 * printf("\n"); }
		 */

		return subset[sum][n];
	}
}
