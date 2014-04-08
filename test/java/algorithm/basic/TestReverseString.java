package algorithm.basic;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestReverseString {
  
  @Test
  public void testReverseString() {
    ReverseString rev = new ReverseString();
    char[] arr1 = "this is a test".toCharArray();
    char[] expected1 = new StringBuilder(new String(arr1)).reverse().toString().toCharArray();
    rev.reverse(arr1);
    assertArrayEquals(expected1, arr1);
    
    char[] arr2 = "FDlkjdasfuISDLFSK89%$^LKSDJ$ dDfdaf aDF l;kfd3".toCharArray();
    char[] expected2 = new StringBuilder(new String(arr2)).reverse().toString().toCharArray();
    rev.reverse(arr2);
    assertArrayEquals(expected2, arr2);
  }

}
