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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode newHead = head.next;

        ListNode node = head;
        ListNode prev = null;
        while(node!=null && node.next!=null){
            
            ListNode temp = node.next;
            node.next = temp.next;
            temp.next = node;
            if(prev!=null)
                prev.next = temp;
            prev = node;
            node = node.next;
        }

        return newHead;
    }
}