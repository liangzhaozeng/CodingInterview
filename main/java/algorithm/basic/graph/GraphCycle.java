package algorithm.basic.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphCycle {

	// A union-find algorithm to detect cycle in a graph

	// a structure to represent an edge in graph
	public static class Edge {
		public int src;
		public int dest;

		public Edge() {
		}
	}

	// a structure to represent a graph
	public static class Graph {
		// V-> Number of vertices, E-> Number of edges
		public int V;
		public int E;

		// graph is represented as an array of edges
		public ArrayList<Edge> edges;

		public Graph(int V, int E) {
			this.V = V;
			this.E = E;
			this.edges = new ArrayList<Edge>();
			for (int i = 0; i < E; i++) {
				this.edges.add(new Edge());
			}

		}
	}

	// A utility function to find the subset of an element i
	static int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	// A utility function to do union of two subsets
	static void Union(int parent[], int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	// The main function to check whether a given graph contains cycle or not
	public static boolean isCycle(Graph graph) {
		// Allocate memory for creating V subsets
		int[] parent = new int[graph.V];

		Arrays.fill(parent, -1);

		// Iterate through all edges of graph, find subset of both
		// vertices of every edge, if both subsets are same, then there is
		// cycle in graph.
		for (int i = 0; i < graph.E; ++i) {
			int x = find(parent, graph.edges.get(i).src);
			int y = find(parent, graph.edges.get(i).dest);

			if (x == y)
				return true;

			Union(parent, x, y);
		}
		return false;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		/*
		 * Let us create following graph 0 | \ | \ 1-----2
		 */

		Graph graph = new Graph(3, 3);

		// add edge 0-1
		graph.edges.get(0).src = 0;
		graph.edges.get(0).dest = 1;

		// add edge 1-2
		graph.edges.get(1).src = 1;
		graph.edges.get(1).dest = 2;

		// add edge 0-2
		graph.edges.get(2).src = 0;
		graph.edges.get(2).dest = 2;

		if (isCycle(graph))
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");

	}

}
