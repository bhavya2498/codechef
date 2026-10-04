// Problem: Game Play Analysis I
// Platform: leetcode
// Rating/Difficulty: Easy
// Language: mysql
// Verdict: Accepted
// URL: https://leetcode.com/problems/game-play-analysis-i/
// Solved on: 2026-10-04T13:57:10.418Z

# Write your MySQL query statement below
SELECT player_id, MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;
