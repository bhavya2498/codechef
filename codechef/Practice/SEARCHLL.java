// Problem: SEARCHLL
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/linked-lists-new/LINKEDP04/problems/SEARCHLL
// Solved on: 2026-10-06T15:40:27.630Z

static Node removeKey(Node head, int key) {
    while (head != null && head.data == key) {
        head = head.next;
    }

    Node curr = head;

    while (curr != null && curr.next != null) {
        if (curr.next.data == key) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }

    return head;
}