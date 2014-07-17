package interview.questions.google.sort;

import algorithm.basic.Sort;

public class QuickSortRecursive extends Sort {

	private static int findKth(Integer[] A, int k, int start, int end) {
		int pivot = split(A, start, end);

		if (pivot == k) {
			return A[pivot];
		} else if (pivot < k) { // find the (k - pivot)-th from the second half
			return findKth(A, k - pivot - 1, pivot + 1, end);
		} else { // pivot > k, find the k-th from the first half
			return findKth(A, k, start, pivot - 1);
		}
	}

	private static <T extends Comparable<T>> int split(T[] list, int lo, int hi) {
		int left = lo + 1;
		int right = hi;
		T pivot = list[lo];

		while (true) {
			while (left <= right) {
				if (list[left].compareTo(pivot) < 0) {
					left++;
				} else {
					break;
				}
			}

			while (right > left) {
				if (list[right].compareTo(pivot) < 0) {
					break;
				} else {
					right--;
				}
			}

			if (left >= right) {
				break;
			}

			// swap left and right items
			T temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			// advance each one step
			left++;
			right--;
		}

		// swap pivot with left-1 position
		list[lo] = list[left - 1];
		list[left - 1] = pivot;
		// return the split point

		return left - 1;
	}

	private static <T extends Comparable<T>> void sort(T[] list, int lo, int hi) {
		if ((hi - lo) <= 0) { // fewer than 2 items
			return;
		}
		int splitPoint = split(list, lo, hi);
		sort(list, lo, splitPoint - 1); // left subarray recursion
		sort(list, splitPoint + 1, hi); // right subarray recursion
	}

	public static <T extends Comparable<T>> void sort(T[] list) {
		if (list.length <= 1) {
			return;
		}
		sort(list, 0, list.length - 1);
	}

	@Override
	public void sort(int[] A) {
		quickSort(A, 0, A.length - 1);
	}

	private void quickSort(int[] A, int start, int end) {
		if (start < end) {
			int pivot = partition(A, start, end);
			quickSort(A, start, pivot - 1);
			quickSort(A, pivot + 1, end);
		}
	}

	public int partition(int[] A, int start, int end) {
		int i = start, j = end + 1;
		int val = A[i];
		while (true) {
			while (A[++i] < val) { // move forward until >= val
				if (i == end) {
					break;
				}
			}
			while (val < A[--j]) { // move back until <= val
				if (j == start) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}
		int tmp = A[start]; // exchange pivot to proper location
		A[start] = A[j];
		A[j] = tmp;
		return j;
	}

	private int paritionSingle(int[] A, int start, int end) {
		int pivot = A[end];
		int bar = start - 1;
		for (int i = start; i < end; ++i) {
			if (A[i] <= pivot) {
				++bar;
				int tmp = A[i];
				A[i] = A[bar];
				A[bar] = tmp;
			}
		}
		int tmp = A[bar + 1];
		A[bar + 1] = A[end];
		A[end] = tmp;
		return bar + 1;
	}

}
