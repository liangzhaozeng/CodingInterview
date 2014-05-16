package interview.questions;

public class RemoveArrayDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] A, int allows) {
		if (A == null)
			return 0;
		if (A.length <= allows)
			return A.length;

		int count = allows;
		for (int i = allows; i < A.length; i++) {
			if (A[i] != A[count - allows]) {
				count++;
			}
		}

		return count;

	}
}
