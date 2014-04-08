package algorithm.recursive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.recursive.NumberOfZeroGroups;

public class TestNumberOfZeroGroups {
  
  @Test
  public void testNumOfZeroGroups() {
    NumberOfZeroGroups groups = new NumberOfZeroGroups();
    
    int[][] mat1 = {
        {0, 0, 1, 1, 1},
        {0, 1, 1, 0, 0},
        {1, 1, 1, 1, 0},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1}
    };
    assertEquals(3, groups.numberOfZeroGroups(mat1));
    
    int[][] mat2 = {
        {0, 0, 1, 1, 1},
        {0, 1, 1, 0, 0},
        {1, 1, 1, 1, 0},
        {1, 0, 1, 0, 1},
        {1, 1, 0, 1, 1}
    };
    assertEquals(5, groups.numberOfZeroGroups(mat2));
    
    int[][] mat3 = {
        {0, 0, 1, 1, 1, 0},
        {0, 1, 1, 0, 0, 0},
        {1, 1, 1, 1, 0, 0},
        {1, 0, 1, 0, 1, 0},
        {1, 1, 0, 0, 1, 0}
    };
    assertEquals(4, groups.numberOfZeroGroups(mat3));
  }

}
