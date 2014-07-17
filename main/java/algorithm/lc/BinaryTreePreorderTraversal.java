package algorithm.lc;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3
 * 
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreePreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * O(n) space, O(n) time.
	 * 
	 */
	public class Solution {

		public ArrayList<Integer> preorderTraversal2(TreeNode root) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			TreeNode current, pre;

			if (root == null)
				return result;

			current = root;
			while (current != null) {
				if (current.left == null) { // if left is null, then access the
											// current root first
					result.add(current.val);
					current = current.right;
				} else {
					/* Find the inorder predecessor of current */
					pre = current.left;
					while (pre.right != null && pre.right != current) {
						pre = pre.right; /*
										 * Make current as right child of its
										 * inorder predecessor
										 */
					}
					if (pre.right == null) {
						pre.right = current;
						result.add(current.val);
						current = current.left;
					} else { // Revert the changes made in if part to restore
								// the
						pre.right = null; // original tree i.e., fix the right
											// child of predecssor

						current = current.right; // left child tree is done, go
													// to right
					} /* End of if condition pre->right == NULL */
				} /* End of if condition current->left == NULL */
			} /* End of while */

			return result;
		}

		public ArrayList<Integer> preorderTraversal(TreeNode root) {
			// IMPORTANT: Please reset any member data you declared, as
			// the same Solution instance will be reused for each test case.
			ArrayList<Integer> res = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			if (root != null) {
				stack.push(root);
			}

			while (!stack.isEmpty()) {
				TreeNode cur = stack.pop();
				res.add(cur.val);
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
			}
			return res;
		}
	}

}
