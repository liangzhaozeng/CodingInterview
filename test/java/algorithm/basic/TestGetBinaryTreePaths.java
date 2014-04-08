package algorithm.basic;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import algorithm.basic.GetBinaryTreePaths.TreeNode;

public class TestGetBinaryTreePaths {
  
  @Test
  public void testGetBinaryTreePaths() {
    TreeNode five = new TreeNode(5);
    TreeNode four = new TreeNode(4);
    TreeNode eight = new TreeNode(8);
    TreeNode eleven = new TreeNode(11);
    TreeNode seven = new TreeNode(7);
    TreeNode two = new TreeNode(2);
    TreeNode thirteen = new TreeNode(13);
    TreeNode four2 = new TreeNode(4);
    TreeNode five2 = new TreeNode(5);
    TreeNode one = new TreeNode(1);
    
    five.left = four;
    five.right = eight;
    
    four.left = eleven;
    eleven.left = seven;
    eleven.right = two;
    
    eight.left = thirteen;
    eight.right = four2;
    
    four2.left = five2;
    four2.right = one;
    
    GetBinaryTreePaths paths = new GetBinaryTreePaths();
    
    List<List<Integer>> res = paths.getAllPaths(five);
    for (List<Integer> path : res) {
      System.out.println(Arrays.toString(path.toArray()));
    }
  }
  
}
