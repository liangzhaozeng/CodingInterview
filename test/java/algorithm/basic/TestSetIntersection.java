package algorithm.basic;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSetIntersection {
  
  @Test
  public void testSetIntersection() {
    
    List<Integer> first = new ArrayList<Integer>();
    for (int i = 0; i < 10000; ++i) {
      first.add(i * 17);
    }
    
    List<Integer> second = new ArrayList<Integer>();
    for (int i = 0; i < 1000; ++i) {
      second.add(i * 3);
    }
    
    List<Integer> joined = new ArrayList<Integer>();
    for (int i = 0; i < joined.size(); ++i) {
      assertTrue(joined.get(i) % 51 == 0);
    }
    
  }

}
