package algorithm.basic.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {

	
	
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
	 
	// A BFS based function to check whether d is reachable from s.
	static boolean isReachable(int s, int d, Graph graph)
	{
		int V = graph.V;
	    // Base case
	    if (s == d)
	      return true;
	 
	    // Mark all the vertices as not visited
	    boolean[] visited = new boolean[V];
	    for (int i = 0; i < V; i++)
	        visited[i] = false;
	 
	    // Create a queue for BFS
	    Queue<Integer> queue = new LinkedList<Integer>();
	 
	    // Mark the current node as visited and enqueue it
	    visited[s] = true;
	    queue.add(s);
	 
	    // it will be used to get all adjacent vertices of a vertex
//	    list<int>::iterator i;
	 
	    while (!queue.isEmpty())
	    {
	        // Dequeue a vertex from queue and print it
	        s = queue.poll();
	       
	        // Get all adjacent vertices of the dequeued vertex s
	        // If a adjacent has not been visited, then mark it visited
	        // and enqueue it
	        for (int i = 0; i< graph.adj.get(s).size(); i ++)
	        {
	            // If this adjacent node is the destination node, then return true
	            if (graph.adj.get(s).get(i) == d)
	                return true;
	 
	            // Else, continue to do BFS
	            if (!visited[graph.adj.get(s).get(i)])
	            {
	                visited[graph.adj.get(s).get(i)] = true;
	                queue.add(graph.adj.get(s).get(i));
	            }
	        }
	    }
	 
	    return false;
	}
	 
	// Driver program to test methods of graph class
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    // Create a graph given in the above diagram
	    Graph g = new Graph(4);
	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	 
	    int u = 1, v = 3;
	    if(isReachable(u, v, g ))
	        System.out.print( "\n There is a path from " + u + " to " + v);
	    else
	    	System.out.print( "\n There is no path from " + u + " to " + v);
	 
	    u = 3;
	    v = 1;
	    if(isReachable(u, v, g))
	    	  System.out.print( "\n There is a path from " + u + " to " + v);
	    else
	    	System.out.print( "\n There is no path from " + u + " to " + v);
	 
	   
	}

}
