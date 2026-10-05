// Problem: CRITLIST
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/linked-lists-new/LINKEDP04/problems/CRITLIST
// Solved on: 2026-10-05T12:52:16.821Z

class Solution {
    static int solve(Node head) {
        int count = 0;

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.next != null) {
            Node next = curr.next;

            if (curr.val > prev.val && curr.val > next.val) {
                count++;
            }
            else if (curr.val < prev.val && curr.val < next.val) {
                count++;
            }

            prev = curr;
            curr = next;
        }

        return count;
    }
}