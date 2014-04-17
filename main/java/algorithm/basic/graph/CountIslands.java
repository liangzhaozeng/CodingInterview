package algorithm.basic.graph;

import java.util.Arrays;

public class CountIslands {

	// A function to check if a given cell (row, col) can be included in DFS
	static boolean isSafe(int[][] M, int row, int col, boolean visited[][])
	{
		int ROW = M.length;
		int COL = M[0].length;
	    return (row >= 0) && (row < ROW) &&     // row number is in range
	           (col >= 0) && (col < COL) &&     // column number is in range
	           (M[row][col]==1 && !visited[row][col]); // value is 1 and not yet visited
	}
	 
	// A utility function to do DFS for a 2D boolean matrix. It only considers
	// the 8 neighbors as adjacent vertices
	static void DFS(int[][] M, int row, int col, boolean[][] visited){
	    // These arrays are used to get row and column numbers of 8 neighbors 
	    // of a given cell
	     final int[] rowNbr = {-1, -1, -1,  0, 0,  1, 1, 1};
	     final int[] colNbr = {-1,  0,  1, -1, 1, -1, 0, 1};
	 
	    // Mark this cell as visited
	    visited[row][col] = true;
	    System.out.println("visited  " + row + " " + col);
	 
	    // Recur for all connected neighbours
	    for (int k = 0; k < 8; ++k)
	        if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
	            DFS(M, row + rowNbr[k], col + colNbr[k], visited);
	}
	 
	// The main function that returns count of islands in a given boolean
	// 2D matrix
	static int count(int[][] M)
	{
	    // Make a bool array to mark visited cells.
	    // Initially all cells are unvisited
		int ROW = M.length;
		int COL = M[0].length;
	    boolean[][]  visited = new boolean[ROW][COL];
	    for (int i = 0; i < ROW; i ++) {
	    Arrays.fill(visited[i], false);
	    }
	    // Initialize count as 0 and travese through the all cells of
	    // given matrix
	    int count = 0;
	    for (int i = 0; i < ROW; ++i)
	        for (int j = 0; j < COL; ++j)
	            if (M[i][j]==1 && !visited[i][j]) // If a cell with value 1 is not
	            {                              // visited yet, then new island found
	            	System.out.println(" Call DFS ");
	                DFS(M, i, j, visited);     // Visit all cells in this island.
	                ++count;                   // and increment island count
	            }
	 
	    return count;
	}
	 
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  int[][] M= {  {1, 1, 0, 0, 0},
			            {0, 1, 0, 0, 1},
			            {1, 0, 0, 1, 1},
			            {0, 0, 0, 0, 0},
			            {1, 0, 1, 0, 1}
			    };
			 
			   System.out.println("Number of islands is: " + count(M));

	}

}
