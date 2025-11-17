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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow.next);
        slow.next = newHead;

        ListNode node = head;

        while(newHead!=null){
            if(newHead.val!=node.val)
                return false;
            
            newHead = newHead.next;
            node = node.next;

        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode front = head;
        ListNode node = head;
        ListNode back = null;

        while(node!=null){
            front = node.next;
            node.next = back;
             back = node;
            node = front;
           
        }

        return back;

    }
}