package interview.questions.google;

import java.util.LinkedList;

public class SwapNoteInTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
		TreeNode root;
		public boolean swapSubTrees(TreeNode n1, TreeNode n2){
			if(n1 == root || n2==root)
				return false;
			
			/*search for parents*/
			LinkedList<TreeNode> Q = new LinkedList<TreeNode>();
			TreeNode p1=null, p2=null, curr=root;
			if(curr!=null)
				Q.add(curr);
			else
				return false;
			while(! Q.isEmpty()){
				curr = Q.remove();
				if(curr.left == n1 || curr.right == n1)
					p1=curr;
				if(curr.left == n2 || curr.right == n2)
					p2=curr;

				if(p1 == null || p2 == null){
					if(curr.left!=null)
						Q.add(curr.left);
					if(curr.right!=null)
						Q.add(curr.right);
				}
				else
					break;
			}
			if(p1==null || p2==null)
				return false;
			else{
				if(p1.left == n1)
					p1.left = n2;
				else
					p1.right = n2;

				if(p2.left == n2)
					p2.left = n1;
				else
					p2.right = n1;
			}
			return true;
	       }

		public class TreeNode<K,V>{
			K key;
			V val;
			TreeNode left;
			TreeNode right;
			/* Assume appropriate constructors and insert fns exist*/
	        }
	
	
}