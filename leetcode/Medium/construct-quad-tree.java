// Problem: Construct Quad Tree
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/construct-quad-tree/
// Solved on: 2026-10-30T17:27:42.526Z


/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node(boolean val, boolean isLeaf,
                Node topLeft, Node topRight,
                Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        // Check whether this region contains the same value
        boolean same = true;
        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        // If all values are equal, create a leaf
        if (same) {
            return new Node(value == 1, true);
        }

        // Divide the region into four quadrants
        int half = size / 2;

        Node topLeft = build(grid, row, col, half);

        Node topRight = build(grid, row, col + half, half);

        Node bottomLeft = build(grid, row + half, col, half);

        Node bottomRight = build(grid, row + half, col + half, half);

        return new Node(
            true,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}
