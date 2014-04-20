package algorithm.basic;

public class KnapSack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	static public class Item {
		public int size;
		public int val;
	}
	
	
	
	static int knap(int cap, Item[] items, int N) {
		int i, space, max, t;
		
		for (i = 0, max=0; i <N; i ++) {
			if ((space=cap-items[i].size) >=0)
				if ((t=knap(space, items, N-1)+ items[i].val)>max)
					max =t;
		
		}
		return max;
	}
	
	


	// Returns the maximum value that can be put in a knapsack of capacity W
   public int knapSack(int wt[], int val[]) {
		
		int n = val.length;
		int W = wt.length;
		int[][] K = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}
   
   
   int knapSack(int W, int wt[], int val[], int n)
   {
      // Base Case
      if (n == 0 || W == 0)
          return 0;
    
      // If weight of the nth item is more than Knapsack capacity W, then
      // this item cannot be included in the optimal solution
      if (wt[n-1] > W)
          return knapSack(W, wt, val, n-1);
    
      // Return the maximum of two cases: (1) nth item included (2) not included
      else return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                       knapSack(W, wt, val, n-1)
                     );
   }
}
