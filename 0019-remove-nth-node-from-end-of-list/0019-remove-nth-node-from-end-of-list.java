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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
            
        ListNode temp = new ListNode(-1,head);
        ListNode back = temp;
        ListNode front = temp;

        while(n!=0 && front!=null){
            front = front.next;
            n--;
        }

        if(n!=0)
            return temp.next;
        
        while(front!=null && front.next!=null){
            back = back.next;
            front = front.next;
        }

        back.next = back.next.next;

        return temp.next;
        

    }
}