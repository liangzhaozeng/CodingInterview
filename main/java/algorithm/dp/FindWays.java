package algorithm.dp;

public class FindWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// The main function that returns number of ways to get sum 'x'
	// with 'n' dice and 'm' with m faces.
	int findWays(int m, int n, int x)
	{
	    // Create a table to store results of subproblems.  One extra 
	    // row and column are used for simpilicity (Number of dice
	    // is directly used as row index and sum is directly used
	    // as column index).  The entries in 0th row and 0th column
	    // are never used.
	    int[][]  table = new int [n + 1][x + 1];
	 
	 
	    // Table entries for only one dice
	    for (int j = 1; j <= m && j <= x; j++)
	        table[1][j] = 1;
	 
	    // Fill rest of the entries in table using recursive relation
	    // i: number of dice, j: sum
	    for (int i = 2; i <= n; i++)
	        for (int j = 1; j <= x; j++)
	            for (int k = 1; k <= m && k < j; k++)
	                table[i][j] += table[i-1][j-k];
	 
	    /* Uncomment these lines to see content of table
	    for (int i = 0; i <= n; i++)
	    {
	      for (int j = 0; j <= x; j++)
	        cout << table[i][j] << " ";
	      cout << endl;
	    } */
	    return table[n][x];
	}
	 
}