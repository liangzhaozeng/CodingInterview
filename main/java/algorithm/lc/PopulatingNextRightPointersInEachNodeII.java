package algorithm.lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree,
 * 
 *        1 
 *       / \ 
 *      2   3 
 *     / \   \ 
 *    4   5   7 
 * After calling your function, the tree should look like:
 * 
 *        1 -> NULL 
 *      /   \ 
 *     2  -> 3 -> NULL 
 *    / \     \ 
 *   4 -> 5 -> 7 -> NULL
 * 
 */
public class PopulatingNextRightPointersInEachNodeII {

  public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }
  
  public class Solutionq2 {
	    public void connect(TreeLinkNode root) {
	        if(root == null)
	            return;
	        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
	        queue.offer(root);
	        int leftCount = 1;
	        TreeLinkNode last = null;
	        while(!queue.isEmpty()){
	            if(leftCount == 0){
	                leftCount = queue.size();
	                last = null;
	            }
	            TreeLinkNode node = queue.poll();
	            leftCount--;
	            if(node.left != null)
	                queue.offer(node.left);
	            if(node.right != null)
	                queue.offer(node.right);
	            if(last != null)
	                last.next = node;
	            last = node;
	        }
	    }
	}
  
  public class Solutionq {  
	    public void connect(TreeLinkNode root) {  
	        // Note: The Solution object is instantiated only once and is reused by each test case.  
	        if(root == null)  
	            return ;  
	        Queue<TreeLinkNode> que = new LinkedList<TreeLinkNode>();  
	        que.add(root);  
	        que.add(null);  
	        while(true)  
	        {  
	            //poll() method return the head of queue and remove it.  
	            TreeLinkNode cur = que.poll();  
	            if(que.isEmpty())  
	                break;  
	            if(cur != null)  
	            {  
	                cur.next = que.peek();  
	            }  
	            else  
	            {  
	                que.add(null);  
	                continue;  
	            }  
	            if(cur.left != null)  
	                que.add(cur.left);  
	            if(cur.right != null)  
	                que.add(cur.right);  
	        }  
	          
	    }  
	}  

  // O(1) space, O(n) time
  // recurively linke right sub-tree and left sub-tree
  public class Solution {
    public void connect(TreeLinkNode root) {
          // Note: The Solution object is instantiated only once and is reused by each test case.
      if (root == null) {
        return;
      }      
      if (root.left != null && root.right != null) {
        root.left.next = root.right;
      }
      if (root.next != null) {
        TreeLinkNode nextStart = root.right == null? root.left : root.right;
        if (nextStart != null) {
          TreeLinkNode nextParent = root.next;
          while (nextParent != null && nextParent.left == null && nextParent.right == null) {
            nextParent = nextParent.next;
          }
          if (nextParent != null) {
            nextStart.next = nextParent.left != null? nextParent.left : nextParent.right;
          }
        }
      }
      connect(root.right);
      connect(root.left);
    }
  }
  
  public class Solution2 {
    public void connect(TreeLinkNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (root == null) {
        return;
      }       
      TreeLinkNode linkToNext = null;
      if (root.left != null) {
        root.left.next = root.right;
        linkToNext = root.left;
      }
      if (root.right != null) {
        linkToNext = root.right;
      }
      // link next to another sub-tree
      TreeLinkNode nextToLink = null;
      TreeLinkNode nextNode = root.next;
      while (nextNode != null && nextToLink == null) {
        if (nextNode.left != null) {
          nextToLink = nextNode.left;
        }
        else {
          nextToLink = nextNode.right;
        }
        nextNode = nextNode.next;
      }
      
      if (linkToNext != null) {
        linkToNext.next = nextToLink;
      }
      
      connect(root.right);
      connect(root.left);
    }
  }
  
}