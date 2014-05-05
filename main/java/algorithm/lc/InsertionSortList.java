package algorithm.lc;

public class InsertionSortList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // O(1) space, O(n^2) time
  public class Solution {
	  
	  public ListNode insertionSortList2(ListNode head) {
	        if (head == null || head.next == null)
	         return head;
	         
	         ListNode fakeHead = new ListNode(0);
	         fakeHead.next = head;
	        
	         ListNode working = head.next;
	         head.next = null;
	         while (working!=null) {
	             ListNode cur = fakeHead.next;
	             ListNode prev = fakeHead;
	             boolean found = false;
	             while (cur != null) {
	                 if (cur.val > working.val) {
	                     prev.next = working;
	                     working = working.next;
	                     prev.next.next = cur;
	                     found = true;
	                     break;
	                 } else {
	                     prev = cur;
	                     cur = cur.next;
	                 }
	             }
	             if(!found) {
	                 prev.next = working;
	               
	                 working = working.next;
	                 prev.next.next = null;
	             }
	         }
	         
	         return fakeHead.next;
	         
	    }  
	  
	  
    public ListNode insertionSortList(ListNode head) {
      // IMPORTANT: Please reset any member data you declared, as
      // the same Solution instance will be reused for each test case.
      ListNode fakeHead = new ListNode(0);
      fakeHead.next = head;
      ListNode sorted = fakeHead;

      while (sorted.next != null) {
        ListNode prev = sorted;
        ListNode cur = prev.next;
        ListNode minNode = cur;
        ListNode minPrev = prev;
        
        while (cur != null) { // find the min from the remaining list
          if (cur.val < minNode.val) {
            minNode = cur;
            minPrev = prev;
          }
          prev = cur;
          cur = cur.next;
        }
        
        if (sorted.next != minNode) {
          ListNode sortedNext = sorted.next;
          sorted.next = minNode;
          minPrev.next = minNode.next;
          minNode.next = sortedNext;
        }

        sorted = sorted.next;
      }

      return fakeHead.next;
    }
  }

}
