package algorithm.lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */
// O(1) space, O(n) time
public class MinimumDepthOfBinaryTree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution2qaz {
	    public int minDepth(TreeNode root) {
	      if(root==null)
	            return 0;
	        Queue <TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        queue.add(null);
	        int level = 0;
	        while(queue.size()>0){
	            TreeNode current = queue.poll();
	            if(current ==null){
	                level++;
	                if(queue.size()>0)
	                    queue.add(null);
	            }
	            else{
	                if(current.left==null && current.right==null){
	                    return ++level;
	                }
	                if(current.left !=null){
	                    queue.add(current.left);
	                }
	                if(current.right !=null){
	                    queue.add(current.right);
	                }
	                }
	            }
	        return -1;   
	    }
	}
  
  // Check left subtree and right subtree recursively
  public static class Solution {
    public int minDepth(TreeNode root) {
          // Start typing your Java solution below
          // DO NOT write main() function
      if (root == null) {
        return 0;
      }
      else if (root.left == null && root.right == null) {
        return 1;
      }
      else {
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
          min = minDepth(root.left) + 1;
        }
        if (root.right != null) {
          min = Math.min(min, 1 + minDepth(root.right));
        }
        return min;
      }
    }
  }

}
