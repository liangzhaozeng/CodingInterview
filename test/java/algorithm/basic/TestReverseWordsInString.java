package algorithm.basic;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestReverseWordsInString {
  
  @Test
  public void testReverseWordsInString() {
    ReverseWordsInString rev = new ReverseWordsInString();
    char[] arr1 = "How are you?".toCharArray();
    char[] expected1 = "you? are How".toCharArray();
    rev.reverseWordsInString(arr1);
    assertArrayEquals(expected1, arr1);
    
    char[] arr2 = "Which one is the correct answer??".toCharArray();
    char[] expected2 = "answer?? correct the is one Which".toCharArray();
    rev.reverseWordsInString(arr2);
    assertArrayEquals(expected2, arr2);
    
    char[] arr3 = "What  if there are multiple    space???   ".toCharArray();
    char[] expected3 = "   space???    multiple are there if  What".toCharArray();
    rev.reverseWordsInString(arr3);
    System.out.println(Arrays.toString(arr3));
    assertArrayEquals(expected3, arr3);
  }

}
