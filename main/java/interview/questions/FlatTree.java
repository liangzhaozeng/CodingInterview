package interview.questions;

import algorithm.lc.BinaryTreePostorderTraversal.TreeNode;

public class FlatTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode next;
		TreeNode prev;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode bstToDll(TreeNode root) {
		if (root == null)
			return null;

		TreeNode lefthead = bstToDll(root.left); // traverse down to left
		TreeNode righthead = bstToDll(root.right); // traverse down to right
		TreeNode temp = null;
		/*
		 * lefthead represents head of link list created in left of node
		 * righthead represents head of link list created in right travel to end
		 * of left link list and add the current node in end
		 */
		if (lefthead != null) {
			temp = lefthead;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = root;
		} else {
			lefthead = root;
		}
		root.prev = temp;
		/*
		 * set the next node of current root to right head of right list
		 */
		if (righthead != null) {
			root.next = righthead;
			righthead.prev = root;
		} else {
			righthead = root;
		}
		return lefthead;// return left head as the head of the list added with
						// current node

	}
}
