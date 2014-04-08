package algorithm.recursive;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestNextPalindrome {
  
  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {{1, 2}, {9, 11}, {18, 22}, {1001, 1111}, {9999, 10001}});
  }

  private static NextPalindrome next;
  
  private int num;  
  private int expected;
  
  @BeforeClass
  public static void setup() {
    next = new NextPalindrome();
  }

  public TestNextPalindrome(int num, int expected) {
    this.num = num;
    this.expected = expected;
  }
  
  @Test
  public void testNextPalindrome() {
    assertEquals(expected, next.nextPalindrome(num));
  }

}
