// Problem: Word Search II
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/word-search-ii/
// Solved on: 2026-10-30T17:12:21.686Z


import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private TrieNode root;
    private List<String> result;
    private int rows, cols;

    public List<String> findWords(char[][] board, String[] words) {

        root = new TrieNode();
        result = new ArrayList<>();

        rows = board.length;
        cols = board[0].length;

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // Start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    // Insert words into Trie
    private void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    // DFS + Backtracking
    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // Boundary check
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        char ch = board[r][c];

        // Already visited or character not in Trie
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Complete word found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark cell as visited
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r - 1, c, node); // Up
        dfs(board, r + 1, c, node); // Down
        dfs(board, r, c - 1, node); // Left
        dfs(board, r, c + 1, node); // Right

        // Backtrack: restore original character
        board[r][c] = ch;
    }
}
