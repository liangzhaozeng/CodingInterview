package algorithm.basic.graph;

import java.util.ArrayList;

public class GraphCycleII {

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
			for (int i = 0; i < V; i++) {
				this.adj.add(new ArrayList<Integer>());
			}
		}

		/**
		 * 
		 * @param v
		 * @param w
		 */
		void addEdge(int v, int w) {
			adj.get(v).add(w);

		}
	}

	static boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack,
			Graph graph) {
		if (visited[v] == false) {
			// Mark the current node as visited and part of recursion stack
			visited[v] = true;
			recStack[v] = true;

			// Recur for all the vertices adjacent to this vertex

			for (int i = 0; i < graph.adj.get(v).size(); i++) {
				if (!visited[graph.adj.get(v).get(i)]
						&& isCyclicUtil(graph.adj.get(v).get(i), visited,
								recStack, graph))
					return true;
				else if (recStack[graph.adj.get(v).get(i)])
					return true;
			}

		}
		recStack[v] = false; // remove the vertex from recursion stack
		return false;
	}

	// Returns true if the graph contains a cycle, else false.
	// This function is a variation of DFS() in
	// http://www.geeksforgeeks.org/archives/18212
	static boolean isCyclic(Graph graph) {
		// Mark all the vertices as not visited and not part of recursion
		// stack
		int V = graph.V;
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
			recStack[i] = false;
		}

		// Call the recursive helper function to detect cycle in different
		// DFS trees
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack, graph))
				return true;

		return false;
	}

	public static void main(String[] args) {
		
			// Create a graph given in the above diagram
			Graph g = new Graph(4);
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);

			if (isCyclic(g))
				System.out.println("Graph contains cycle");
			else
				System.out.println("Graph doesn't contain cycle");

		

	}
}
