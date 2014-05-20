package algorithm.lc;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6,
 * 5] ]
 * 
 */
public class SpiralMatrixII {
	static public int[][] generateMatrix(int n) {
		int[][] m = new int[n][n];

		if (n == 0)
			return m;
		int beginX = 0, endX = n - 1;
		int beginY = 0, endY = n - 1;
		int num = 1;
		while (true) {
			System.out.println("Top ");
			for (int j = beginX; j <= endX; ++j) {
				System.out.print(num + "  ");
				m[beginY][j] = num++;

				
			}
			System.out.println("");
			if (++beginY > endY)
				break;
			System.out.println("Right ");
			for (int i = beginY; i <= endY; ++i) {
				
				System.out.print(num + "  ");
				m[i][endX] = num++;
			
			}
			System.out.println("");
			if (beginX > --endX)
				break;

			System.out.println("Botton ");
			for (int j = endX; j >= beginX; --j) {
				
				System.out.print(num + "  ");
				m[endY][j] = num++;

				
			}
			System.out.println("");
			if (beginY > --endY)
				break;
			System.out.println("Left ");
			for (int i = endY; i >= beginY; --i) {
				
				System.out.print(num + "  ");
				m[i][beginX] = num++;

				
			}
			System.out.println("");
			if (++beginX > endX)
				break;

		}
		return m;

	}

	static public int[][] generateMatrix2(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;
		int beginX = 0, endX = n - 1;
		int beginY = 0, endY = n - 1;
		int num = 1;
		while (true) {
			for (int j = beginX; j <= endX; ++j)
				matrix[beginY][j] = num++;
			if (++beginY > endY)
				break;

			for (int i = beginY; i <= endY; ++i)
				matrix[i][endX] = num++;
			if (beginX > --endX)
				break;

			for (int j = endX; j >= beginX; --j)
				matrix[endY][j] = num++;
			if (beginY > --endY)
				break;
			for (int i = endY; i >= beginY; --i)
				matrix[i][beginX] = num++;
			if (++beginX > endX)
				break;
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] m = generateMatrix(4);
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				System.out.print(m[i][j] + " ");
			}
		System.out.println("");
		m = generateMatrix(3);
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				System.out.print(m[i][j] + " ");
			}
	}

	public class Solution {
		public int[][] generateMatrix(int n) {
			// Start typing your Java solution below
			// DO NOT write main() function
			int[][] mat = new int[n][n];
			int val = 1;
			int maxLevel = (n + 1) / 2;
			for (int level = 0; level < maxLevel; ++level) {
				for (int c = level; c < n - level; ++c) {
					mat[level][c] = val++;
				}

				for (int r = level + 1; r < n - level; ++r) {
					mat[r][n - level - 1] = val++;
				}

				if (2 * level < n - 1) { // has enough row and col
					for (int c = n - level - 2; c >= level; --c) {
						mat[n - level - 1][c] = val++;
					}
					for (int r = n - level - 2; r > level; --r) {
						mat[r][level] = val++;
					}
				}
			}
			return mat;
		}
	}

}
