package interview.questions.apple;

public class FindMeanValue {

	public double find(int[] A, int sa, int ea, int[] B, int sb, int eb, int k) {
		int lengthA = ea - sa + 1;
		int lengthB = eb - sb + 1;

		if (lengthA <= 0)
			return B[sb + k - 1];
		if (lengthB <= 0)
			return A[sa + k - 1];
		if (k <= 1)
			return A[sa] > B[sb] ? B[sb] : A[sa];

		int amid = (lengthA) / 2;
		int bmid = (lengthB) / 2;
		int current = lengthA / 2 + lengthB / 2 + 1;

		amid = sa + amid;
		bmid = sb + bmid;

		if (A[amid] >= B[bmid]) {
			if (current >= k) {
				return find(A, sa, amid - 1, B, sb, eb, k);
			} else {
				return find(A, sa, ea, B, bmid + 1, eb, k - (lengthB / 2) - 1);
			}
		} else {
			if (current >= k) {
				return find(A, sa, ea, B, sb, bmid - 1, k);
			} else {
				return find(A, amid + 1, ea, B, sb, eb, k - (lengthA / 2) - 1);
			}
		}
	}

	public double findMedianSortedArrays(int[] A, int[] B) {
		if (A.length == 0 && B.length == 0)
			return 0;
		if (A.length == 0) {
			if (B.length % 2 != 0)
				return B[B.length / 2];
			else
				return (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0;
		}
		if (B.length == 0) {
			if (A.length % 2 != 0)
				return A[A.length / 2];
			else
				return (A[A.length / 2] + A[A.length / 2 - 1]) / 2.0;
		}

		if ((A.length + B.length) % 2 == 0)
			return (find(A, 0, A.length - 1, B, 0, B.length - 1, (A.length + B.length) / 2 + 1) + find(A, 0,
					A.length - 1, B, 0, B.length - 1, (A.length + B.length) / 2)) / 2.0;
		else
			return find(A, 0, A.length - 1, B, 0, B.length - 1, (A.length + B.length) / 2 + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}