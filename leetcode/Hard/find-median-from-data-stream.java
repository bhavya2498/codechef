// Problem: Find Median from Data Stream
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/find-median-from-data-stream/
// Solved on: 2026-10-30T17:16:36.379Z


import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {

    PriorityQueue<Integer> small; // Max heap
    PriorityQueue<Integer> large; // Min heap

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to max heap first
        small.offer(num);

        // Move largest from small to large
        large.offer(small.poll());

        // Balance the heaps
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (small.size() > large.size()) {
            return small.peek();
        }

        // Even number of elements
        return (small.peek() + (double) large.peek()) / 2.0;
    }
}
