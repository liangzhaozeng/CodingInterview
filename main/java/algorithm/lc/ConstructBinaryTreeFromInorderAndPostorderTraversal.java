package algorithm.lc;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */
// O(n) space, O(n) time
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int lengthI = inorder.length;
		int lengthP = postorder.length;

		if (lengthI == 0 || lengthP == 0 || lengthI != lengthP)
			return null;

		return build(inorder, 0, lengthI - 1, postorder, 0, lengthP - 1);
	}

	TreeNode build(int[] inorder, int startI, int endI, int[] postorder, int startP, int endP) {
		if (startI > endI || startP > endP)
			return null;
		TreeNode parent = new TreeNode(postorder[endP]);
		int indxOrder = find(inorder, startI, endI, postorder[endP]);
		int rest = endI - indxOrder;
		TreeNode left = build(inorder, startI, indxOrder - 1, postorder, startP, endP - rest - 1);
		TreeNode right = build(inorder, indxOrder + 1, endI, postorder, endP - rest, endP - 1);
		parent.left = left;
		parent.right = right;
		return parent;
	}

	int find(int[] inorder, int start, int end, int target) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == target)
				return i;
		}
		return -1;
	}

	// use postorder to find the root, and use root in inorder to get left and
	// right subtree
	public class Solution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
		}

		public TreeNode buildTree(int[] inorder, int inFrom, int inTo, int[] postorder, int postFrom, int postTo) {
			if (postFrom > postTo) { // no available root
				return null;
			}

			TreeNode root = new TreeNode(postorder[postTo]);

			int rootInorderIdx = -1;
			for (int x = inFrom; x <= inTo; x++)
				if (inorder[x] == postorder[postTo]) {
					rootInorderIdx = x;
					break;
				}
			int postLeftEnd = postFrom + (rootInorderIdx - inFrom - 1);
			root.left = buildTree(inorder, inFrom, rootInorderIdx - 1, postorder, postFrom, postLeftEnd);
			root.right = buildTree(inorder, rootInorderIdx + 1, inTo, postorder, postLeftEnd + 1, postTo - 1);

			return root;
		}
	}

}
