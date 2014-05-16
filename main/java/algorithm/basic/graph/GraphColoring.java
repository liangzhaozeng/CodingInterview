package algorithm.basic.graph;

public class GraphColoring {

	public static int[] solution(Graph g) {
		int[] result = new int[g.V];

		result[0] = 0;

		for (int i = 1; i < g.V; i++) {
			result[i] = -1;
		}

		boolean[] available = new boolean[g.V];

		for (int i = 0; i < g.V; i++) {
			available[i] = false;
		}

		for (int i = 1; i < g.V; i++) {
			for (int j = 0; j < g.adj.get(i).size(); j++) {
				if (result[g.adj.get(i).get(j)] != -1)
					available[result[g.adj.get(i).get(j)]] = true;
			}

			int cur = 0;
			for (cur = 0; cur < g.V; cur++) {
				if (available[cur] == false)
					break;
			}

			System.out.println(" Vertex " + i + " ----> colour " + cur);
			result[i] = cur;

			for (int j = 0; j < g.adj.get(i).size(); j++) {
				if (result[g.adj.get(i).get(j)] != -1)
					available[result[g.adj.get(i).get(j)]] = false;
			}

		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g1 = new Graph(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		int[] r = solution(g1);
		for (int i = 0; i < r.length; i++) {
			System.out.println(" Vertex " + i + " ----> colour" + r[i]);
		}

		Graph g2 = new Graph(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(1, 4);
		g2.addEdge(2, 4);
		g2.addEdge(4, 3);
		int[] r2 = solution(g2);
		for (int i = 0; i < r2.length; i++) {
			System.out.println(" Vertex " + i + " ----> colour" + r2[i]);
		}
	}

}
