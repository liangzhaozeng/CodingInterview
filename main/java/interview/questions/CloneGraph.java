package interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import algorithm.lc.CloneGraph.UndirectedGraphNode;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if (node == null) return null;
	        UndirectedGraphNode newNode  = new UndirectedGraphNode(node.label);
	        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	        queue.add(node);
	        
	        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();// visited map
			map.put(node, newNode);

	        while (!queue.isEmpty()) {
	        	UndirectedGraphNode cur = queue.poll();
	        	for (UndirectedGraphNode temp: cur.neighbors) {
	        		if (map.containsKey(temp)) {
						map.get(cur).neighbors.add(map.get(temp));
					} else {
						UndirectedGraphNode n1clone = new UndirectedGraphNode(
								temp.label);
						map.get(cur).neighbors.add(n1clone);
						map.put(temp, n1clone);
						queue.add(temp);
					}
	        	}
	        }
	        
	        return newNode;
	    }
}
