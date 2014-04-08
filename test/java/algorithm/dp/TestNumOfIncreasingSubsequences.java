package algorithm.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNumOfIncreasingSubsequences {
  
  @Test
  public void testNumOfIncreasingSubsequences() {
    NumOfIncreasingSubsequences subseq = new NumOfIncreasingSubsequences();
    
    int[] arr0 = {};
    assertEquals(0, subseq.numOfIncreasingSubsequences(arr0));
    
    int[] arr1 = {1, 3, 2, 5};
    assertEquals(11, subseq.numOfIncreasingSubsequences(arr1));
    
    int[] arr2 = {1, 2, 3, 5, 6};
    assertEquals(31, subseq.numOfIncreasingSubsequences(arr2));
  }

}
