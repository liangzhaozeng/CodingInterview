package algorithm.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStackWithMin {
  
  @Test
  public void testStackWithMin() {
    StackWithMin stack = new StackWithMin();
    stack.push(10);
    assertEquals(10, stack.getMin());
    
    stack.push(20);
    assertEquals(10, stack.getMin());
    
    stack.push(30);
    assertEquals(10, stack.getMin());
    
    stack.push(5);
    assertEquals(5, stack.getMin());
    
    stack.pop();
    assertEquals(10, stack.getMin());
    
    stack.push(5);
    stack.push(3);
    assertEquals(3, stack.getMin());
    
    stack.pop();
    assertEquals(5, stack.getMin());
    stack.pop() ;
    assertEquals(10, stack.getMin());
  }

}
