// Problem: Circular Array Loop
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/circular-array-loop/
// Solved on: 2026-11-01T06:27:31.108Z


class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int slow = i;
            int fast = i;

            boolean forward = nums[i] > 0;

            while (true) {

                slow = nextIndex(nums, slow, forward);

                if (slow == -1) {
                    break;
                }

                fast = nextIndex(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                fast = nextIndex(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int current, boolean forward) {
        boolean currentForward = nums[current] > 0;

        // Direction must remain the same
        if (currentForward != forward) {
            return -1;
        }

        int n = nums.length;

        // Calculate circular next index
        int next = ((current + nums[current]) % n + n) % n;

        // Self-loop is not allowed
        if (next == current) {
            return -1;
        }

        return next;
    }
}
