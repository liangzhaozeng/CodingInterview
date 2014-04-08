package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestPrimeFactors {
  
  @Test
  public void testPrimeFactors() {
    PrimeFactors factors = new PrimeFactors();
    
    int n0 = 0;
    List<Integer> prime0 = new ArrayList<Integer>();
    assertEquals(prime0, factors.primeFactor(n0));
    
    int n1 = 204;
    List<Integer> prime1 = new ArrayList<Integer>();
    prime1.add(2);
    prime1.add(2);
    prime1.add(3);
    prime1.add(17);
    assertEquals(prime1, factors.primeFactor(n1));
    
    int n2 = 1020;
    List<Integer> prime2 = new ArrayList<Integer>();
    prime2.add(2);
    prime2.add(2);
    prime2.add(3);
    prime2.add(5);
    prime2.add(17);
    assertEquals(prime2, factors.primeFactor(n2));
  }

}
