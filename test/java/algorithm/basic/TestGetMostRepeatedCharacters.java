package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestGetMostRepeatedCharacters {
  
  @Test
  public void testGetMostRepeatedCharacters() {
    GetMostRepeatedCharacters rep = new GetMostRepeatedCharacters();
    
    String s1 = "this is a sentence";
    List<Character> exp1 = new ArrayList<Character>();
    for (char ch : "this is a sentence".toCharArray()) {
      if (ch != ' ') {
        exp1.add(ch);
      }
    }
    assertEquals(exp1, rep.getMostRepeatedCharacters(s1));
    
    String s2 = "thiss iiss a sentence";
    List<Character> exp2 = new ArrayList<Character>();
    for (char ch : "sis".toCharArray()) {
      if (ch != ' ') {
        exp2.add(ch);
      }
    }
    assertEquals(exp2, rep.getMostRepeatedCharacters(s2));
  }

}
