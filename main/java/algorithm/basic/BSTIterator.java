package algorithm.basic;

import java.util.Iterator;
import java.util.Stack;

import algorithm.basic.BST.TreeNode;

class BSTIterator implements Iterator<Integer> {
	TreeNode root, cursor;
	Stack<TreeNode> iteratorStack;

	public BSTIterator(TreeNode root) {
		this.root = root;
		this.cursor = root;
		this.iteratorStack = new Stack<TreeNode>();
	}

	public boolean hasNext() {
		return (!iteratorStack.empty() || cursor != null);
	}

	public Integer next() {
		Integer nextNodeValue;
		while (cursor != null) {
			iteratorStack.push(cursor);
			cursor = cursor.left;
		}
		cursor = iteratorStack.pop();
		nextNodeValue = cursor.val;
		cursor = cursor.right;
		return nextNodeValue;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}
}