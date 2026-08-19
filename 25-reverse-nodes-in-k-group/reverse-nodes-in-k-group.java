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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes remaining
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        // Not enough nodes left — leave as is
        if (count < k) {
            return head;
        }

        // node now points to the (k+1)-th node — start of the next group
        // Reverse the current k nodes
        ListNode prev = reverseKGroup(node, k); // recursively process the rest first
        ListNode curr = head;
        while (count > 0) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            count--;
        }

        return prev;
    }
}