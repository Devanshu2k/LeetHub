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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null|| k==0)
            return head;
        ListNode dummy = new ListNode();

        dummy.next = head;

        int size=0;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            size++;
            fast = fast.next;
        }
        
        k = k%size;
        if(size==k || k==0)
            return head;
        fast = head;

        for(int i=0;i<k;i++){
            fast = fast.next;
        }

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        dummy.next = slow.next;
        fast.next = head;
        slow.next = null;

        return dummy.next;
    }
}