package algorithm.basic.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

	static void BFS1(Graph graph, int s) {
		int V = graph.V;
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Create a queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		// 'i' will be used to get all adjacent vertices of a vertex

		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			int cur = queue.poll();
			System.out.print(cur + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it visited
			// and enqueue it
			for (int i = 0; i < graph.adj.get(cur).size(); i++) {
				if (!visited[graph.adj.get(cur).get(i)]) {
					visited[graph.adj.get(cur).get(i)] = true;
					queue.add(graph.adj.get(cur).get(i));
				}
			}
		}
	}

	// Driver program to test methods of graph class
	public static void main(String[] args) {

		// Create a graph given in the above diagram
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out
				.println("Following is Breadth First Traversal (starting from vertex 2) \n");
		BFS1(g, 2);

	}

}
