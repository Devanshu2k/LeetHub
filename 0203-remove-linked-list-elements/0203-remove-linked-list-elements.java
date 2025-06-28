class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Step 1: Handle leading nodes with value == val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // Step 2: Remove nodes with value == val from the rest of the list
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next; // skip
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
