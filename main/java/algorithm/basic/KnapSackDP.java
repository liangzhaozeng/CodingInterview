package algorithm.basic;

import java.util.Arrays;
import java.util.Collections;



// http://www.programminglogic.com/knapsack-problem-dynamic-programming-algorithm/
public class KnapSackDP {

	static int counter = 0;

	// int index = index of the item you need to decide to take or not (we start
	// with the last element of the array and we work toward the first)
	// int size = size still available at the backpack
	// int weights[] = array with the weights of all items
	// int values[] = array with the values of all items

	static int minNumber = Integer.MAX_VALUE;

	public static int mincoins(int[] values, int target) {

		int result = 0;

		Arrays.sort(values);

		return result;

	}

	public int select(int[] values, int pos, int target, int number) {
		if (target == 0)
			return number;

		for (int i = pos; i < values.length; i++) {
			if (values[i] <= target) {
				return select(values, i + 1, target - values[i], number + 1);
			}
		}
		return -1;
	}

	public int calculateSizeOfMinSetOfElementsWhichSumToS(int s, int[] v) {
		Integer[] results = new Integer[s + 1];
		results[0] = 0;
		for (int i = 1; i < results.length; i++)
			results[i] = null;
		for (int i = 1; i < s; i++) {
			for (int j = 0; j < v.length; j++) {
				if (v[j] > i)
					continue;
				int minWithCurrent = results[i - v[j]] + 1;
				if (results[i] == null)
					results[i] = minWithCurrent;
				else if (results[i] > minWithCurrent)
					results[i] = minWithCurrent;
			}
		}
		return results[s];
	}

	public int minimumNumberDP(int[] values, int sum) {
		int[] dp = new int[sum + 1];

		for (int i = 0; i < dp.length; ++i) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;

		for (int i = 1; i <= sum; ++i) {
			for (int j = 0; j < values.length; ++j) {
				if (values[j] <= i && (dp[i - values[j]] + 1 < dp[i])) {
					dp[i] = dp[i - values[j]] + 1;
				}
			}
		}

		return dp[sum];
	}

	static int knapsack(int index, int size, int weights[], int values[], int[][] matrix, int[][] picks) {
		counter++;
		System.out.println("No " + counter + "invocation, " + " index and size are " + index + " " + size);

		int take, dontTake;

		take = dontTake = 0;

		if (matrix[index][size] != -1)
			return matrix[index][size];

		if (index == 0) {
			if (weights[0] <= size) {
				picks[index][size] = 1;
				matrix[index][size] = values[0];
				return values[0];
			} else {
				picks[index][size] = -1;
				matrix[index][size] = 0;
				return 0;
			}
		}

		if (weights[index] <= size)
			take = values[index] + knapsack(index - 1, size - weights[index], weights, values, matrix, picks);

		dontTake = knapsack(index - 1, size, weights, values, matrix, picks);

		matrix[index][size] = Math.max(take, dontTake);

		if (take > dontTake)
			picks[index][size] = 1;
		else
			picks[index][size] = -1;

		return matrix[index][size];

	}

	static void printPicks(int item, int size, int[] weights, int[] values, int[][] picks) {

		while (item >= 0 && size >= 0) {
			if (picks[item][size] == 1) {
				System.out.println("Item No:" + item + "  ");
				System.out.println("Item size:" + weights[item] + "  ");
				System.out.println(" Item Weight: " + values[item]);
				item--;
				size -= weights[item];
			} else {
				item--;
			}
		}

		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nItems = 4;
		int knapsackSize = 10;
		int[] weights = { 5, 4, 6, 3 };
		int[] values = { 10, 40, 30, 50 };

		int[][] picks = new int[nItems][knapsackSize + 1];
		int[][] matrix = new int[nItems][knapsackSize + 1];
		for (int i = 0; i < nItems; i++) {
			Arrays.fill(matrix[i], -1);
		}

		System.out.println("Max value = " + knapsack(nItems - 1, knapsackSize, weights, values, matrix, picks));

		System.out.println("Picks were: ");
		printPicks(nItems - 1, knapsackSize, weights, values, picks);

		System.out.println("Number of invocation " + counter);

		for (int i = 0; i < nItems; i++) {
			for (int j = 0; j < knapsackSize + 1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
