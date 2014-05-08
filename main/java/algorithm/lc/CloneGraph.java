package algorithm.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * 
 * 1 / \ / \ 0 --- 2 / \ \_/
 * 
 * 
 */
public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public class Solution {

		public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (node == null) {
				return node;
			}
			UndirectedGraphNode result = new UndirectedGraphNode(node.label);
			Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
			queue.offer(node);
			Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
			map.put(node, result);

			while (!queue.isEmpty()) {
				UndirectedGraphNode nodeInQueue = queue.poll();
				ArrayList<UndirectedGraphNode> neighbors = nodeInQueue.neighbors;
				for (int i = 0; i < neighbors.size(); i++) {
					UndirectedGraphNode n1 = neighbors.get(i);
					if (map.containsKey(n1)) {
						map.get(nodeInQueue).neighbors.add(map.get(n1));
					} else {
						UndirectedGraphNode n1clone = new UndirectedGraphNode(n1.label);
						map.get(nodeInQueue).neighbors.add(n1clone);
						map.put(n1, n1clone);
						queue.offer(n1);
					}
				}

			}
			return result;
		}

		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			// Note: The Solution object is instantiated only once and is reused
			// by
			// each test case.
			if (node == null) {
				return null;
			}
			Map<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
			return copy(node, visited);
		}

		private UndirectedGraphNode copy(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {
			if (node == null) {
				return null;
			}

			UndirectedGraphNode newNode = visited.get(node.label); // find
																	// existing
																	// new node
			if (newNode != null) {
				return newNode;
			}

			newNode = new UndirectedGraphNode(node.label);
			visited.put(node.label, newNode); // add new node to index

			for (UndirectedGraphNode neighbor : node.neighbors) {
				newNode.neighbors.add(copy(neighbor, visited));
			}

			return newNode;
		}
	}

}
