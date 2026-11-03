// Problem: Delete Node in a Linked List
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/delete-node-in-a-linked-list/
// Solved on: 2026-11-03T15:48:44.672Z


class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }
}
