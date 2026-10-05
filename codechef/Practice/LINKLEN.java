// Problem: LINKLEN
// Platform: codechef
// Language: Java​
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/linked-lists-new/LINKEDP04/problems/LINKLEN
// Solved on: 2026-10-05T12:54:13.226Z

static int getLength(Node head) {
    int count = 0;

    while (head != null) {
        count++;
        head = head.next;
    }

    return count;
}