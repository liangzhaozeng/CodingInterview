package algorithm.lc;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example: Given the below binary tree,
 * 
 *      1 
 *     / \ 
 *    2   3
 * 
 * Return 6.
 */
// O(1) space, O(n) time
public class BinaryTreeMaximumPathSum {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
  
  /*
  此题甚难。后来看了参考才做出来的。

  基本的思路就是，在递归中计算包含该root的最大值并更新至max[0]（Java无法按引用传，就只能建立一个数组or something）。

  包含该root的最大值有如下几种可能：1.root本身；2.root和左子树中一条路径；3.root和右子树中一条路径；4.左子树一条路径和root和右子树一条路径。其中取最大就可更新至max[0]

  其中1，2，3可用来计算上一级的root的最大值，所以要传回去。

  最终，对于最上层的root来说，数内的最大路径不一定要经过根，但由于每个节点都遍历到，其最大值已经存在max[0]里面了。
  */

  public class Solution {
    public int maxPathSum(TreeNode root) {
          // IMPORTANT: Please reset any member data you declared, as
          // the same Solution instance will be reused for each test case.
      int[] max = new int[1];
      max[0] = Integer.MIN_VALUE; 
      maxPath(root, max);
      return max[0];
    }
    
    /**
     *  Store the maximize path and return the max extensible path.
     */
    private int maxPath(TreeNode node, int[] max) {
      if (node == null) {
        return 0;
      }
      int leftExt = maxPath(node.left, max);
      int rightExt = maxPath(node.right, max);
      
      int maxExt = Math.max(Math.max(leftExt, rightExt), 0) + node.val;
      max[0] = Math.max(Math.max(maxExt, max[0]), leftExt + rightExt + node.val);
      return maxExt;
    }
  }

}