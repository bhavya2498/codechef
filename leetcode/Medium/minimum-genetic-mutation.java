// Problem: Minimum Genetic Mutation
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/minimum-genetic-mutation/
// Solved on: 2026-11-01T06:19:27.226Z


import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                char[] chars = current.toCharArray();

                for (int j = 0; j < 8; j++) {
                    char original = chars[j];

                    for (char gene : genes) {
                        if (gene == original) continue;

                        chars[j] = gene;
                        String next = new String(chars);

                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    chars[j] = original;
                }
            }

            mutations++;
        }

        return -1;
    }
}
