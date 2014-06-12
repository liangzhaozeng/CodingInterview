package algorithm.basic.graph;

public class PrimMST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Let us create the following graph
        2    3
    (0)--(1)--(2)
     |   / \   |
    6| 8/   \5 |7
     | /     \ |
    (3)-------(4)
          9          */
 int[][] graph = {{0, 2, 0, 6, 0},
                  {2, 0, 3, 8, 5},
                  {0, 3, 0, 0, 7},
                  {6, 8, 0, 0, 9},
                  {0, 5, 7, 9, 0},
                   };

  // Print the solution
  primMST(graph);
	}

	
	public static int minKey(int[] key, boolean[] mstSet)
	{
	   // Initialize min value
	   int min = Integer.MAX_VALUE; 
		int	   min_index =0;
	 
	   for (int v = 0; v < key.length; v++)
	     if (mstSet[v] == false && key[v] < min) {
	    	 
	     
	         min = key[v];
	         min_index = v;
	     }
	   return min_index;
	}
	
	// Function to construct and print MST for a graph represented using adjacency
	// matrix representation
	public static void primMST(int[][] graph)
	{
		 int V = graph.length;
	     int[]  parent = new int[V]; // Array to store constructed MST
	     int[] key = new int[V];   // Key values used to pick minimum weight edge in cut
	     boolean[] mstSet = new boolean[V];  // To represent set of vertices not yet included in MST
	 
	     // Initialize all keys as INFINITE
	     for (int i = 0; i < V; i++) {
	        key[i] = Integer.MAX_VALUE;
	        mstSet[i] = false;
	     }
	     // Always include first 1st vertex in MST.
	     key[0] = 0;     // Make key 0 so that this vertex is picked as first vertex
	     parent[0] = -1; // First node is always root of MST 
	 
	     // The MST will have V vertices
	     for (int count = 0; count < V-1; count++)
	     {
	        // Pick thd minimum key vertex from the set of vertices
	        // not yet included in MST
	        int u = minKey(key, mstSet);
	 
	        // Add the picked vertex to the MST Set
	        mstSet[u] = true;
	 
	        // Update key value and parent index of the adjacent vertices of
	        // the picked vertex. Consider only those vertices which are not yet
	        // included in MST
	        for (int v = 0; v < V; v++)
	 
	           // graph[u][v] is non zero only for adjacent vertices of m
	           // mstSet[v] is false for vertices not yet included in MST
	           // Update the key only if graph[u][v] is smaller than key[v]
	          if (graph[u][v] !=0 && mstSet[v] == false && graph[u][v] <  key[v]) {
	             parent[v]  = u;
	             key[v] = graph[u][v];
	          }
	     }
	 
	     // print the constructed MST
	     printMST(parent, graph);
	}
	public static void printMST(int[] parent, int[][] graph)
	{
	   System.out.println("Edge   Weight\n");
	   for (int i = 1; i < parent.length; i++)
		   System.out.format("%d - %d    %d \n", parent[i], i, graph[i][parent[i]]);
	}
}
