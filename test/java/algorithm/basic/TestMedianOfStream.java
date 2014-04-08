package algorithm.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMedianOfStream {
  
  @Test
  public void testMedianOfStream() {
    MedianOfStream stream = new MedianOfStream();
    stream.add(3);
    assertEquals(3, stream.getMedian());
    stream.add(2);
    assertEquals(3, stream.getMedian());
    stream.add(1);
    assertEquals(2, stream.getMedian());
    stream.add(1);
    assertEquals(2, stream.getMedian());
    stream.add(5);
    assertEquals(2, stream.getMedian());
    stream.add(7);
    assertEquals(3, stream.getMedian());
    stream.add(9);
    assertEquals(3, stream.getMedian());
    stream.add(1);
    assertEquals(3, stream.getMedian());
    stream.add(1);
    assertEquals(2, stream.getMedian());
  }

}
