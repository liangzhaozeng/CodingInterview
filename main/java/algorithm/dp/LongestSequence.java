package algorithm.dp;

public class LongestSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set1[] = { 1, 7, 10, 13, 14, 19 };

		System.out.println(lenghtOfLongestAP(set1));
		;

		int set2[] = { 1, 7, 10, 15, 27, 29 };
		System.out.println(lenghtOfLongestAP(set2));
		;

		int set3[] = { 2, 4, 6, 8, 10 };
		System.out.println(lenghtOfLongestAP(set3 ));
		;

	}

	// C++ program to find Length of the Longest AP (llap) in a given sorted
	// set.
	// The code strictly implements the algorithm provided in the reference.

	// Returns length of the longest AP subset in a given set
	public static int lenghtOfLongestAP(int[] set) {
		int n = set.length;
		if (n <= 2)
			return n;

		// Create a table and initialize all values as 2. The value of
		// L[i][j] stores LLAP with set[i] and set[j] as first two
		// elements of AP. Only valid entries are the entries where j>i
		int[][] L = new int[n][n];
		int llap = 2; // Initialize the result

		// Fill entries in last column as 2. There will always be
		// two elements in AP with last number of set as second
		// element in AP
		for (int i = 0; i < n; i++)
			L[i][n - 1] = 2;

		// Consider every element as second element of AP
		for (int j = n - 2; j >= 1; j--) {
			// Search for i and k for j
			int i = j - 1;
			int k = j + 1;
			while (i >= 0 && k <= n - 1) {
				if (set[i] + set[k] < 2 * set[j])
					k++;

				// Before changing i, set L[i][j] as 2
				else if (set[i] + set[k] > 2 * set[j]) {
					L[i][j] = 2;
					i--;
				} else {
					// Found i and k for j, LLAP with i and j as first two
					// elements is equal to LLAP with j and k as first two
					// elements plus 1. L[j][k] must have been filled
					// before as we run the loop from right side
					L[i][j] = L[j][k] + 1;

					// Update overall LLAP, if needed
					llap = Math.max(llap, L[i][j]);

					// Change i and k to fill more L[i][j] values for
					// current j
					i--;
					k++;
				}
			}

			// If the loop was stopped due to k becoming more than
			// n-1, set the remaining entties in column j as 2
			while (i >= 0) {
				L[i][j] = 2;
				i--;
			}
		}
		return llap;
	}

}
