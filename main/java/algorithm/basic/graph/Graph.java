package algorithm.basic.graph;

import java.util.ArrayList;

public class Graph {
	
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
		adj.get(w).add(v);
	}

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
