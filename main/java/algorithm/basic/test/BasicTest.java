package algorithm.basic.test;

import algorithm.basic.BinaryTree;
import algorithm.basic.BinaryTree.TreeNode;
import algorithm.basic.FindKth;

public class BasicTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A= {1,4,5, 6,3,2, 9,7};
		FindKth.findKth(A, 4);
		
         BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
         TreeNode<Integer> treeNode = new TreeNode<Integer>(1);
         binaryTree.setRoot(treeNode);
      
         binaryTree.insert(2);
	}

}
