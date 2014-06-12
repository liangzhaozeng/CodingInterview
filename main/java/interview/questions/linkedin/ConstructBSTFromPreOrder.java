package interview.questions.linkedin;

import java.util.Stack;



public class ConstructBSTFromPreOrder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pre[] = {10, 5, 1, 7, 40, 50};
		TreeNode root = constructTree(pre);
		preOrder(root);
	}

	public static void preOrder(TreeNode root) {
		if (root == null) return;
		System.out.println(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public TreeNode build(int[] val) {
		Stack<TreeNode> ns = new Stack<TreeNode>();
		TreeNode root = new TreeNode(val[0]);
		ns.push(root);
		TreeNode last = null;
		for (int i = 1; i < val.length; i++) {
			TreeNode n = new TreeNode(val[i]);
			if (val[i] < ns.peek().val) {
				ns.peek().left = n;
			} else {
				for (last = ns.pop(); ns.size() > 0 && ns.peek().val <= val[i]; ns.pop())
					;
				if (ns.size() == 0) {
					last.right = n;
				} else {
					ns.peek().left = n;
				}
				ns.push(n);
			}
		}
		return root;
	}

	// A recursive function to construct BST from pre[]. preIndex is used
	// to keep track of index in pre[].
	public static TreeNode constructTreeUtil(int pre[], int[] preIndex, int key, int min, int max) {
		// Base case
		if (preIndex[0] >= pre.length)
			return null;

		TreeNode root = null;

		// If current element of pre[] is in range, then
		// only it is part of current subtree
		if (key > min && key < max) {
			// Allocate memory for root of this subtree and increment *preIndex
			root = new TreeNode(key);
			preIndex[0] = preIndex[0] + 1;

			if (preIndex[0] < pre.length) {
				// Contruct the subtree under root
				// All nodes which are in range {min .. key} will go in left
				// subtree, and first such node will be root of left subtree.
				root.left = constructTreeUtil(pre, preIndex, pre[preIndex[0]], min, key);

				// All nodes which are in range {key..max} will go in right
				// subtree, and first such node will be root of right subtree.
				root.right = constructTreeUtil(pre, preIndex, pre[preIndex[0]], key, max);
			}
		}

		return root;
	}

	// The main function to construct BST from given preorder traversal.
	// This function mainly uses constructTreeUtil()
	public static TreeNode constructTree(int pre[]) {
		int[] preIndex = { 0 };
		return constructTreeUtil(pre, preIndex, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

}
