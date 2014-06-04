package interview.questions.linkedin;


import java.util.Stack;

public class MirrorTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 求二叉树的镜像 递归解法： 
	 * （1）如果二叉树为空，返回空
	 * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
	 */
	// 1. 破坏原来的树，把原来的树改成其镜像
	public static TreeNode mirrorRec(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = mirrorRec(root.left);
		TreeNode right = mirrorRec(root.right);

		root.left = right;
		root.right = left;
		return root;
	}
	
	// 2. 不能破坏原来的树，返回一个新的镜像树
	public static TreeNode mirrorCopyRec(TreeNode root){
		if(root == null){
			return null;
		}
		
		TreeNode newNode = new TreeNode(root.val);
		newNode.left = mirrorCopyRec(root.right);
		newNode.right = mirrorCopyRec(root.left);
		
		return newNode;
	}
	
	// 3. 判断两个树是否互相镜像
	public static boolean isMirrorRec(TreeNode r1, TreeNode r2){
		// 如果两个树都是空树，则返回true
		if(r1==null && r2==null){
			return true;
		}
		
		// 如果有一棵树是空树，另一颗不是，则返回false
		if(r1==null || r2==null){
			return false;
		}
		
		// 如果两个树都非空树，则先比较根节点
		if(r1.val != r2.val){
			return false;
		}
		
		// 递归比较r1的左子树的镜像是不是r2右子树 和 
		// r1的右子树的镜像是不是r2左子树
		return isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);
	}
	
	// 1. 破坏原来的树，把原来的树改成其镜像
	public static void mirror(TreeNode root) {
		if(root == null){
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while( !stack.isEmpty() ){
			TreeNode cur = stack.pop();
			
			// 交换左右孩子
			TreeNode tmp = cur.right;
			cur.right = cur.left;
			cur.left = tmp;
			
			if(cur.right != null){
				stack.push(cur.right);
			}
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
	}
	
	// 2. 不能破坏原来的树，返回一个新的镜像树
	public static TreeNode mirrorCopy(TreeNode root){
		if(root == null){
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> newStack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode newRoot = new TreeNode(root.val);
		newStack.push(newRoot);
		
		while( !stack.isEmpty() ){
			TreeNode cur = stack.pop();
			TreeNode newCur = newStack.pop();
			
			if(cur.right != null){
				stack.push(cur.right);
				newCur.left = new TreeNode(cur.right.val);
				newStack.push(newCur.left);
			}
			if(cur.left != null){
				stack.push(cur.left);
				newCur.right = new TreeNode(cur.left.val);
				newStack.push(newCur.right);
			}
		}
		
		return newRoot;
	}
	
		

}
