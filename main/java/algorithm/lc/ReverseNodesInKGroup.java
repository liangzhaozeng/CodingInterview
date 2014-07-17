package algorithm.lc;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 */
// O(1) space, O(n) time
public class ReverseNodesInKGroup {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || head.next == null || k<2) return head;
        ListNode cur = head;
        for (int i = 0; i<k; i ++) {
            if (cur == null) return head;
            cur = cur.next;
        }
        
        ListNode nextHead  = null;
        if (cur != null) {
           nextHead = reverseKGroup3(cur, k);
        }
        cur = head;
        for (int i = 0; i < k; i ++){
            ListNode next = cur.next;
            cur.next = nextHead;
            nextHead = cur;
            cur = next;
        }
        return nextHead;
    }

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2 || head == null || head.next == null)
			return head;
		ListNode nextGroup = head;
		for (int i = 0; i < k; i++) {
			if (nextGroup != null)
				nextGroup = nextGroup.next;
			else
				return head;
		}

		ListNode newNextGroup = reverseKGroup(nextGroup, k);
		ListNode prev = null;
		ListNode cur = head;
		while (cur != nextGroup) {
			ListNode next = cur.next;
			cur.next = (prev != null) ? prev : newNextGroup;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		reverseKGroup(n1, 3);

	}

	public ListNode reverseKGroup2(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;

		ListNode cur = head;
		ListNode prevGroupTail = fakeHead;
		while (cur != null) {
			// find the tail of current group
			int count = 1;
			ListNode groupHead = cur;
			ListNode groupTail = cur;
			while (groupTail.next != null && count < k) {
				groupTail = groupTail.next;
				++count;
			}
			if (count < k) {
				prevGroupTail.next = groupHead;
				break; // reach the end of list
			}
			// reverse group
			ListNode groupPrev = null;
			for (int i = 0; i < k; ++i) {
				ListNode next = cur.next;
				cur.next = groupPrev;
				groupPrev = cur;
				cur = next;
			}
			// update inter-group links
			prevGroupTail.next = groupTail;
			prevGroupTail = groupHead;
		}

		return fakeHead.next;
	}
}
