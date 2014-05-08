package interview.questions;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

	
	//  Definition for binary tree with next pointer.
	  public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	  }
	 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void connect(TreeLinkNode root) {
        if (root == null) return ;
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        
        queue.add(root);
        queue.add(null);
        TreeLinkNode prev = null;
        while (!queue.isEmpty()) {
        	TreeLinkNode cur = queue.poll();
        	if (prev!= null && cur != null) {
        		prev.next = cur;
        		
        	}
        	if (cur!= null && cur.left!= null) {
        		queue.add(cur.left);
        	}
        	if (cur!= null && cur.right != null) {
        		queue.add(cur.right);
        	}
        	if (cur == null && !queue.isEmpty())
        		queue.add(null);
        	prev = cur;
        }
        
        
    }
	
	
}
