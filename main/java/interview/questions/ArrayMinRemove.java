package interview.questions;

public class ArrayMinRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 20, 4, 1, 3 };
		int n = 4;
		System.out.println(minRemovalsDP(arr, n));

	}

	// A utility function to find minimum in arr[l..h]
	public static int min(int[] arr, int l, int h) {
		int mn = arr[l];
		for (int i = l + 1; i <= h; i++)
			if (mn > arr[i])
				mn = arr[i];
		return mn;
	}

	// A utility function to find maximum in arr[l..h]
	public static int max(int[] arr, int l, int h) {
		int mx = arr[l];
		for (int i = l + 1; i <= h; i++)
			if (mx < arr[i])
				mx = arr[i];
		return mx;
	}

	// Returns the minimum number of removals from either end
	// in arr[l..h] so that 2*min becomes greater than max.
	public static int minRemovalsDP(int[] arr, int n) {
		// Create a table to store solutions of subproblems
		int[][] table = new int[n][n];
		int gap, i, j, mn, mx;

		// Fill table using above recursive formula. Note that the table
		// is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
		// from diagonal elements to table[0][n-1] which is the result.
		for (gap = 1; gap < n; ++gap) {
			for (i = 0; i + gap < n; ++i) {
				j = i + gap;
				mn = min(arr, i, j);
				mx = max(arr, i, j);
				table[i][j] = (2 * mn > mx) ? 0 : Math.min(table[i][j - 1] + 1, table[i + 1][j] + 1);
			}
		}
		return table[0][n - 1];
	}

	// Driver program to test above functions

}
