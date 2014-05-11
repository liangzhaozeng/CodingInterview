package interview.questions;

public class FindInMatrix {

	boolean find(int[][] matrix, int target){
		boolean result = false;
		
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int x = 0;
		int y = n-1;
		
		while (x < m && y >=0) {
			if (matrix[x][y] == target) return true;
			else if (matrix[x][y] > target) {
			  y --;
			} else {
				x ++;
			}
		}
		
		return result;
		
		
	}
	
	
}
