// Problem: PREP55
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/linked-lists-new/LINKEDP04/problems/PREP55
// Solved on: 2026-10-05T12:50:57.588Z

class Solution {
    Node removeDuplicates(Node head) {
        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}