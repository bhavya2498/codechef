// Problem: Generate Random Point in a Circle
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/generate-random-point-in-a-circle/
// Solved on: 2026-11-01T07:29:59.177Z


class Solution {
    double radius;
    double x_center;
    double y_center;
    Random rand = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double angle = 2 * Math.PI * rand.nextDouble();
        double r = radius * Math.sqrt(rand.nextDouble());

        double x = x_center + r * Math.cos(angle);
        double y = y_center + r * Math.sin(angle);

        return new double[]{x, y};
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */