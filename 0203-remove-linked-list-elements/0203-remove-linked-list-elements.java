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
    public ListNode removeElements(ListNode head, int val) {
       if(remove(head,val)){
            head = head.next;
        }

        return head;
    }

    boolean remove(ListNode head,int val){
        if(head==null)
            return false;
        
        if(remove(head.next,val)){
            head.next = head.next.next;
        }

        return head.val==val;
    }
}