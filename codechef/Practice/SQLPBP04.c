// Problem: SQLPBP04
// Platform: codechef
// Language: ┌─────────────┬───────┐
│ player_name │ score │
├─────────────┼───────┤
│ David       │ 1600  │
│ Bob         │ 1500  │
│ Charlie     │ 1300  │
└─────────────┴───────┘
// Verdict: Accepted
// URL: https://www.codechef.com/practice/course/sql-case-studies-topic-wise/SQLBP01/problems/SQLPBP04
// Solved on: 2026-10-03T17:39:01.956Z

SELECT p.player_name, p.score
FROM Players p
JOIN Matches m
    ON p.player_name = m.winner
GROUP BY p.player_name, p.score
ORDER BY p.score DESC
LIMIT 3;