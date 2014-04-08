package algorithm.dp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFindScores {
  
  @Parameters
  public static Collection<Object[]> data() {
    Object[][] data = {{1, 0}, {1, 1}, {2, 2}, {3, 3}, {5, 4}, {9, 5}, {15, 6}};
    return Arrays.asList(data);
  }
  
  private static FindScores sc;
  
  @BeforeClass
  public static void setup() {
    sc = new FindScores();
  }
  
  private int expected;
  private int n;
  
  public TestFindScores(int expected, int n) {
    this.expected = expected;
    this.n = n;
  }
  
  @Test
  public void testFindScores() {
    assertEquals(expected, sc.findScores(n));
  }

}
