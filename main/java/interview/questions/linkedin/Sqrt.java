package interview.questions.linkedin;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 */
public class Sqrt {

	// Netwon method
	public class Solution {

		public int sqrt2(int x) {
			if (x < 0)
				return -1;
			if (x == 0 | x == 1)
				return x;
			int left = 1;
			int right = x / 2;
			int lastmid = 0;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (x / mid > mid) {
					left = mid + 1;
					lastmid = mid;
				} else if (x / mid < mid) {
					right = mid - 1;
				} else {
					return mid;
				}

			}
			return lastmid;
		}

		public int sqrt(int x) {
			// Start typing your Java solution below
			// DO NOT write main() function
			double guess = 1;
			while (!closeEnough(guess, x)) {
				guess = (x / guess + guess) / 2;
			}
			return (int) guess;
		}

		private boolean closeEnough(double guess, int x) {
			if (Math.abs(guess * guess - x) < 0.1) {
				return true;
			}
			return false;
		}
	}

}
