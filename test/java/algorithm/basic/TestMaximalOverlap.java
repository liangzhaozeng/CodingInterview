package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import algorithm.basic.MaximalOverlap.Interval;

public class TestMaximalOverlap {
  
  @Test
  public void testMaximalOverlap() {
    List<Interval> intervals = new ArrayList<Interval>();
    intervals.add(new Interval(0, 5));
    intervals.add(new Interval(2, 6));
    intervals.add(new Interval(3, 7));
    intervals.add(new Interval(5, 9));
    intervals.add(new Interval(0,10));
    
    MaximalOverlap overlap = new MaximalOverlap();
    assertEquals(4, overlap.maximalOverlapped(intervals));
    
    intervals.add(new Interval(5, 8));
    intervals.add(new Interval(5, 11));
    intervals.add(new Interval(6, 9));
    intervals.add(new Interval(6, 10));
    intervals.add(new Interval(7, 8));
    
    assertEquals(7, overlap.maximalOverlapped(intervals));
  }

}
