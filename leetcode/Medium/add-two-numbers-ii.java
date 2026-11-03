// Problem: Add Two Numbers II
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/add-two-numbers-ii/
// Solved on: 2026-11-03T17:38:39.893Z


import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Push digits of first linked list
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        // Push digits of second linked list
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;

        // Add digits from right to left
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {

            int sum = carry;

            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            carry = sum / 10;
            int digit = sum % 10;

            // Insert new node at the beginning
            ListNode newNode = new ListNode(digit);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
}
