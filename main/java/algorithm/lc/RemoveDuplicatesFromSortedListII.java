package algorithm.lc;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 */
// O(1) space, O(n) time
public class RemoveDuplicatesFromSortedListII {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
	  
	  public ListNode deleteDuplicates2(ListNode head) {
	        if (head ==null || head.next==null) {
	        	return head;
	        }
	        ListNode p = head.next;
	        if (head.val == p.val) {
	        	while(p!=null && head.val== p.val) {
	        
	        		p = p.next;
	        	}
	        	return deleteDuplicates2(p);
	        } else {
	        	head.next = deleteDuplicates2(head.next);
	        	return head;
	        }
	    }
	  
	  
	  
    // use three pointer
    // when current pointer equals to next pointer, move forward until no
    // duplicate
    public ListNode deleteDuplicates(ListNode head) {
      // Start typing your Java solution below
      // DO NOT write main() function
      ListNode newHead = new ListNode(0);
      ListNode prev = newHead;
      ListNode cur = head;

      while (cur != null) {
        boolean hasDuplicate = false;
        int val = cur.val;
        while (cur.next != null && cur.next.val == val) { // skip duplicate
          cur = cur.next;
          hasDuplicate = true;
        }
        if (hasDuplicate) {
          cur = cur.next;
        } else { // grow
          prev.next = cur;
          prev = cur;
          cur = cur.next;
          prev.next = null;
        }
      }
      return newHead.next;
    }
  }

}
