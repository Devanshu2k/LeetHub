class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode curr;
        if (list1.val > list2.val) {
            curr = list2;
            list2 = list2.next; // Advance the smaller list
        } else {
            curr = list1;
            list1 = list1.next; // Advance the smaller list
        }

        // Call the recursive helper
        curr.next = sort(list1, list2);
        return curr;
    }

    ListNode sort(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val > list2.val) {
            list2.next = sort(list1, list2.next); // Move to the next node in list2
            return list2;
        } else {
            list1.next = sort(list1.next, list2); // Move to the next node in list1
            return list1;
        }
    }
}
