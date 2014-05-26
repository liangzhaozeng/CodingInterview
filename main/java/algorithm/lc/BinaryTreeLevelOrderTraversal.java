package algorithm.lc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *       3 
 *      / \ 
 *     9  20 
 *    / \ 
 *   15  7 
 *   
 * return its level order traversal as:
 * 
 * [ [3], [9,20], [15,7] ]
 * 
 */
// O(n) space, O(n) time
public class BinaryTreeLevelOrderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
	 
	  public ArrayList<ArrayList<Integer>> levelOrderR(TreeNode root) {
		  
		  ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		  
		  traverse(root, 1, res);
		
		  return res;
		  
	  }
	  
	  void traverse(TreeNode root, int level,  ArrayList<ArrayList<Integer>> res) {
		  if (root == null) return ;
		  if (level > res.size()) 
			  res.add(new ArrayList<Integer>());
		  res.get(level-1).add(root.val);
		  traverse(root.left, level +1, res);
		  traverse(root.right, level +1, res);
		  
	  }
	  
	  
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      if (root != null) {
        queue.add(root);
      }
      ArrayList<Integer> curLevel = new ArrayList<Integer>();
      ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();

      while (!queue.isEmpty()) {
        // pop one level of nodes per time
        while (!queue.isEmpty()) {
          TreeNode node = queue.poll();
          curLevel.add(node.val);
          if (node.left != null) {
            nextLevel.add(node.left);
          }
          if (node.right != null) {
            nextLevel.add(node.right);
          }
        }
        res.add(curLevel);
        curLevel = new ArrayList<Integer>();
        queue.addAll(nextLevel);
        nextLevel.clear();
      }
     
      Collections.reverse(res);
      return res;
    }
  }

}
