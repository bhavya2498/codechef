// Problem: Course Schedule
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/course-schedule/
// Solved on: 2026-10-30T17:11:18.270Z


import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Calculate indegree of each course
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Add courses with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process courses using BFS
        int completed = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            completed++;

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // All courses must be completed
        return completed == numCourses;
    }
}
