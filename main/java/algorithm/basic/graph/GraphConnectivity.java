package algorithm.basic.graph;

import java.util.ArrayList;

public class GraphConnectivity {

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

	// A recursive function to print DFS starting from v
	static public void DFSUtil(int v, boolean[] visited, Graph graph) {
		// Mark the current node as visited and print it
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex

		for (int i = 0; i < graph.adj.get(v).size(); i++)
			if (!visited[graph.adj.get(v).get(i)])
				DFSUtil(graph.adj.get(v).get(i), visited, graph);
	}

	// Function that returns reverse (or transpose) of this graph
	static public Graph getTranspose(Graph g) {
		int V = g.V;
		Graph newG = new Graph(V);
		for (int v = 0; v < V; v++) {
			// Recur for all the vertices adjacent to this vertex

			for (int i = 0; i < g.adj.get(v).size(); i++) {
				newG.adj.get(g.adj.get(v).get(i)).add(v);
			}
		}
		return newG;
	}

	// The main function that returns true if graph is strongly connected
	static boolean isSC(Graph g) {
		int V = g.V;
		// St1p 1: Mark all the vertices as not visited (For first DFS)
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Step 2: Do DFS traversal starting from first vertex.
		DFSUtil(0, visited, g);

		// If DFS traversal doesn’t visit all vertices, then return false.
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				return false;

		// Step 3: Create a reversed graph
		Graph gr = getTranspose(g);

		// Step 4: Mark all the vertices as not visited (For second DFS)
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Step 5: Do DFS for reversed graph starting from first vertex.
		// Staring Vertex must be same starting point of first DFS
		DFSUtil(0, visited, gr);

		// If all vertices are not visited in second DFS, then
		// return false
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				return false;

		return true;
	}

	// Driver program to test above functions
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create graphs given in the above diagrams
		Graph g1 = new Graph(5);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 0);
		g1.addEdge(2, 4);
		g1.addEdge(4, 2);
		if (isSC(g1))
			System.out.println("Yes\n");
		else
			System.out.println("No\n");

		Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		if (isSC(g2))
			System.out.println("Yes\n");
		else
			System.out.println("No\n");

	}

}
