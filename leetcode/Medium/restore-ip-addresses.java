// Problem: Restore IP Addresses
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/restore-ip-addresses/
// Solved on: 2026-10-13T12:59:41.198Z


import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int index, int parts,
                           List<String> current, List<String> result) {
        if (parts == 4) {
            if (index == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }

            String part = s.substring(index, index + len);
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(part) > 255) {
                break;
            }

            current.add(part);

            backtrack(s, index + len, parts + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}
