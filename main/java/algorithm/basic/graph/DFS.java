package algorithm.basic.graph;

import java.util.ArrayList;
import java.util.Stack;

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
	static void DFS2(Graph graph, int v) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[graph.V];
		for (int i = 0; i < graph.V; i++)
			visited[i] = false;

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited, graph);
	}

	/*
	 * def dfs2(G,s): visited = set() stack = [s] while stack: v = stack.pop()
	 * if v not in visited: visited.add(v) for w in G[v]: stack.append(w)
	 */

	static void DFS1(Graph graph, int v) {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[graph.V];
		for (int i = 0; i < graph.V; i++)
			visited[i] = false;

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);

		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (!visited[vertex]) {
				System.out.println("Visiting " + vertex + "  ");
				visited[vertex] = true;

				for (int i = 0; i < graph.adj.get(vertex).size(); i++) {
					int newVertex = graph.adj.get(vertex).get(i);
					System.out.println("Pushing  " + newVertex + " into stack ");
					stack.push(newVertex);

				}
			}
		}
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
		DFS2(g, 2);
		System.out.println();
		System.out
				.println("Following is Depth First Traversal (starting from vertex 2) ");
		DFS1(g, 2);

	}

}
