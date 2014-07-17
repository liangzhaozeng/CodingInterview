package interview.questions.apple;

import java.util.Arrays;

public class EvenSplitArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 3, 3, 5 };
		System.out.println(canSplitArray(A));
	}

	private static boolean canSplitArray(int[] A) {
		boolean result = false;
		int total = 0;
		for (int a : A)
			total += a;

		if (total % 2 != 0)
			return false;

		total = total / 2;

		boolean[] picks = new boolean[A.length];

		result = canPicks(total, 0, picks, A);

		return result;
	}

	private static boolean canPicks(int total, int current, boolean[] picks, int[] A) {
		if (current == total)
			return true;
		for (int i = 0; i < A.length; i++) {
			if (picks[i] == false && current + A[i] <= total) {
				picks[i] = true;
				if (canPicks(total, current + A[i], picks, A))
					return true;
				else
					picks[i] = false;
			}
		}
		return false;

	}

	public boolean canDivide(int[] input) {
		if (input.length < 2)
			return false;
		double sum = 0;
		for (int x : input)
			sum += x;
	
		if (sum % 2 == 1)
			return false;
		Arrays.sort(input);
		return canDivHandler(input, 0, sum / 2);
	}

	public boolean canDivHandler(int[] input, int start, double sum) {
		if (start == input.length || input[start] > sum)
			return false;
		int cur = input[start];
		if (cur == sum)
			return true;
		start += 1;
		return canDivHandler(input, start, sum) || canDivHandler(input, start, sum - cur);
	}

	boolean splitArray(int[] array) {
		int sum = 0;
		for (int x : array)
			sum += x;
		int i = array.length;
		return Q(array, i, sum / 2);
	}

	boolean Q(int[] array, int i, int sum) {
		if (i == 1) {
			return array[i] == sum ? true : false;
			
			
		}
		
		
		if ((array[i] == sum) || Q(array, i - 1, sum - array[i]) // have a
																	// subset
																	// with
																	// array[i]
				|| Q( removeElement(array, i), i - 1, sum)) // have a subset without
														// array[i]
			return true;
		else
			return false;
	}
	public static int[] removeElement(int[] original, int element){
	    int[] n = new int[original.length - 1];
	    System.arraycopy(original, 0, n, 0, element );
	    System.arraycopy(original, element+1, n, element, original.length - element-1);
	    return n;
	}
}
