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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (ListNode li : lists) {
    if (li != null) pq.offer(li);
}
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            node.next = temp;
            node = node.next;
            if (temp.next != null) pq.offer(temp.next);
        }

        return head.next;
    }
}