package algorithm.basic;

import java.math.BigInteger;
import java.util.Scanner;

public class OrderPerm {

/**
	 * 
	 * @author ljs
	 * 2011-05-26
	 * 
	 * There are 13 possible orderings for three numbers, if we sort them with the relation '<' and '=':
	 * A = B = C , A = B < C , A < B = C ,A < B < C
	 * A < C < B , A = C < B , B < A = C ,B < A < C
	 * B < C < A , B = C < A , C < A = B ,C < A < B
	 * C < B < A
	 *
	 * Given an integer n, your task is to find the number of possible orderings for any n real numbers. 
	 * 
	 */

	public static BigInteger solve(int n) {
		BigInteger[] D1 = { new BigInteger("1"), new BigInteger("1") };
		for (int i = 2; i <= n; i++) {
			BigInteger[] D2 = new BigInteger[i + 1];
			// D2[0] is not used
			D2[1] = new BigInteger("0");
			for (int j = 1; j < D1.length; j++) {
				D2[1] = D2[1].add(D1[j]);
			}
			D2[1] = D2[1].multiply(new BigInteger(String.valueOf(i)));
			for (int m = 2; m <= i; m++) {
				BigInteger tmp = D1[m - 1].multiply(new BigInteger(String.valueOf(i)));
				D2[m] = tmp.divide(new BigInteger(String.valueOf(m)));
			}
			D1 = D2;
		}
		BigInteger count = new BigInteger("0");
		for (int i = 1; i <= n; i++) {
			count = count.add(D1[i]);
		}
		return count;
	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 50;
		for (int i = 1; i <= n; i++) {
			BigInteger count = OrderPerm.solve(i);
			System.out.format("count(n=%d): %d%n", i, count);
		}
		long end = System.currentTimeMillis();
		double timeElapsed = (end - start) / 1000.0;
		System.out.format("Time elapsed(sec): %.3f%n", timeElapsed);

		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			n = cin.nextInt();
			BigInteger count = OrderPerm.solve(n);
			System.out.println(count);
		}
	}
}
