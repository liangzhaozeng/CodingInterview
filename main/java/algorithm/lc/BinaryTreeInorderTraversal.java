package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 * 1 \ 2 / 3
 * 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreeInorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// O(n) space, O(n) time
	public class Solution {

		public ArrayList<Integer> inorderTraversal2(TreeNode root) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			TreeNode current, pre;

			if (root == null)
				return result;

			current = root;
			while (current != null) {
				if (current.left == null) {
					result.add(current.val);
					current = current.right;
				} else {
					/* Find the inorder predecessor of current */
					pre = current.left;
					while (pre.right != null && pre.right != current)
						pre = pre.right; /* Make current as right child of its inorder predecessor */
					if (pre.right == null)  {
						pre.right = current;
						current = current.left;
					}	else {                     // Revert the changes made in if part to restore the
						pre.right = null;          // original tree i.e., fix the right child of predecssor
						result.add(current.val);
						current = current.right;
					} /* End of if condition pre->right == NULL */
				} /* End of if condition current->left == NULL */
			} /* End of while */

			return result;
		}

		public ArrayList<Integer> inorderTraversal(TreeNode root) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			TreeNode cur = root;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			ArrayList<Integer> res = new ArrayList<Integer>();

			while (cur != null || !stack.isEmpty()) {
				// push all left
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}

				TreeNode next = stack.pop();
				res.add(next.val);

				// push right
				cur = next.right;
			}

			return res;
		}
	}

}
