// Problem: Simplify Path
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/simplify-path/
// Solved on: 2026-10-30T04:07:31.639Z


import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Move to parent directory
            else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Valid directory name
            else {
                stack.push(part);
            }
        }

        // Construct simplified path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
