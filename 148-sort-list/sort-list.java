/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        ListNode mid = slow;

        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(rightHead);

        ListNode mergeLL = new ListNode(-1);
        ListNode temp = mergeLL;

        while(newLeft != null && newRight != null) {
            if(newLeft.val <= newRight.val) {
                temp.next = newLeft;
                newLeft = newLeft.next;
                temp = temp.next;
            } else {
                temp.next = newRight;
                newRight = newRight.next;
                temp = temp.next;
            }
        }

        while(newLeft != null ) {
            temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
        }
        while(newRight != null) {
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }
        return mergeLL.next;
 
    }
}