package algorithm.basic.graph;

import java.util.ArrayList;
import java.util.Stack;




public class TopologicSort {
	public static class Graph {
		
		public int V; // number of the vertices
		public ArrayList<ArrayList<Integer>> adj; // array of adjacency lists
		/**
		 * 
		 * @param V
		 */
		Graph(int V) {
			this.V = V;
			this.adj = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < V; i ++) {
				this.adj.add(new ArrayList<Integer>());
			}
		}
		/**
		 * 
		 * @param v
		 * @param w
		 */
		void addEdge(int v, int w){
			adj.get(v).add(w);
		
		}
	}

	
	
	// A recursive function used by topologicalSort
	static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> Stack, Graph graph)
	{
	    // Mark the current node as visited.
	    visited[v] = true;
	 
	    // Recur for all the vertices adjacent to this vertex
	   
	    
	    for (int i = 0; i < graph.adj.get(v).size(); i ++){
	    	if (!visited[graph.adj.get(v).get(i)]) {
	    		 topologicalSortUtil(graph.adj.get(v).get(i), visited, Stack, graph);
	    	}
	    }
	    
	    // Push current vertex to stack which stores result
	    Stack.push(v);
	}
	 
	// The function to do Topological Sort. It uses recursive topologicalSortUtil()
	static void topologicalSort(Graph graph)
	{
	    Stack<Integer> Stack = new Stack<Integer>();
	 
	    // Mark all the vertices as not visited
	    boolean[] visited = new boolean[graph.V];
	    for (int i = 0; i < graph.V; i++)
	        visited[i] = false;
	 
	    // Call the recursive helper function to store Topological Sort
	    // starting from all vertices one by one
	    for (int i = 0; i < graph.V; i++)
	      if (visited[i] == false)
	        topologicalSortUtil(i, visited, Stack, graph);
	 
	    // Print contents of stack
	    while (Stack.empty() == false)
	    {
	        System.out.print( Stack.peek() + " ");
	        Stack.pop();
	    }
	}
	 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a graph given in the above diagram
	    Graph g = new Graph(6);
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);
	 
	    System.out.println( "Following is a Topological Sort of the given graph \n");
	    topologicalSort(g);
	 
	   

	}

}
