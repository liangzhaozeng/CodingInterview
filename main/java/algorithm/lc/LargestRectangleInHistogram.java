package algorithm.lc;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 */
// O(n) space, O(n) time
public class LargestRectangleInHistogram {

	public class Solution {

		public int largestRA(int[] height) {
			int area = 0;
 
			for (int i = 0; i < height.length; i++) {

				if (i + 1 < height.length && height[i] <= height[i + 1])
					continue;
				int minV = height[i];
				for (int j = i; j >= 0; j--) {
					minV = Math.min(minV, height[j]);
					area = Math.max(area, minV * (i - j + 1));

				}

			}

			return area;
		}

		public int largestRectangleArea2(int[] height) {
			int area = 0;
			Stack<Integer> stack = new java.util.Stack<Integer>();
			for (int i = 0; i < height.length; i++) {
				if (stack.empty() || height[stack.peek()] < height[i]) {
					stack.push(i);
				} else {
					int start = stack.pop();
					int width = stack.empty() ? i : i - stack.peek() - 1;
					area = Math.max(area, height[start] * width);
					i--;
				}
			}
			while (!stack.empty()) {
				int start = stack.pop();
				int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
				area = Math.max(area, height[start] * width);
			}
			return area;
		}

		public int largestRectangleArea(int[] height) {
			// Start typing your Java solution below
			// DO NOT write main() function

			int[] toLeftBoundary = new int[height.length];
			Stack<Integer> stack = new Stack<Integer>(); // store the index
			for (int i = 0; i < height.length; ++i) {
				while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
					stack.pop();
				}
				toLeftBoundary[i] = stack.size() != 0 ? i - stack.peek() - 1 : i;
				stack.push(i);
			}
			stack.clear();
			int[] toRightBoundary = new int[height.length];
			for (int i = height.length - 1; i >= 0; --i) {
				while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
					stack.pop();
				}
				toRightBoundary[i] = stack.size() != 0 ? stack.peek() - i - 1 : height.length - i - 1;
				stack.push(i);
			}

			int maxArea = 0;
			for (int i = 0; i < height.length; ++i) {
				maxArea = Math.max(maxArea, (toLeftBoundary[i] + toRightBoundary[i] + 1) * height[i]);
			}
			return maxArea;
		}
	}

}
