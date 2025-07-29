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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int newVal = l1.val+ l2.val;
        int carry = newVal/10;
        newVal = newVal%10;
    
        ListNode head = new ListNode(newVal);
  
        ListNode node = head;
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1!=null && l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            newVal = val1+val2+carry;
            carry = newVal/10;
            newVal = newVal%10;

            ListNode temp = new ListNode(newVal);
            node.next = temp;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int val1 = l1.val;
            newVal = val1+carry;
            carry = newVal/10;
            newVal = newVal%10;

            ListNode temp = new ListNode(newVal);
            node.next = temp;
            node = node.next;
            l1 = l1.next;
        }

        while(l2!=null){
            int val2 = l2.val;
            newVal = val2+carry;
            carry = newVal/10;
            newVal = newVal%10;

            ListNode temp = new ListNode(newVal);
            node.next = temp;
            node = node.next;
            l2 = l2.next;
        }

        if(carry!=0){
            ListNode temp = new ListNode(carry);
            node.next = temp;

        }

        return head;
    }
}