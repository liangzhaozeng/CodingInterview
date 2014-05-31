package interview.questions;

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
public class BSTConstruction {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static void main(String[] args) {
	   int[] A = { 5, 2, 1,4,6,8};
	   TreeNode root = constructFromPreOrder(A);
	   preOrder(root);
   }
	public static TreeNode constructFromPreOrder(int[] A) {
		if (A == null || A.length == 0)
			return null;
		TreeNode root = generate(A, 0, A.length -1);
		return root;

	}

	public static void preOrder(TreeNode root){
		if (root == null) return;
		if (root != null) System.out.println(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	private static TreeNode generate(int[] A, int start, int end) {
	
		if (start>end) return null;
		if (end == start) {
			TreeNode root = new TreeNode(A[start]);
			return root;
		}

		TreeNode root = new TreeNode(A[start]);
		int rightRootIdx = 0;
		for (int i = start + 1; i <= end; i++) {
			if (A[i] > A[start]) {
				rightRootIdx = i;
				break;
			}
		}
		if (rightRootIdx == 0) {
			root.right = null;
			root.left = generate(A, start + 1, end);
		} else {
			root.left = generate(A, start + 1, rightRootIdx - 1);
			root.right = generate(A, rightRootIdx, end);
		}
		return root;
	}

}
