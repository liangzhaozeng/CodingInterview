package algorithm.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestReplaceElemToGetSum {
  
  @Test
  public void testReplaceElemToGetSum() {
    ReplaceElemToGetSum replace = new ReplaceElemToGetSum();
    int[] arr1 = {1, 2, 5, 7, 7, 8};
    int sum1 = 26;
    
    assertEquals(6, replace.replaceElemToGetSum(arr1, sum1));
    
    int[] arr2 = {1, 2, 5, 7, 7, 9, 10};
    int sum2 = 7;
    assertEquals(1, replace.replaceElemToGetSum(arr2, sum2));
    
    int[] arr3 = {2, 5, 1, 62, 5};
    int sum3 = 0;
    assertEquals(0, replace.replaceElemToGetSum(arr3, sum3));
  }

}
