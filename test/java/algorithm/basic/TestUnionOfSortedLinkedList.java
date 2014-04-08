package algorithm.basic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import algorithm.basic.UnionOfSortedLinkedList.ListNode;

public class TestUnionOfSortedLinkedList {
  
  @Test
  public void testUnionOfSortedLinkedList() {
    UnionOfSortedLinkedList union = new UnionOfSortedLinkedList();
    
    ListNode empty = null;
    ListNode one = new ListNode(1);
    assertEquals(new ArrayList<Integer>(), union.unionOfSortedLinkedList(empty, one));
    
    
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(3);
    head1.next.next = new ListNode(5);
    head1.next.next.next = new ListNode(8);
    head1.next.next.next.next = new ListNode(11);
    
    ListNode head2 = new ListNode(2);
    head2.next = new ListNode(5);
    head2.next.next = new ListNode(11);
    head2.next.next.next = new ListNode(12);
    head2.next.next.next.next = new ListNode(15);
    
    List<Integer> exp = new ArrayList<Integer>();
    exp.add(5);
    exp.add(11);
    assertEquals(exp, union.unionOfSortedLinkedList(head1, head2));
    
  }

}
