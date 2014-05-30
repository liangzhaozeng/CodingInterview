package algorithm.basic;

public class FindKth {
	private int split(int[] list, int lo, int hi){
		int left = lo +1;
		int right = hi;
		int pivot = list[lo];
		
		while (true) {
			while (left <= right){
				if (list[left] < pivot){
					left ++;
				} else {
					break;
				}
			}
			
			while (right > left) {
				if (list[right]< pivot){
					break;
				}else {
					right --;
				}
			}
			
			if (left >= right)
				break;
		
			int temp = list[left];
			list[left]= list[right];
			list[right] = temp;
			
			left ++;
			right ++;
		}
		list[lo] = list[left -1];
		list[left -1] = pivot;
		return left -1;
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

	
	
	
	public static void main(String[] args) {
		int[] A = { 1, 4, 2, 5, 9, 5, 3 };
		System.out.println(findKth(A, 3));
		int[] B = { 1, 4, 2, 5, 9, 5, 3 };
		System.out.println(findKth(B, 3, 0, B.length - 1));
	}

	/**
	 * 0-th smallest is the smallest.
	 * 
	 * @param A
	 * @param k
	 * @return
	 */
	public static int findKth(int[] A, int k) {
		if (k <= 0 || k >= A.length) {
			throw new IllegalArgumentException(String.format("k should be in range [0, %d]\n.", A.length));
		}
		k = k - 1; // index starts from 0

		int start = 0, end = A.length - 1;

		int pivot = -1;
		while (pivot != k) {
			pivot = pivotHoare(A, start, end);
			if (pivot < k) {
				start = pivot + 1;
			} else {
				end = pivot - 1;
			}
		}

		return A[pivot];
	}

	private static int findKth(int[] A, int k, int start, int end) {
		int pivot = pivotHoare(A, start, end);

		if (pivot == k) {
			return A[pivot];
		} else if (pivot < k) { // find the (k - pivot)-th from the second half
			return findKth(A, k - pivot - 1, pivot + 1, end);
		} else { // pivot > k, find the k-th from the first half
			return findKth(A, k, start, pivot - 1);
		}
	}

	private int pivot(int[] A, int start, int end) {
		int pivot = A[end];
		int bar = start - 1;
		for (int i = start; i < end; ++i) {
			if (A[i] < pivot) {
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

	private static int pivotHoare(int[] A, int start, int end) {
		int i = start, j = end + 1;
		int pivot = A[start];
		while (true) {
			while (A[++i] < pivot) {
				if (i == end) {
					break;
				}
			}

			while (pivot < A[--j]) {
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
		// move pivot to appropriate location
		int tmp = A[j];
		A[j] = A[start];
		A[start] = tmp;
		return j;
	}

	public static void median(int[] tokens, int left, int right, int medianIdx) {
		int pivot = -1;

		while (pivot != medianIdx) {
			pivot = partition(tokens, left, right);
			if (pivot < medianIdx) {
				left = pivot + 1;
			} else {
				right = pivot - 1;
			}
		}
		System.out.println(tokens[medianIdx]);
	}

	private static int partition(int[] A, int start, int end) {
		int pivot = A[start];
		int i = start;
		int j = end + 1;

		while (true) {
			while (A[++i] < pivot) {
				if (i == end) {
					break;
				}
			}
			while (A[--j] > pivot) {
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

		int tmp = A[j];
		A[j] = A[start];
		A[start] = tmp;
		return j;
	}

}
