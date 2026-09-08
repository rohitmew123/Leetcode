/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null ) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;


        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {

                while(ptr != slow) {
                    slow = slow.next;
                    ptr = ptr.next;

                }
                return ptr;
      
            }
            
        }
        return null;
        
    }
}