package algorithm.basic;

import java.util.Arrays;

public class MergeSort extends Sort {

	@Override
	public void sort(int[] A) {
		int[] copy = new int[A.length];
		sort(A, copy, 0, A.length - 1);
	}

	private void sort(int[] A, int[] copy, int first, int last) {
		if (first >= last) {
			return;
		}
		int mid = (first + last) / 2;
		sort(A, copy, first, mid);
		sort(A, copy, mid + 1, last);
		merge(A, copy, first, mid, last);
	}

	private void merge(int[] A, int[] copy, int first, int mid, int last) {
		// copy
		for (int i = first; i <= last; ++i) {
			copy[i] = A[i];
		}
		int i = first;
		int j = mid + 1;

		for (int k = first; k <= last; ++k) {
			if (i > mid) { // no element in first half arr
				A[k] = copy[j++];
			} else if (j > last) {
				A[k] = copy[i++];
			} else if (copy[i] <= copy[j]) {
				A[k] = copy[i++];
			} else {
				A[k] = copy[j++];
			}
		}
	}

	static void mergeSort(int[] A) {
		if (A.length > 1) {
			int q = A.length / 2;
			int[] leftArray = Arrays.copyOfRange(A, 0, q);
			int[] rightArray = Arrays.copyOfRange(A, q + 1, A.length);
			mergeSort(leftArray);
			mergeSort(rightArray);
			A = merge(leftArray, rightArray);
		}
	}

	static int[] merge(int[] l, int[] r) {
		int totElem = l.length + r.length;
		int[] a = new int[totElem];
		int i, li, ri;
		i = li = ri = 0;
		while (i < totElem) {
			if ((li < l.length) && (ri < r.length)) {
				if (l[li] < r[ri]) {
					a[i] = l[li];
					i++;
					li++;
				} else {
					a[i] = r[ri];
					i++;
					ri++;
				}
			} else {
				if (li >= l.length) {
					while (ri < r.length) {
						a[i] = r[ri];
						i++;
						ri++;
					}
				}
				if (ri >= r.length) {
					while (li < l.length) {
						a[i] = l[li];
						li++;
						i++;
					}
				}
			}
		}
		return a;

	}

}
