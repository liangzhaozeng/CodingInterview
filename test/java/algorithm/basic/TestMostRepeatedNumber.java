package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestMostRepeatedNumber {
  
  @Test
  public void testMostRepeatedNumber() {
    int[] arr = {2, 2, 2, 3, 3, 4, 5, 6, 6, 6, 7, 7, 7};
    Map<Integer, Integer> hist = new HashMap<Integer, Integer>();
    
    int size = 100000;
    for (int i = 0; i < size; ++i) {
      int res = MostRepeatedNumber.mostRepeatedNumber(arr);
      Integer count = hist.get(res);
      if (count == null) {
        count = 0;
      }
      ++count;
      hist.put(res, count);
    }
    
    for (Map.Entry<Integer, Integer> entry : hist.entrySet()) {
      assertEquals(1.0 / 3, (double)entry.getValue() / size, 0.01);
    }
  }

}
