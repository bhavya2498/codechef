// Problem: Flatten a Multilevel Doubly Linked List
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
// Solved on: 2026-11-03T17:37:03.898Z


class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {

                Node nextNode = curr.next;

                Node childHead = flatten(curr.child);

                curr.next = childHead;
                childHead.prev = curr;

                curr.child = null;

                Node childTail = childHead;

                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                childTail.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = childTail;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
