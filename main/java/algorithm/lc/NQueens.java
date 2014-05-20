package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 */
public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {

		ArrayList<String[]> ret = new ArrayList<String[]>();
		int[] queenList = new int[n];
		placeQueen(queenList, 0, n, ret);
		return ret;
	}

	// 递归回溯8皇后，关键记录下到达了哪一行了
	public static void placeQueen(int[] queenList, int row, int n, ArrayList<String[]> ret) {
		// Base Case, 已经完成任务了
		if (row == n) {
			StringBuilder[] sol = new StringBuilder[n];

			// 对数组内每一个对象都要new出其对象
			for (int i = 0; i < n; i++) {
				sol[i] = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sol[i].append(".");
				}
			}
			// 在相应的地方放置queen
			for (int i = 0; i < n; i++) {
				sol[i].setCharAt(queenList[i], 'Q');
			}
			String[] ss = new String[n];
			for (int i = 0; i < n; i++) {
				ss[i] = sol[i].toString();
			}
			ret.add(ss);
			return;
		}

		// 开始这一行的查找
		// 遍历第row行的所有列，测试哪一个位置是安全的
		for (int col = 0; col < n; col++) {
			if (isSafe(queenList, row, col)) {
				queenList[row] = col;
				placeQueen(queenList, row + 1, n, ret);
			}
		}
	}

	// 判断是否坐标(row,col)的位置是安全的（检查行，列，正反对角线）
	// queenList里面存放行，列坐标pair，即queenList[row] = col
	public static boolean isSafe(int[] queenList, int row, int col) {
		for (int preRow = 0; preRow < row; preRow++) {
			int preCol = queenList[preRow];
			if (preRow == row) { // 理论上不必检查，因为preRow是总是小于row的
				return false;
			}
			if (preCol == col) { // 检查是否在同一列
				return false;
			}
			if (row - preRow == col - preCol) { // 反对角线
				return false;
			}
			if (preRow + preCol == row + col) { // 正对角线
				return false;
			}
		}
		return true;
	}

	// O(n) space, O(n!) time
	public class Solution {
		// DFS
		public ArrayList<String[]> solveNQueens(int n) {
			// Start typing your Java solution below
			// DO NOT write main() function
			ArrayList<String[]> res = new ArrayList<String[]>();
			int[] history = new int[n];
			int curRow = 0;
			solve(history, n, curRow, res);
			return res;
		}

		private void solve(int[] history, int n, int curRow, ArrayList<String[]> res) {
			if (curRow == n) { // add to res
				String[] solved = new String[n];
				for (int i = 0; i < n; ++i) {
					char[] row = new char[n];
					Arrays.fill(row, '.');
					row[history[i]] = 'Q';
					solved[i] = new String(row);
				}
				res.add(solved);
			} else {
				for (int c = 0; c < n; ++c) { // try position curIdx, c
					boolean canPut = true;
					for (int r = 0; r < curRow; ++r) {
						if (history[r] == c || c - curRow == history[r] - r // diagonal
								|| c + curRow == history[r] + r) { // anti-diagonal
							canPut = false;
							break;
						}
					}
					if (canPut) {
						history[curRow] = c;
						solve(history, n, curRow + 1, res);
					}
				}
			}
		}
	}

}
