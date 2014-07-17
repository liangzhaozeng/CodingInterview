package algorithm.lc;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 */
// O(1) space, O(n^2) time
public class RotateImage {
	
	 public void rotate(int[][] matrix) {
	        if (matrix == null || matrix.length == 0)
	        return;
	        int n = matrix.length;
	        
	        for (int i = 0; i < n; i ++) {
	            for (int j = 0; j < n-i; j ++) {
	                int temp = matrix[n-1-j][n-1-i];
	                 matrix[n-1-j][n-1-i] =  matrix[i][j];
	                 matrix[i][j] = temp;
	            }
	        }
	        for (int i = 0; i < n/2; i ++) {
	            for (int j =0; j <n; j ++) {
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[n-1-i][j];
	                matrix[n-1-i][j] = temp;
	            }
	        }
	        
	    }

  public class Solution {
    // rotate the matrix from outer to inner, layer by layer
    public void rotate(int[][] matrix) {
      // Start typing your Java solution below
      // DO NOT write main() function
      for (int layer = 0; layer < matrix.length / 2; ++layer) {
        int start = layer;
        int end = matrix.length - layer - 1;
        for (; start < end; ++start) {
          int tmp = matrix[layer][start];
          // replace top with left
          matrix[layer][start] = matrix[matrix.length - start - 1][layer];
          // replace left with bottom
          matrix[matrix.length - start - 1][layer] = matrix[matrix.length
              - layer - 1][matrix.length - start - 1];
          // replace bottom with right
          matrix[matrix.length - layer - 1][matrix.length - start - 1] = matrix[start][matrix.length
              - layer - 1];
          // replace right with top
          matrix[start][matrix.length - layer - 1] = tmp;

        }
      }
    }

  }

}
