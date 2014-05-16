package interview.questions;

public class UglyNumber {

	int findNthUgly(int N) {
		int idx = 2;
		int p2 = 1;
		int p3 = 1;
		int p5 = 1;

		int[] DP = new int[N + 2];

		DP[1] = 1;

		while (idx <= N) {

			DP[idx] = Math.min(Math.min(DP[p2] * 2, DP[p3] * 3), DP[p5] * 5);

			if (DP[idx] == DP[p2] * 2)
				p2++;

			else if (DP[idx] == DP[p3] * 3)
				p3++;

			else if (DP[idx] == DP[p5] * 5)
				p5++;

			idx++;

		}

		return DP[N];

	}
}
