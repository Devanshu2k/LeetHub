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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode front = slow.next;
        ListNode endFront = reverse(front);
        slow.next = null;

        slow = head;

        while(slow!=null && endFront!=null){
            ListNode temp = slow.next;
            slow.next = endFront;
            ListNode temp2 = endFront.next;
            endFront.next = temp;

            endFront = temp2;
            slow = temp;
        }
    }

    ListNode reverse(ListNode node){
        if(node==null || node.next==null)
            return node;
        
        ListNode newHead = reverse(node.next);
        ListNode front = node.next;

        front.next = node;
        node.next = null;
        return newHead;
    }


}