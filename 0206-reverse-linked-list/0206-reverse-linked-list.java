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