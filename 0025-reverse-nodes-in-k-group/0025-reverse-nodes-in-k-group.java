class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            // Step 1: Check if k nodes exist
            ListNode temp = curr;
            for (int i = 0; i < k; i++) {
                if (temp == null)
                    return dummy.next;
                temp = temp.next;
            }

            // Step 2: Reverse k nodes
            ListNode prev = null, next = null, tail = curr;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 3: Connect reversed group
            prevGroupEnd.next = prev;  // new start
            tail.next = curr;          // connect to next part

            prevGroupEnd = tail;       // move group pointer
        }
    }
}
