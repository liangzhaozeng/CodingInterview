package algorithm.basic.graph;

import java.util.ArrayList;

public class DFS {

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

	static void DFSUtil(int v, boolean visited[], Graph graph) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex

		for (int i = 0; i < graph.adj.get(v).size(); ++i)
			if (!visited[graph.adj.get(v).get(i)])
				DFSUtil(graph.adj.get(v).get(i), visited, graph);
	}

	// DFS traversal of the vertices reachable from v. It uses recursive
	// DFSUtil()
	static void DFS(Graph graph, int v) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[graph.V];
		for (int i = 0; i < graph.V; i++)
			visited[i] = false;

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited, graph);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out
				.println("Following is Depth First Traversal (starting from vertex 2) ");
		DFS(g, 2);

	}

}
