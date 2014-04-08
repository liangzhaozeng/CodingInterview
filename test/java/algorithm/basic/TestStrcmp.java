package algorithm.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStrcmp {
  
  @Test
  public void testStrcmp() {
    Strcmp cmp = new Strcmp();
    String s11 = "abcdedf";
    String s12 = "abcdedf";
    
    assertEquals(0, cmp.strcmp(s11, s12));
    
    String s21 = "abcdef";
    String s22 = "abcdefg";
    
    assertEquals(-1, cmp.strcmp(s21, s22));
    
    String s31 = "babcdef";
    String s32 = "aabcdefg";
    
    assertEquals(1, cmp.strcmp(s31, s32));
  }

}
