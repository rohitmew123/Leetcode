/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp = headA;
        int length = 0;

        while(temp != null) {
            length++;
            temp = temp.next;
        }
       
        ListNode temp2 = headB;
        int length2 = 0;
        while(temp2 != null) {
            length2++;
            temp2 = temp2.next;
        }

        int diff = Math.abs(length - length2);

        if(length > length2) {
            while(diff > 0) {
                headA = headA.next;
                diff--;
            }

        } else {
            while(diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
    
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
        
    }
}